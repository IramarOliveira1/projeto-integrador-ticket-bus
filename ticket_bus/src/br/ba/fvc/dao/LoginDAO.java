package br.ba.fvc.dao;

import br.ba.fvc.database.connection.ConnectionMysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class LoginDAO {

	Connection connection = null;

	public LoginDAO() {
		this.connection = new ConnectionMysql().getConnectionMysql();
	}

	public ResultSet loginDAO(String email, String senha) {
		ResultSet result = null;
	
		try {
			Statement instance = this.connection.createStatement();

			String query = "SELECT * FROM Usuario WHERE email =  '" + email + "' AND senha = '" + senha + "' ";

			result = instance.executeQuery(query);

			return result;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result;

	}

}