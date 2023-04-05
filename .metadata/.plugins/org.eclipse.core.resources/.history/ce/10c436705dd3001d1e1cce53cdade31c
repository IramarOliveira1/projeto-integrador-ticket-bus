package br.ba.fvc.controllrs;

import java.sql.ResultSet;

import br.ba.fvc.dao.LoginDAO;

public class LoginController {

	private LoginDAO dao;
	private String nome;
	private String cargo;
	private String email;
	private String senha;

	public LoginController() {
		this.dao = new LoginDAO();
	}

	public ResultSet login() {
		ResultSet result = null;
		
		try {
			result = this.dao.loginDAO(this.getEmail(), this.getSenha());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
