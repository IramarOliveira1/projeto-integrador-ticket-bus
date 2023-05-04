package br.ba.fvc.controller;

import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.dao.VeiculoDAO;

public class VeiculoController {

	private String numero;
	private String placa;
	private String modelo;
	private String data_compra;
	private String quantidade_poltronas;
	private GenericController generic;
	private VeiculoDAO dao;
	private String tabela = "veiculo";
	private String[] coluna = { "ID", "Numero", "Placa", "Modelo", "Data Compra", "Qtd poltronas" };
	private String campos = "numero, placa, modelo, data_compra, quantidade_poltronas";

	public VeiculoController() {
		this.generic = new GenericController(tabela, coluna, campos);
		this.dao = new VeiculoDAO();
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
		ResultSet resultSet = null;

		try {

			resultSet = this.dao.verifyNumeroExists(numero, placa);

			if (resultSet.next()) {
				if (resultSet.getString("numero").equals(numero)) {
					throw new Exception("numero já cadastrado!");
				} else {
					throw new Exception("placa já cadastrada!");
				}
			}

			Object[] data = { numero, placa.toUpperCase(), modelo, data_compra, quantidade_poltronas };
			result = this.generic.store(data);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return result;
	}

	public DefaultTableModel filtrar() {
		DefaultTableModel result = null;
		try {

			String campo_filtro = "numero";

			result = this.generic.filter(campo_filtro, numero);
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
			Object[] fields = { "numero", "placa", "modelo", "data_compra", "quantidade_poltronas" };
			Object[] data = { numero, placa, modelo, data_compra, quantidade_poltronas };

			result = this.generic.update(fields, data, id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}

	public String getQuantidade_poltronas() {
		return quantidade_poltronas;
	}

	public void setQuantidade_poltronas(String quantidade_poltronas) {
		this.quantidade_poltronas = quantidade_poltronas;
	}

	public GenericController getGeneric() {
		return generic;
	}

	public void setGeneric(GenericController generic) {
		this.generic = generic;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String[] getColuna() {
		return coluna;
	}

	public void setColuna(String[] coluna) {
		this.coluna = coluna;
	}

	public String getCampos() {
		return campos;
	}

	public void setCampos(String campos) {
		this.campos = campos;
	}
}
