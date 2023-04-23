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
	private JTextField textField;
	private JTable table;
	public FuncionarioController user;

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
		this.user = fields;
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}

	private void cadastrar() {
		CadastrarVeiculoView cadastrar = new CadastrarVeiculoView();
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
		separator_1.setBounds(10, 44, 807, 7);
		frame.getContentPane().add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 131, 646, 363);
		frame.getContentPane().add(scrollPane);

		JLabel listar_veiculo = new JLabel("Listar  VeÃ­culos");
		listar_veiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		listar_veiculo.setBounds(319, 19, 185, 14);
		frame.getContentPane().add(listar_veiculo);

		JLabel lblNewLabel_3 = new JLabel("");
		URL urlToImage = this.getClass().getResource("/public/onibus.png");
		lblNewLabel_3.setIcon(new ImageIcon(urlToImage));
		lblNewLabel_3.setBounds(712, 169, 105, 130);
		frame.getContentPane().add(lblNewLabel_3);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Numero", "Placa", "Modelo", "Data compra", "Quant. poltrona" }));

		textField = new JTextField();
		textField.setBounds(26, 87, 421, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setBounds(20, 62, 105, 14);
		frame.getContentPane().add(lblNewLabel);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		cadastrar.setBounds(682, 356, 135, 23);
		frame.getContentPane().add(cadastrar);

		JButton alterar = new JButton("Alterar");
		alterar.setBounds(682, 393, 135, 23);
		frame.getContentPane().add(alterar);

		JButton excluir = new JButton("Excluir");
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

		JLabel lblNewLabel_4 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_4.setIcon(new ImageIcon(logo));
		lblNewLabel_4.setBounds(349, 519, 106, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.setBounds(455, 86, 113, 23);
		frame.getContentPane().add(pesquisar);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}