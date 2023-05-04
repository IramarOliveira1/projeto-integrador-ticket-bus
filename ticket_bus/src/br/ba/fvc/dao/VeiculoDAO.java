package br.ba.fvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.ba.fvc.database.connection.ConnectionMysql;

public class VeiculoDAO {
	Connection connection = null;

	public VeiculoDAO() {
		this.connection = new ConnectionMysql().getConnectionMysql();
	}

	public ResultSet verifyNumeroExists(String numero, String placa) {
		ResultSet result = null;

		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT numero, placa FROM veiculo WHERE numero = " + "'" + numero + "' OR placa = '" + placa
					+ "' ";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
}
