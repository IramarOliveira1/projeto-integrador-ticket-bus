package br.ba.fvc.controllrs;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import br.ba.fvc.dao.GenericDAO;

public class GenericController {

	public GenericDAO dao;
	private DefaultTableModel tableModel;

	public GenericController(String table, String[] columns, String fields) {
		this.dao = new GenericDAO(table, fields);
		this.tableModel = new DefaultTableModel(null, columns);
	}

	public DefaultTableModel all() {
		ResultSet result = null;
		try {
			result = this.dao.all();

			this.addRow(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.tableModel;
	}

	public DefaultTableModel store(Object[] data) {
		StringBuilder addQuotationMarks = new StringBuilder();
		try {
			for (Object values : data) {
				addQuotationMarks.append("'" + values + "'" + ",");
			}
			addQuotationMarks.deleteCharAt(addQuotationMarks.length() - 1);

			this.dao.store(addQuotationMarks);

			this.tableModel = this.all();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.tableModel;
	}

	public DefaultTableModel filter(String[] fieldsFilter, String values) {
		ResultSet result = null;
		try {

			result = this.dao.filter(fieldsFilter, values);

			this.addRow(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.tableModel;
	}

	public DefaultTableModel destroy(String id) {
		try {
			this.dao.destroy(id);
			this.tableModel = this.all();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.tableModel;
	}

	public ResultSet index(String id) {
		ResultSet result = null;
		try {

			result = this.dao.index(id);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return result;
	}

	public DefaultTableModel update(Object[] data, String id) {
		ResultSet result = null;
		StringBuilder addQuotationMarks = new StringBuilder();
		try {

			Object[] testando = { "teste", "testando", "agora", "vai", "nos" };

//			 String campos = "nome, cpf, email, cargo, senha";
			HashMap<Object, Object> mp = new HashMap<>();

				

				for (Object values : data) {
					mp.put(testando[0], values);
//					addQuotationMarks.append(mp.keySet() + " = '" + mp.values() + "'" + ",");
				}

//			System.out.println(addQuotationMarks);
//			

//			 String campos = "nome, cpf, email, cargo, senha";
//			
//			for (Object values : data) {
//				addQuotationMarks.append(campos + " = '" + values + "'" + ",");
//			}
//

//			result = this.index(id);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return this.tableModel;
	}

	public void addRow(ResultSet result) {
		this.tableModel.setRowCount(0);
		try {
			while (result.next()) {
				Object[] row = new Object[result.getMetaData().getColumnCount()];

				for (int i = 0; i < row.length; i++) {
					row[i] = result.getObject(i + 1);
				}
				this.tableModel.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}