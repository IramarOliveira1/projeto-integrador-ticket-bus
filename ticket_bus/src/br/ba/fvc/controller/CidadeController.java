package br.ba.fvc.controller;


import javax.swing.table.DefaultTableModel;

public class CidadeController {

    private String nome;
    private String uf;

    private GenericController generic;

    private String tabela = "Cidade";
    public String[] colunas = { "ID", "Nome", "UF" };
    private String campos = "nome, uf";

    public CidadeController() {
        this.generic = new GenericController(tabela, colunas, campos);

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

}