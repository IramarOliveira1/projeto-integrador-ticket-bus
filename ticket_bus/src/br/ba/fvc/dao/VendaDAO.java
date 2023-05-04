package br.ba.fvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.ba.fvc.database.connection.ConnectionMysql;

public class VendaDAO {

	Connection connection = null;

	public VendaDAO() {
		this.connection = new ConnectionMysql().getConnectionMysql();
	}

	public ResultSet allSale() {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT venda.id, venda.nome_passageiro, venda.cpf, origem.nome, destino.nome, "
					+ " DATE_FORMAT(rota.data_partida, '%d/%m/%Y %T') AS data_formatada FROM venda "
					+ " INNER JOIN rota ON venda.id_rota = rota.id"
					+ " INNER JOIN cidade AS origem ON rota.cidade_origem = origem.id"
					+ " INNER JOIN cidade AS destino ON rota.cidade_destino = destino.id ORDER BY venda.id ASC";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public ResultSet getComboBox() {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT rota.id,  "
					+ "CONCAT(origem.nome , ' / ', destino.nome, ' - ', DATE_FORMAT(rota.data_partida, '%d/%m/%Y %T')) rota ,rota.valor_passagem FROM rota "
					+ " INNER JOIN cidade AS origem ON rota.cidade_origem = origem.id"
					+ " INNER JOIN cidade AS destino ON rota.cidade_destino = destino.id"
					+ " WHERE rota.data_partida >= CURRENT_TIMESTAMP()";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public ResultSet loadComboBox(String id) {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT rota.id, rota.id_veiculo, DATE_FORMAT(rota.data_partida, '%d/%m/%Y %T') AS data_formatada , rota.valor_passagem FROM rota "
					+ "WHERE rota.id = " + id;

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result;
	}

	public ResultSet where(String table, String field, String value) {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT * FROM " + table + " WHERE " + field + " = " + "'" + value + "'";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public ResultSet verifyArmchairExists(String poltrona, String numero) {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT venda.id, venda.poltrona, veiculo.id, veiculo.quantidade_poltronas FROM venda "
					+ "INNER JOIN rota ON venda.id_rota = rota.id "
					+ "INNER JOIN veiculo ON rota.id_veiculo = veiculo.id " + " WHERE venda.poltrona = " + poltrona
					+ " AND veiculo.numero = " + numero + " AND rota.data_partida >= CURRENT_TIMESTAMP()";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public ResultSet getSale(String id) {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT DATE_FORMAT(rota.data_partida, '%d/%m/%Y %T') AS hora_data, venda.cpf, venda.nome_passageiro, origem.nome AS origem , destino.nome AS destino, veiculo.numero, venda.poltrona FROM venda "
					+ "INNER JOIN rota ON venda.id_rota = rota.id "
					+ "INNER JOIN cidade AS origem ON rota.cidade_origem = origem.id "
					+ "INNER JOIN cidade AS destino ON rota.cidade_destino = destino.id "
					+ "INNER JOIN veiculo ON rota.id_veiculo = veiculo.id " + "WHERE venda.id = " + id;

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public ResultSet filterRouter(String router) {
		ResultSet result = null;

		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT venda.id, venda.nome_passageiro, venda.cpf, origem.nome, destino.nome, "
					+ "DATE_FORMAT(rota.data_partida, '%d/%m/%Y %T') AS data_formatada FROM venda "
					+ "INNER JOIN rota ON venda.id_rota = rota.id "
					+ "INNER JOIN cidade AS origem ON rota.cidade_origem = origem.id "
					+ "INNER JOIN cidade AS destino ON rota.cidade_destino = destino.id " + "WHERE origem.nome LIKE "
					+ "'%" + router + "%'";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public ResultSet filterPeriod(String de, String ate) {
		ResultSet result = null;

		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT SUM(rota.valor_passagem) AS valor_total FROM venda "
					+ "INNER JOIN rota ON venda.id_rota = rota.id "
					+ "WHERE  DATE_FORMAT(rota.data_partida, '%Y-%m-%d') BETWEEN '" + de + "' AND '" + ate + "'";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
}
