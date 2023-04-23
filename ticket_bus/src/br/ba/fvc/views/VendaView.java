package br.ba.fvc.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.controllrs.FuncionarioController;

import javax.swing.JScrollPane;

public class VendaView {

	private JFrame frame;
	private JTable table;
	private JTextField input_de;
	private JTextField input_ate;
	private JTextField rota;
	public FuncionarioController user;

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
	 * @param fields 
	 */
	public VendaView(FuncionarioController fields) {
		this.user = fields;
		initialize();
	}
	
	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}
	
	private void cadastrar() {
		CadastrarVendaView cadastrar = new CadastrarVendaView();
		cadastrar.setVisible(true);
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
		scrollPane.setBounds(10, 192, 605, 278);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "CPF", "Data partida", "Hora partida", "Rota" }));

		input_de = new JTextField();
		input_de.setToolTipText("");
		input_de.setBounds(10, 79, 129, 20);
		frame.getContentPane().add(input_de);
		input_de.setColumns(10);

		input_ate = new JTextField();
		input_ate.setColumns(10);
		input_ate.setBounds(157, 79, 129, 20);
		frame.getContentPane().add(input_ate);

		JLabel lblPesquisarPorPeriodo = new JLabel("Pesquisar por periodo");
		lblPesquisarPorPeriodo.setBounds(10, 54, 162, 14);
		frame.getContentPane().add(lblPesquisarPorPeriodo);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(299, 78, 129, 23);
		frame.getContentPane().add(btnNewButton);

		rota = new JTextField();
		rota.setBounds(10, 131, 276, 20);
		frame.getContentPane().add(rota);
		rota.setColumns(10);

		JLabel lblPesquisarPorRoteiro = new JLabel("Pesquisar por rota");
		lblPesquisarPorRoteiro.setBounds(10, 106, 162, 14);
		frame.getContentPane().add(lblPesquisarPorRoteiro);

		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.setBounds(299, 130, 129, 23);
		frame.getContentPane().add(btnNewButton_1);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		home.setBounds(10, 3, 89, 23);
		frame.getContentPane().add(home);

		JLabel lblNewLabel_1 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_1.setIcon(new ImageIcon(logo));
		lblNewLabel_1.setBounds(367, 523, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		URL logo_2 = this.getClass().getResource("/public/venda.png");
		lblNewLabel_2.setIcon(new ImageIcon(logo_2));
		lblNewLabel_2.setBounds(697, 121, 100, 155);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		cadastrar.setBounds(661, 344, 162, 23);
		frame.getContentPane().add(cadastrar);
		
		JButton btnNewButton_2_1_1 = new JButton("Cancelar Passagem");
		btnNewButton_2_1_1.setBounds(661, 378, 162, 23);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel = new JLabel("Listar Vendas");
		lblNewLabel.setBounds(394, 12, 129, 14);
		frame.getContentPane().add(lblNewLabel);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
