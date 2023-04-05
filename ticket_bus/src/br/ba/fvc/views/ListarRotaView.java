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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.controllrs.FuncionarioController;

import javax.swing.JScrollPane;

public class ListarRotaView {

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
					ListarRotaView window = new ListarRotaView(null);
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
	 * @param user
	 */
	public ListarRotaView(FuncionarioController fields) {
		this.user = fields;
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}

	private void cadastrar() {
		CadastrarRotaView cadastrar = new CadastrarRotaView();
		cadastrar.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1001, 611);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 37, 942, 14);
		frame.getContentPane().add(separator_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 951, 297);
		frame.getContentPane().add(scrollPane);

		JLabel listar_rota = new JLabel("Listar  Rotas");
		listar_rota.setFont(new Font("Tahoma", Font.BOLD, 12));
		listar_rota.setBounds(456, 20, 185, 14);
		frame.getContentPane().add(listar_rota);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nome motorista ", "Placa do veiculo ",
				"Data de partida", "Cidade origem", "Cidade destino" }));

		JButton alterar = new JButton("Alterar");
		alterar.setBounds(705, 425, 123, 23);
		frame.getContentPane().add(alterar);

		JButton excluir = new JButton("Excluir");
		excluir.setBounds(572, 425, 123, 23);
		frame.getContentPane().add(excluir);

		textField = new JTextField();
		textField.setBounds(10, 70, 424, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel(" Pesquisar");
		lblNewLabel.setBounds(10, 50, 102, 14);
		frame.getContentPane().add(lblNewLabel);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		cadastrar.setBounds(838, 425, 123, 23);
		frame.getContentPane().add(cadastrar);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.setBounds(444, 69, 137, 23);
		frame.getContentPane().add(pesquisar);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		home.setBounds(10, 3, 137, 23);
		frame.getContentPane().add(home);

		JLabel lblNewLabel_1 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_1.setIcon(new ImageIcon(logo));
		lblNewLabel_1.setBounds(456, 524, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

}
