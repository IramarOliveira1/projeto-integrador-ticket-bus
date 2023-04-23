package br.ba.fvc.views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.controllrs.FuncionarioController;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VeiculoView {

	private JFrame frame;
	private JTextField placa;
	private JTextField data_compra;
	private JTextField modelo;
	private JTextField qtd_poltrona;
	private JTextField numero_veiculo;
	private JTextField input_pesquisar;
	private JTable table;
	public FuncionarioController funcionario;

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
	public VeiculoView(FuncionarioController fields) {
		this.funcionario = fields;
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.funcionario);
		menu.setVisible(true);
		frame.dispose();
	}

	private void campos(String criarOuAlterar) {
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

		qtd_poltrona = new JTextField();
		qtd_poltrona.setBounds(313, 195, 260, 20);
		frame.getContentPane().add(qtd_poltrona);
		qtd_poltrona.setColumns(10);

		JLabel label_data_compra = new JLabel(" Data da compra");
		label_data_compra.setBounds(10, 170, 115, 14);
		frame.getContentPane().add(label_data_compra);

		data_compra = new JTextField();
		data_compra.setBounds(10, 195, 260, 20);
		frame.getContentPane().add(data_compra);
		data_compra.setColumns(10);

		JLabel label_Modelo = new JLabel(" Modelo");
		label_Modelo.setBounds(311, 107, 68, 14);
		frame.getContentPane().add(label_Modelo);

		modelo = new JTextField();
		modelo.setBounds(313, 132, 260, 20);
		frame.getContentPane().add(modelo);
		modelo.setColumns(10);

		JLabel label_placa = new JLabel(" Placa");
		label_placa.setBounds(10, 107, 46, 14);
		frame.getContentPane().add(label_placa);
		
		placa = new JTextField();
		placa.setBounds(10, 132, 260, 20);
		frame.getContentPane().add(placa);
		placa.setColumns(10);

		JLabel label_nemeracao = new JLabel("Numeração Veículo");
		label_nemeracao.setBounds(10, 51, 159, 14);
		frame.getContentPane().add(label_nemeracao);

		numero_veiculo = new JTextField();
		numero_veiculo.setBounds(10, 76, 563, 20);
		frame.getContentPane().add(numero_veiculo);
		numero_veiculo.setColumns(10);

		if (criarOuAlterar.equals("cadastrar")) {
			JLabel label_cadastrar = new JLabel("Adicionar Veículos");
			label_cadastrar.setBounds(10, 20, 115, 14);
			frame.getContentPane().add(label_cadastrar);

			JButton adicionar = new JButton(" Adicionar");
			adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// cadastrar();
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
					// alterar();
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

		JLabel listar_veiculo = new JLabel("Listar  Veículos");
		listar_veiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		listar_veiculo.setBounds(319, 19, 185, 14);
		frame.getContentPane().add(listar_veiculo);

		JLabel logo_onibus = new JLabel("");
		URL url_logo = this.getClass().getResource("/public/onibus.png");
		logo_onibus.setIcon(new ImageIcon(url_logo));
		logo_onibus.setBounds(712, 169, 105, 130);
		frame.getContentPane().add(logo_onibus);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero", "Placa", "Modelo", "Data compra", "Quant. poltrona" }));


		
		JLabel label_pesquisar = new JLabel("Pesquisar");
		label_pesquisar.setBounds(20, 62, 105, 14);
		frame.getContentPane().add(label_pesquisar);

		input_pesquisar = new JTextField();
		input_pesquisar.setBounds(26, 87, 421, 20);
		frame.getContentPane().add(input_pesquisar);
		input_pesquisar.setColumns(10);


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
				// carregarCamposAlterar();
			}
		});
		alterar.setBounds(682, 393, 135, 23);
		frame.getContentPane().add(alterar);

		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// excluir();
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
				// filtrar();
			}
		});
		pesquisar.setBounds(455, 86, 113, 23);
		frame.getContentPane().add(pesquisar);

		JLabel logo_dark_min = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		logo_dark_min.setIcon(new ImageIcon(logo));
		logo_dark_min.setBounds(349, 519, 106, 14);
		frame.getContentPane().add(logo_dark_min);


		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
