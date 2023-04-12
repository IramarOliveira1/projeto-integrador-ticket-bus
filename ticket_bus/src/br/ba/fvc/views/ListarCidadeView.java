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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

<<<<<<< HEAD
<<<<<<< HEAD
=======

import br.ba.fvc.controllrs.CidadeController;
>>>>>>> 31df16b8d376dbd399ac9ad8602385f2ea6da61f
import br.ba.fvc.controllrs.FuncionarioController;
=======
import br.ba.fvc.controllrs.LoginController;
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff

import javax.swing.JScrollPane;

public class ListarCidadeView {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
<<<<<<< HEAD
<<<<<<< HEAD
=======
	public DefaultTableModel list;
>>>>>>> 31df16b8d376dbd399ac9ad8602385f2ea6da61f
	public FuncionarioController user;
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
					ListarCidadeView window = new ListarCidadeView(null);
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
	public ListarCidadeView(FuncionarioController fields) {
<<<<<<< HEAD
=======
	public ListarCidadeView(LoginController fields) {
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
=======
		CidadeController cidade = new CidadeController();
		this.list = cidade.listar();
>>>>>>> 31df16b8d376dbd399ac9ad8602385f2ea6da61f
		this.user = fields;
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}

	private void cadastrar() {
		CadastrarCidadeView cadastrar = new CadastrarCidadeView();
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
		scrollPane.setBounds(10, 124, 561, 355);
		frame.getContentPane().add(scrollPane);
		
		JLabel listar_cidade = new JLabel("Listar  Cidades");
		listar_cidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		listar_cidade.setBounds(319, 19, 185, 14);
		frame.getContentPane().add(listar_cidade);

		table = new JTable(this.list);
		scrollPane.setViewportView(table);
		

		JLabel lblNewLabel_3 = new JLabel("");
		URL urlToImage = this.getClass().getResource("/public/cidade.png");
		lblNewLabel_3.setIcon(new ImageIcon(urlToImage));
		lblNewLabel_3.setBounds(668, 147, 105, 130);
		frame.getContentPane().add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(10, 72, 475, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Pesquisar");
		lblNewLabel.setBounds(10, 47, 149, 14);
		frame.getContentPane().add(lblNewLabel);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		cadastrar.setBounds(642, 363, 158, 23);
		frame.getContentPane().add(cadastrar);

		JButton atualizar = new JButton("Atualizar");
		atualizar.setBounds(642, 397, 158, 23);
		frame.getContentPane().add(atualizar);


		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.setBounds(495, 71, 127, 23);
		frame.getContentPane().add(pesquisar);

		JButton home = new JButton("Home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home();
			}
		});
		home.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(home);
		
		JButton excluir = new JButton("Excluir");
		excluir.setBounds(642, 431, 158, 23);
		frame.getContentPane().add(excluir);

<<<<<<< HEAD
		JLabel lblNewLabel_1 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_1.setIcon(new ImageIcon(logo));
		lblNewLabel_1.setBounds(367, 523, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);

=======
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

}
