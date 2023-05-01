package br.ba.fvc.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.controllrs.FuncionarioController;
import br.ba.fvc.controllrs.VendaController;

import javax.swing.JScrollPane;

public class VendaView {

	private JFrame frame;
	private JTable table;
	private JTextField nome;
	private JTextField cpf;
	private JTextField valor;
	private JTextField data;
	private JTextField poltrona;
	private JTextField input_de;
	private JTextField input_ate;
	private JTextField rota;
	private String id_rota;
	private String id_veiculo;
	private JLabel value;
	private JLabel label_de;
	private JLabel label_ate;
	public FuncionarioController funcionario;
	public VendaController venda;
	public DefaultTableModel list;
	public HashMap<Integer, String> combobox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VendaView window = new VendaView(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	@SuppressWarnings("serial")
	public VendaView(FuncionarioController fields) {
		this.funcionario = fields;
		this.venda = new VendaController();
		this.list = this.venda.all();
		this.combobox = this.venda.getComboBox();
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

	private void loadComboBox(String id) {
		ResultSet result = null;

		try {
			result = this.venda.loadComboBox(id);
			if (result.next()) {
				data.setText(result.getString("data_formatada"));
				valor.setText(result.getString("valor_passagem"));
				this.id_veiculo = result.getString("id_veiculo");
				this.id_rota = id;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void cadastrar() {

		this.venda.setName_passenger(nome.getText());
		this.venda.setCpf(cpf.getText());
		this.venda.setArmchair(poltrona.getText());
		this.venda.setId_router(this.id_rota);
		this.venda.setId_vehicle(id_veiculo);
		this.list = venda.incluir();

		if (this.list == null) {
			frame.setVisible(true);
			return;
		}
		frame.setVisible(false);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void excluir() {
		if (this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para cancelar passagem!");
			return;
		}

		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();
		System.out.println(id);

		this.list = this.venda.excluir(id);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void pesquisarRota() {
		this.venda.setRouter(rota.getText());

		this.list = this.venda.filterRouter();

		rota.setText("");

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void pesquisarPeriodo() {
		ResultSet result = null;
		
		try {
			this.venda.setDe(input_de.getText());
			this.venda.setAte(input_ate.getText());

			camposTeste();

			result = venda.filterPeriod();
			result.next();

			label_de.setText("Periodo De: " + input_de.getText());
			label_ate.setText("Periodo Até: " + input_ate.getText());
			value.setText("Valor total: R$" + result.getString("valor_total"));

			this.table.setModel(this.list);
			this.list.fireTableDataChanged();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void limparFiltro() {
		this.list = venda.all();
		this.list.fireTableDataChanged();
	}

	private void camposTeste() {
		frame = new JFrame();
		frame.setBounds(100, 100, 332, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 43, 678, 12);
		frame.getContentPane().add(separator_1);

		label_de = new JLabel();
		label_de.setBounds(10, 87, 296, 14);
		frame.getContentPane().add(label_de);

		label_ate = new JLabel();
		label_ate.setBounds(10, 136, 296, 14);
		frame.getContentPane().add(label_ate);

		JLabel result_period = new JLabel("Resultado filtro por periodo");
		result_period.setBounds(10, 18, 170, 14);
		frame.getContentPane().add(result_period);

		value = new JLabel();
		value.setBounds(10, 184, 249, 14);
		frame.getContentPane().add(value);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		cancelar.setBounds(84, 242, 138, 23);
		frame.getContentPane().add(cancelar);

		frame.setLocationRelativeTo(frame);
	}

	private void campos() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 43, 678, 12);
		frame.getContentPane().add(separator_1);

		JLabel label_cpf = new JLabel("CPF");
		label_cpf.setBounds(361, 53, 46, 14);
		frame.getContentPane().add(label_cpf);

		cpf = new JTextField();
		cpf.setBounds(361, 78, 327, 20);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);

		JLabel label_data_partida = new JLabel("Data Partida / Hora Partida");
		label_data_partida.setBounds(10, 167, 200, 14);
		frame.getContentPane().add(label_data_partida);

		data = new JTextField();
		data.setBounds(10, 184, 327, 17);
		frame.getContentPane().add(data);
		data.setColumns(10);
		data.setEditable(false);

		JLabel label_nome = new JLabel("Nome");
		label_nome.setBounds(10, 53, 46, 14);
		frame.getContentPane().add(label_nome);

		nome = new JTextField();
		nome.setBounds(10, 78, 327, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);

		JLabel label_poltrona = new JLabel("Poltrona");
		label_poltrona.setBounds(10, 209, 70, 14);
		frame.getContentPane().add(label_poltrona);

		poltrona = new JTextField();
		poltrona.setBounds(10, 231, 327, 20);
		frame.getContentPane().add(poltrona);
		poltrona.setColumns(10);

		JLabel label_valor_passagem = new JLabel("Valor Passagem");
		label_valor_passagem.setBounds(349, 163, 102, 23);
		frame.getContentPane().add(label_valor_passagem);

		valor = new JTextField();
		valor.setBounds(349, 183, 339, 18);
		frame.getContentPane().add(valor);
		valor.setColumns(10);
		valor.setEditable(false);

		JLabel label_cidade_origim = new JLabel("Rota");
		label_cidade_origim.setBounds(10, 109, 122, 20);
		frame.getContentPane().add(label_cidade_origim);

		JComboBox<Object> comboBox = new JComboBox<Object>(this.combobox.values().toArray());
		comboBox.getModel().setSelectedItem("SELECIONE");
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED)) {
					String id = comboBox.getSelectedItem().toString().substring(0,
							comboBox.getSelectedItem().toString().indexOf('='));
					loadComboBox(id);
				}
			}
		});
		comboBox.setBounds(10, 134, 678, 22);
		frame.getContentPane().add(comboBox);

		JLabel label_adicionar = new JLabel("Adicionar Vendas");
		label_adicionar.setBounds(10, 18, 145, 14);
		frame.getContentPane().add(label_adicionar);

		JButton adicionar = new JButton("Concluir venda");
		adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		adicionar.setBounds(550, 279, 140, 23);
		frame.getContentPane().add(adicionar);

		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		Cancelar.setBounds(402, 279, 138, 23);
		frame.getContentPane().add(Cancelar);

		frame.setLocationRelativeTo(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.table.getColumnModel().getColumn(0).setMaxWidth(50);
		frame = new JFrame();
		frame.setBounds(100, 100, 862, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 37, 826, 14);
		frame.getContentPane().add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 192, 828, 278);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(this.table);

		JLabel label_listar_venda = new JLabel("Listar Vendas");
		label_listar_venda.setBounds(394, 12, 129, 14);
		frame.getContentPane().add(label_listar_venda);

		JLabel lblPesquisarPorPeriodo = new JLabel("Pesquisar por periodo");
		lblPesquisarPorPeriodo.setBounds(10, 54, 162, 14);
		frame.getContentPane().add(lblPesquisarPorPeriodo);

		input_de = new JTextField("2023-01-20");
		input_de.setBounds(10, 79, 129, 20);
		frame.getContentPane().add(input_de);
		input_de.setColumns(10);

		input_ate = new JTextField("2023-05-20");
		input_ate.setBounds(157, 79, 129, 20);
		frame.getContentPane().add(input_ate);
		input_ate.setColumns(10);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarPeriodo();
				frame.setVisible(true);
			}
		});
		pesquisar.setBounds(299, 78, 129, 23);
		frame.getContentPane().add(pesquisar);

