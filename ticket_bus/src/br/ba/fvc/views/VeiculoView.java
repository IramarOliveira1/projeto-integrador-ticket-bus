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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.ba.fvc.controller.FuncionarioController;
import br.ba.fvc.controller.GenericController;
import br.ba.fvc.controller.VeiculoController;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class VeiculoView {

	private JFrame frame;
	private JTextField placa;
	private JFormattedTextField data_compra;
	private JTextField modelo;
	private JTextField quantidade_poltrona;
	private JTextField numero;
	private JTable table;
	public DefaultTableModel list;
	public FuncionarioController funcionario;
	public VeiculoController veiculo;
	private JTextField input_filtrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeiculoView window = new VeiculoView(null);
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
	public VeiculoView(FuncionarioController fields) {
		this.funcionario = fields;
		this.veiculo = new VeiculoController();
		this.list = this.veiculo.listar();
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
		Object[][] data = { { numero.getName(), numero.getText() }, { placa.getName(), placa.getText() },
				{ modelo.getName(), modelo.getText() }, { data_compra.getName(), data_compra.getText() },
				{ quantidade_poltrona.getName(), quantidade_poltrona.getText() } };

		Boolean error = GenericController.validateFieldsEmpty(data);

		if (!error) {
			this.veiculo.setNumero(numero.getText());
			this.veiculo.setPlaca(placa.getText());
			this.veiculo.setModelo(modelo.getText());
			this.veiculo.setData_compra(data_compra.getText());
			this.veiculo.setQuantidade_poltronas(quantidade_poltrona.getText());
			this.list = veiculo.incluir();

			if (this.list == null) {
				frame.setVisible(true);
				return;
			}

			frame.setVisible(false);

			this.table.setModel(this.list);
			this.list.fireTableDataChanged();
		}
	}

	private void filtrar() {
		Object[][] data = { { input_filtrar.getName(), input_filtrar.getText() } };

		Boolean error = GenericController.validateFieldsEmpty(data);

		if (!error) {

			this.veiculo.setNumero(input_filtrar.getText());

			this.list = this.veiculo.filtrar();

			input_filtrar.setText("");

			this.table.setModel(this.list);
			this.list.fireTableDataChanged();
		}

	}

	private void limparFiltro() {
		this.list = veiculo.listar();
		this.list.fireTableDataChanged();
	}

	private void excluir() {
		if (this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para excluir!");
			return;
		}

		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

		this.list = this.veiculo.excluir(id);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void carregarCamposAlterar() {
		if (this.table.getSelectedRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um registro na tabela para alterar!");
			return;
		}
		campos("alterar");

		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

		ResultSet result = null;

		try {
			result = veiculo.carregaCamposAlterar(id);
			result.next();

			numero.setText(result.getString("Numero"));
			placa.setText(result.getString("Placa"));
			modelo.setText(result.getString("modelo"));
			data_compra.setText(result.getString("data_compra"));
			quantidade_poltrona.setText(result.getString("quantidade_poltronas"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void alterar() {
		Object[][] data = { { numero.getName(), numero.getText() }, { placa.getName(), placa.getText() },
				{ modelo.getName(), modelo.getText() }, { data_compra.getName(), data_compra.getText() },
				{ quantidade_poltrona.getName(), quantidade_poltrona.getText() } };

		Boolean error = GenericController.validateFieldsEmpty(data);

		if (!error) {
			String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

			this.veiculo.setNumero(numero.getText());
			this.veiculo.setPlaca(placa.getText());
			this.veiculo.setModelo(modelo.getText());
			this.veiculo.setData_compra(data_compra.getText());
			this.veiculo.setQuantidade_poltronas(quantidade_poltrona.getText());
			this.list = veiculo.alterar(id);

			frame.setVisible(false);

			this.table.setModel(this.list);
			this.list.fireTableDataChanged();
		}
	}

	private void campos(String criarOuAlterar) {

		try {

			frame = new JFrame();
			frame.setBounds(100, 100, 610, 393);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JSeparator separator = new JSeparator();
			separator.setBounds(10, 45, 563, 9);
			frame.getContentPane().add(separator);

			JLabel label_qtd_poltrona = new JLabel("Quant. de poltrona");
			label_qtd_poltrona.setBounds(309, 170, 115, 14);
			frame.getContentPane().add(label_qtd_poltrona);

			quantidade_poltrona = new JTextField();
			quantidade_poltrona.setName("poltrona");
			quantidade_poltrona.setBounds(313, 195, 260, 20);
			frame.getContentPane().add(quantidade_poltrona);
			quantidade_poltrona.setColumns(10);

			JLabel label_data_compra = new JLabel(" Data da compra");
			label_data_compra.setBounds(10, 170, 115, 14);
			frame.getContentPane().add(label_data_compra);

			data_compra = new JFormattedTextField(new MaskFormatter("##/##/####"));
			data_compra.setName("data compra");
			data_compra.setBounds(10, 195, 260, 20);
			frame.getContentPane().add(data_compra);
			data_compra.setColumns(10);

			JLabel label_Modelo = new JLabel(" Modelo");
			label_Modelo.setBounds(311, 107, 68, 14);
			frame.getContentPane().add(label_Modelo);

			modelo = new JTextField();
			modelo.setName("modelo");
			modelo.setBounds(313, 132, 260, 20);
			frame.getContentPane().add(modelo);
			modelo.setColumns(10);

			JLabel label_placa = new JLabel(" Placa");
			label_placa.setBounds(10, 107, 46, 14);
			frame.getContentPane().add(label_placa);

			placa = new JTextField();
			placa.setName("placa");
			placa.setBounds(10, 132, 260, 20);
			frame.getContentPane().add(placa);
			placa.setColumns(10);

			JLabel label_nemeracao = new JLabel("Numeração Veículo");
			label_nemeracao.setBounds(10, 51, 159, 14);
			frame.getContentPane().add(label_nemeracao);

			numero = new JTextField();
			numero.setName("número");
			numero.setBounds(10, 76, 563, 20);
			frame.getContentPane().add(numero);
			numero.setColumns(10);

			if (criarOuAlterar.equals("cadastrar")) {
				JLabel label_cadastrar = new JLabel("Adicionar Veículos");
				label_cadastrar.setBounds(10, 20, 115, 14);
				frame.getContentPane().add(label_cadastrar);

				JButton adicionar = new JButton(" Adicionar");
				adicionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						cadastrar();
					}
				});
				adicionar.setBounds(473, 257, 100, 23);
				frame.getContentPane().add(adicionar);
			} else {
				JLabel label_atualizar = new JLabel("Atualizar Veículos");
				label_atualizar.setBounds(10, 20, 115, 14);
				frame.getContentPane().add(label_atualizar);

				JButton alterar = new JButton("Atualizar");
				alterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						alterar();
					}
				});
				alterar.setBounds(473, 257, 100, 23);
				frame.getContentPane().add(alterar);
			}

			JButton btn_cancelar = new JButton(" Cancelar");
			btn_cancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
				}
			});
			btn_cancelar.setBounds(361, 257, 89, 23);
			frame.getContentPane().add(btn_cancelar);

			JLabel dark_logo_min = new JLabel("");
			URL logo = this.getClass().getResource("/public/dark_logo_min.png");
			dark_logo_min.setIcon(new ImageIcon(logo));
			dark_logo_min.setBounds(245, 317, 114, 14);
			frame.getContentPane().add(dark_logo_min);
			frame.setLocationRelativeTo(frame);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
		separator_1.setBounds(10, 44, 807, 7);
		frame.getContentPane().add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 131, 646, 363);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(this.table);

		JLabel listar_veiculo = new JLabel("Listar  Veículos");
		listar_veiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		listar_veiculo.setBounds(319, 19, 185, 14);
		frame.getContentPane().add(listar_veiculo);

		JLabel logo_onibus = new JLabel("");
		URL url_logo = this.getClass().getResource("/public/onibus.png");
		logo_onibus.setIcon(new ImageIcon(url_logo));
		logo_onibus.setBounds(712, 169, 105, 130);
		frame.getContentPane().add(logo_onibus);

		input_filtrar = new JTextField();
		input_filtrar.setName("pesquisar número");
		input_filtrar.setBounds(26, 87, 421, 20);
		frame.getContentPane().add(input_filtrar);
		input_filtrar.setColumns(10);

		JLabel label_pesquisar = new JLabel("Pesquisar por número");
		label_pesquisar.setBounds(20, 62, 180, 20);
		frame.getContentPane().add(label_pesquisar);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campos("cadastrar");
				frame.setVisible(true);
			}
		});
		cadastrar.setBounds(682, 356, 135, 23);
		frame.getContentPane().add(cadastrar);

		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregarCamposAlterar();
				frame.setVisible(true);
			}
		});
		alterar.setBounds(682, 393, 135, 23);
		frame.getContentPane().add(alterar);

		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
		excluir.setBounds(682, 427, 135, 23);
		frame.getContentPane().add(excluir);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		home.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(home);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		pesquisar.setBounds(455, 86, 113, 23);
		frame.getContentPane().add(pesquisar);

		JButton limpar_filtro = new JButton("Limpar filtro");
		limpar_filtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFiltro();
			}
		});
		limpar_filtro.setBounds(575, 86, 125, 23);
		frame.getContentPane().add(limpar_filtro);

		JLabel logo_dark_min = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		logo_dark_min.setIcon(new ImageIcon(logo));
		logo_dark_min.setBounds(349, 519, 106, 14);
		frame.getContentPane().add(logo_dark_min);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
}
