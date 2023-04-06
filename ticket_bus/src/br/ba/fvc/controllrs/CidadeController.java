package br.ba.fvc.controllrs;


import javax.swing.table.DefaultTableModel;

public class CidadeController {



    private String nome;
    private String uf;

    private GenericController generic;

    private String table = "Cidade";
    public String[] columns = { "Nome", "UF" };
    private String fields = "nome, uf";

    public CidadeController() {
        this.generic = new GenericController();

    }

    public DefaultTableModel listar() {
        DefaultTableModel result = null;

        result = this.generic.all(this.table, this.columns, this.fields);

        return result;
    }

}