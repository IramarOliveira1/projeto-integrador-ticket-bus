package br.ba.fvc.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD
import br.ba.fvc.controllrs.FuncionarioController;
=======
import br.ba.fvc.controllrs.LoginController;
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ListarFuncionarioView {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
<<<<<<< HEAD
	public FuncionarioController user;
	public DefaultTableModel list;
=======
	public LoginController user;
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarFuncionarioView window = new ListarFuncionarioView(null);
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
<<<<<<< HEAD
	public ListarFuncionarioView(FuncionarioController fields) {
		FuncionarioController funcionario = new FuncionarioController();
		this.list = funcionario.listar();
		this.user = fields;
		initialize();
	}
	
=======
	public ListarFuncionarioView(LoginController fields) {
		initialize();
		this.user = fields;

	}

>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}

<<<<<<< HEAD
	private void cadastrarFuncionarioView() {
=======
	private void cadastrar() {
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		CadastrarFuncionarioView cadastrar = new CadastrarFuncionarioView();
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

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 672, -6);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 44, 807, 7);
		frame.getContentPane().add(separator_1);

		textField = new JTextField();
		textField.setBounds(20, 87, 447, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Pesquisar");
		lblNewLabel_2.setBounds(20, 65, 76, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		URL urlToImage = this.getClass().getResource("/public/listagem_funcionario.png");
		lblNewLabel_3.setIcon(new ImageIcon(urlToImage));
		lblNewLabel_3.setBounds(711, 164, 106, 130);
		frame.getContentPane().add(lblNewLabel_3);

		JButton alterar = new JButton("Alterar");
		alterar.setBounds(692, 375, 125, 23);
		frame.getContentPane().add(alterar);

		JButton excluir = new JButton("Excluir");
		excluir.setBounds(692, 409, 125, 23);
		frame.getContentPane().add(excluir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 150, 662, 321);
		frame.getContentPane().add(scrollPane);

<<<<<<< HEAD
		table = new JTable(this.list);

		scrollPane.setViewportView(table);
=======
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Nome", "CPF", "Email", "Cargo" }));
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff

		JLabel lblNewLabel_4 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_4.setIcon(new ImageIcon(logo));
		lblNewLabel_4.setBounds(349, 519, 106, 14);
		frame.getContentPane().add(lblNewLabel_4);

<<<<<<< HEAD
		JLabel lblNewLabel = new JLabel("Listar  FuncionÃ¡rio");
=======
		JLabel lblNewLabel = new JLabel("Listar  Funcionário");
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(319, 19, 185, 14);
		frame.getContentPane().add(lblNewLabel);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});

		home.setBounds(7, 16, 89, 23);
		frame.getContentPane().add(home);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				cadastrarFuncionarioView();
=======
				cadastrar();
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
			}
		});
		cadastrar.setBounds(692, 341, 125, 23);
		frame.getContentPane().add(cadastrar);
<<<<<<< HEAD

=======
		
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.setBounds(480, 86, 125, 23);
		frame.getContentPane().add(pesquisar);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
