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
        this.generic = new GenericController(this.columns);

    }

    public DefaultTableModel listar() {
        DefaultTableModel result = null;
		try {

			result = this.generic.all(this.table, this.fields);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
    }

}