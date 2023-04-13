package br.ba.fvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.ba.fvc.database.connection.ConnectionMysql;

public class GenericDAO {

	Connection connection = null;
	private String table;
	private String fields;

	public GenericDAO(String table, String fields) {
		this.connection = new ConnectionMysql().getConnectionMysql();
		this.table = table;
		this.fields = fields;
	}

	public ResultSet all() {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT id," + this.fields + " FROM " + this.table;

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public void store(Object values) {
		try {
			Statement instance = this.connection.createStatement();

			String query = "INSERT INTO " + this.table + "(" + this.fields + ") VALUES (" + values + ")";

			instance.execute(query);

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public ResultSet filter(String[] fieldsFilter, String values) {
		ResultSet result = null;

		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT id, nome, cpf, email, cargo FROM " + this.table + " WHERE " + fieldsFilter[0] + " = "
					+ "'" + values + "' OR " + fieldsFilter[1] + "  = '" + values + "' ";

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
	
	public ResultSet index(String id) {
		ResultSet result = null;
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT * FROM " + this.table + " WHERE id = " + id;

			result = instance.executeQuery(query);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
	}

	public void destroy(String id) {
		try {
			Statement instance = this.connection.createStatement();

			String query = "DELETE FROM " + this.table + " WHERE id = " + id;

			instance.execute(query);
			
			JOptionPane.showMessageDialog(null, "Item excluir com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