		JLabel lblPesquisarPorRoteiro = new JLabel("Pesquisar por rota");
		lblPesquisarPorRoteiro.setBounds(10, 106, 162, 14);
		frame.getContentPane().add(lblPesquisarPorRoteiro);

		rota = new JTextField();
		rota.setBounds(10, 131, 276, 20);
		frame.getContentPane().add(rota);
		rota.setColumns(10);

		JButton pesquisar_rota = new JButton("Pesquisar");
		pesquisar_rota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarRota();
			}
		});
		pesquisar_rota.setBounds(299, 130, 129, 23);
		frame.getContentPane().add(pesquisar_rota);

		JButton limpar_filtros = new JButton("Limpar Filtro");
		limpar_filtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFiltro();
			}
		});
		limpar_filtros.setBounds(436, 130, 129, 23);
		frame.getContentPane().add(limpar_filtros);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		home.setBounds(10, 3, 89, 23);
		frame.getContentPane().add(home);

		JButton cadastrar = new JButton("Comprar Passagem");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campos();
				frame.setVisible(true);
			}
		});
		cadastrar.setBounds(674, 481, 162, 23);
		frame.getContentPane().add(cadastrar);

		JButton cancelar_passagem = new JButton("Cancelar Passagem");
		cancelar_passagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		cancelar_passagem.setBounds(500, 481, 162, 23);
		frame.getContentPane().add(cancelar_passagem);

		JLabel dark_logo_min = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		dark_logo_min.setIcon(new ImageIcon(logo));
		dark_logo_min.setBounds(367, 523, 137, 14);
		frame.getContentPane().add(dark_logo_min);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
