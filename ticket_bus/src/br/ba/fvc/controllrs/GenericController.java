package br.ba.fvc.controllrs;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import br.ba.fvc.dao.GenericDAO;

public class GenericController {

	public GenericDAO dao;

	public GenericController() {
		this.dao = new GenericDAO();
	}

	public DefaultTableModel all(String table, String[] columns, String fields) {
		ResultSet result = null;

		DefaultTableModel tableModel = new DefaultTableModel(null, columns);
		try {
			result = this.dao.all(table, fields);

			while (result.next()) {
				Object[] row = new Object[result.getMetaData().getColumnCount()];

				for (int i = 0; i < row.length; i++) {
					row[i] = result.getObject(i + 1);

				}
				tableModel.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tableModel;
	}

	public void store(String table, String fields, Object[] data) {
		StringBuilder addQuotationMarks = new StringBuilder();
		try {

			for (Object values : data) {
				addQuotationMarks.append("'" + values + "'" + ",");
			}
			
			addQuotationMarks.deleteCharAt(addQuotationMarks.length() - 1);

			this.dao.store(table, fields, addQuotationMarks);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}