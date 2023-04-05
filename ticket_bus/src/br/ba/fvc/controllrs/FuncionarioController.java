package br.ba.fvc.controllrs;

import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.dao.FuncionarioDAO;

public class FuncionarioController {

	private String nome;
	private String cpf;
	private String cargo;
	private String email;
	private String senha;
	private GenericController generic;
	private FuncionarioDAO dao;
	private String table = "Usuario";
	public String[] columns = {"Nome", "CPF", "Email", "Cargo" };
	private String fields = "nome, cpf, email, cargo, senha";

	public FuncionarioController() {
		this.generic = new GenericController();
		this.dao = new FuncionarioDAO();
	}

	public ResultSet login() {
		ResultSet result = null;
		try {

			result = this.dao.login(email, senha);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public DefaultTableModel listar() {
		DefaultTableModel result = null;
		System.out.println(this.columns[0]);
		result = this.generic.all(this.table, this.columns, this.fields);

		return result;
	}

	public void incluir() {
		ResultSet result = null;
		try {

			result = this.dao.verifyCpfExists(cpf, email);

			if (result.next()) {
				if (result.getString("email").equals(email)) {
					throw new Exception("Email já cadastrado!");
				} else {
					throw new Exception("CPF já cadastrado!");
				}
			}

			Object[] data = { nome, cpf, email, cargo, senha };
			this.generic.store(this.table, this.fields, data);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
