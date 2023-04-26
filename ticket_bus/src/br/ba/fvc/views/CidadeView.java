package br.ba.fvc.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.controller.CidadeController;
import br.ba.fvc.controller.FuncionarioController;

import javax.swing.JScrollPane;

public class CidadeView {

	private JFrame frame;
	private JTextField input_filtrar;
	private JTable table;
	private JTextField nome;
	private JTextField uf;
	public DefaultTableModel list;
	public FuncionarioController funcionario;
	public CidadeController cidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CidadeView window = new CidadeView(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	@SuppressWarnings("serial")
	public CidadeView(FuncionarioController fields) {
		this.cidade = new CidadeController();
		this.list = this.cidade.listar();
		this.funcionario = fields;
		this.table = new JTable(this.list) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.funcionario);
		menu.setVisible(true);
		frame.dispose();
	}

	private void cadastrar() {

		this.cidade.setNome(nome.getText());
		this.cidade.setUf(uf.getText());
		this.list = cidade.incluir();

		if (this.list == null) {
			frame.setVisible(true);
			return;
		}

		frame.setVisible(false);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void filtrar() {
		this.cidade.setNome(input_filtrar.getText());

		this.list = this.cidade.filtrar();

		input_filtrar.setText("");

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void limparFiltro() {
		this.list = cidade.listar();
		this.list.fireTableDataChanged();
	}

	private void excluir() {
		if (this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para excluir!");
			return;
		}

		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

		this.list = this.cidade.excluir(id);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void carregarCamposAlterar() {
		System.out.println("Teste");
		if (this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para alterar!");
			return;
		}
		campos("alterar");

		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

		ResultSet result = null;

		try {
			result = cidade.carregaCamposAlterar(id);
			result.next();

			nome.setText(result.getString("nome"));
			uf.setText(result.getString("uf"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void alterar() {
		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

		this.cidade.setNome(nome.getText());
		this.cidade.setUf(uf.getText());

		this.list = cidade.alterar(id);

		frame.setVisible(false);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void campos(String criarOuAlterar) {
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 458, 9);
		frame.getContentPane().add(separator);

		nome = new JTextField();
		nome.setBounds(10, 85, 274, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);

		uf = new JTextField();
		uf.setBounds(10, 141, 86, 20);
		frame.getContentPane().add(uf);
		uf.setColumns(10);

		JLabel label_cidade = new JLabel("Cidade");
		label_cidade.setBounds(10, 65, 46, 14);
		frame.getContentPane().add(label_cidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(10, 116, 46, 14);
		frame.getContentPane().add(lblUf);

		if (criarOuAlterar.equals("cadastrar")) {
			JLabel adicionar_func_label = new JLabel("Adicionar Cidade");
			adicionar_func_label.setFont(new Font("Tahoma", Font.BOLD, 12));
			adicionar_func_label.setBounds(10, 13, 156, 14);
			frame.getContentPane().add(adicionar_func_label);

			JButton adicionar = new JButton("Adicionar");
			adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cadastrar();
				}
			});
			adicionar.setBounds(366, 220, 97, 23);
			frame.getContentPane().add(adicionar);
		} else {
			JLabel atualizar_func_label = new JLabel("Atualizar Cidade");
			atualizar_func_label.setFont(new Font("Tahoma", Font.BOLD, 12));
			atualizar_func_label.setBounds(10, 13, 156, 14);
			frame.getContentPane().add(atualizar_func_label);

			JButton alterar = new JButton("Atualizar");
			alterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alterar();
				}
			});
			alterar.setBounds(366, 220, 97, 23);
			frame.getContentPane().add(alterar);
		}

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		cancelar.setBounds(267, 220, 89, 23);
		frame.getContentPane().add(cancelar);

		JLabel logo_cidade = new JLabel("");
		URL cidade_logo = this.getClass().getResource("/public/cidade.png");
		logo_cidade.setIcon(new ImageIcon(cidade_logo));
		logo_cidade.setBounds(346, 61, 122, 126);
		frame.getContentPane().add(logo_cidade);

		JLabel logo_dark_min = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		logo_dark_min.setIcon(new ImageIcon(logo));
		logo_dark_min.setBounds(197, 276, 114, 14);
		frame.getContentPane().add(logo_dark_min);

		frame.setLocationRelativeTo(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 862, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 37, 826, 14);
		frame.getContentPane().add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 124, 561, 355);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(this.table);

		JLabel listar_cidade = new JLabel("Listar  Cidades");
		listar_cidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		listar_cidade.setBounds(319, 19, 185, 14);
		frame.getContentPane().add(listar_cidade);

		table = new JTable(this.list);
		scrollPane.setViewportView(table);

		JLabel logo_cidade_list = new JLabel("");
		URL urlToImage = this.getClass().getResource("/public/cidade.png");
		logo_cidade_list.setIcon(new ImageIcon(urlToImage));
		logo_cidade_list.setBounds(668, 147, 105, 130);
		frame.getContentPane().add(logo_cidade_list);

		JLabel lbl_pesquisar = new JLabel("Pesquisar");
		lbl_pesquisar.setBounds(10, 47, 149, 14);
		frame.getContentPane().add(lbl_pesquisar);

		input_filtrar = new JTextField();
		input_filtrar.setBounds(10, 72, 475, 20);
		frame.getContentPane().add(input_filtrar);
		input_filtrar.setColumns(10);

		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCamposAlterar();
				frame.setVisible(true);
			}
		});
		alterar.setBounds(642, 397, 158, 23);
		frame.getContentPane().add(alterar);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		pesquisar.setBounds(495, 71, 127, 23);
		frame.getContentPane().add(pesquisar);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campos("cadastrar");
				frame.setVisible(true);
			}
		});
		cadastrar.setBounds(642, 363, 158, 23);
		frame.getContentPane().add(cadastrar);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		home.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(home);

		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		excluir.setBounds(642, 431, 158, 23);
		frame.getContentPane().add(excluir);

		JLabel logo_dark_min_two = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		logo_dark_min_two.setIcon(new ImageIcon(logo));
		logo_dark_min_two.setBounds(367, 523, 137, 14);
		frame.getContentPane().add(logo_dark_min_two);
		
		JButton limpar_filtro = new JButton("Limpar filtro");
		limpar_filtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFiltro();
			}
		});
		limpar_filtro.setBounds(613, 86, 125, 23);
		frame.getContentPane().add(limpar_filtro);

		frame.setLocationRelativeTo(frame);

	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

}
