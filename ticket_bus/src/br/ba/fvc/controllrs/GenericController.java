package br.ba.fvc.controllrs;

import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.table.DefaultTableModel;

import br.ba.fvc.dao.GenericDAO;

public class GenericController {

	public GenericDAO dao;
	private DefaultTableModel tableModel;
	private String fields;

	public GenericController(String table, String[] columns, String fields) {
		this.dao = new GenericDAO(table, fields);
		this.tableModel = new DefaultTableModel(null, columns);
		this.fields = fields;
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
			System.out.println(e.getMessage());
		}
		return result;
	}

	public DefaultTableModel update(Object[] fields, Object[] data, String id) {
		StringBuilder removeKey = new StringBuilder();
		try {
			HashMap<Object, Object> values = new HashMap<>();

			int count = 0;
			for (Object object : data) {
				values.put(fields[count], "'" + object + "'");
				count++;
			}
			removeKey.append(values);
			removeKey.deleteCharAt(-0);
			removeKey.deleteCharAt(removeKey.length() - 1);

			this.dao.update(removeKey.toString(), id);
			this.all();
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