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
	private String tabela = "Usuario";
	private String[] coluna = { "ID", "Nome", "CPF", "Email", "Cargo" };
	private String campos = "nome, cpf, email, cargo, senha";
	private String[] campo_filtro = { "nome", "cpf" };

	public FuncionarioController() {
		this.generic = new GenericController(tabela, coluna, campos);
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
		try {
			result = this.generic.all();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public DefaultTableModel incluir() {
		DefaultTableModel result = null;
//		ResultSet resultSet = null;
		try {
//
//			resultSet = this.dao.verifyCpfExists(cpf, email);
//
//			if (resultSet.next()) {
//				if (resultSet.getString("cpf").equals(cpf)) {
//					throw new Exception("CPF jÃ¡ cadastrado!");
//				} else {
//					throw new Exception("Email jÃ¡ cadastrado!");
//				}
//			}
//
//			System.out.println("passei aqui");

			Object[] data = { nome, cpf, email, cargo, senha };
			result = this.generic.store(data);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public DefaultTableModel filtrar() {
		DefaultTableModel result = null;
		try {

			result = this.generic.filter(this.campo_filtro, nome);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public DefaultTableModel excluir(String id) {
		DefaultTableModel result = null;
		try {

			result = this.generic.destroy(id);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
	
	public ResultSet carregaCamposAlterar(String id) {
		ResultSet result = null;
		try {

			result = this.generic.index(id);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}
	
	public DefaultTableModel alterar(String id) {
		DefaultTableModel result = null;
		
		try {
			
			Object[] data = { nome, cpf, email, cargo, senha };
			
			result = this.generic.update(data, id);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return result;
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
