package br.ba.fvc.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ba.fvc.controllrs.FuncionarioController;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ListarFuncionarioView {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	public FuncionarioController user;
	public DefaultTableModel list;
	private JTextField nome;
	private JTextField cpf;
	private JTextField email;
	private JTextField cargo;
	private JPasswordField senha;

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
	public ListarFuncionarioView(FuncionarioController fields) {
		FuncionarioController funcionario = new FuncionarioController();
		this.list = funcionario.listar();
		this.table = new JTable(this.list);
		this.user = fields;
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}

	private void cadastrar() {
		FuncionarioController funcionario = new FuncionarioController();
		char[] senhaChar = senha.getPassword();

		String ConvertChar = String.valueOf(senhaChar);

		funcionario.setNome(nome.getText());
		funcionario.setCpf(cpf.getText());
		funcionario.setCargo(cargo.getText());
		funcionario.setEmail(email.getText());
		funcionario.setSenha(ConvertChar);
		this.list = funcionario.incluir();

		frame.setVisible(false);
		
		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
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

		scrollPane.setViewportView(this.table);

		JLabel lblNewLabel_4 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_4.setIcon(new ImageIcon(logo));
		lblNewLabel_4.setBounds(349, 519, 106, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Listar  FuncionÃ¡rio");
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

				frame = new JFrame();
				frame.setBounds(100, 100, 722, 353);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);

				JSeparator separator = new JSeparator();
				separator.setBounds(10, 45, 686, 9);
				frame.getContentPane().add(separator);

				JLabel lblNewLabel_2 = new JLabel("Nome completo");
				lblNewLabel_2.setBounds(49, 53, 114, 14);
				frame.getContentPane().add(lblNewLabel_2);

				JLabel lblNewLabel_3 = new JLabel("CPF");
				lblNewLabel_3.setBounds(49, 109, 46, 14);
				frame.getContentPane().add(lblNewLabel_3);

				JLabel lblNewLabel_5 = new JLabel("Cargo");
				lblNewLabel_5.setBounds(387, 109, 46, 14);
				frame.getContentPane().add(lblNewLabel_5);

				nome = new JTextField("teste save");
				nome.setBounds(49, 78, 634, 20);
				frame.getContentPane().add(nome);
				nome.setColumns(10);

				cpf = new JTextField("999.444.666-11");
				cpf.setBounds(49, 130, 310, 20);
				frame.getContentPane().add(cpf);
				cpf.setColumns(10);

				cargo = new JTextField("empresario");
				cargo.setBounds(387, 130, 294, 20);
				frame.getContentPane().add(cargo);
				cargo.setColumns(10);

				JLabel lblNewLabel_6 = new JLabel("");
				URL logo = this.getClass().getResource("/public/dark_logo_min.png");
				lblNewLabel_6.setIcon(new ImageIcon(logo));
				lblNewLabel_6.setBounds(302, 289, 114, 14);
				frame.getContentPane().add(lblNewLabel_6);

				JButton btnNewButton = new JButton("Adicionar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cadastrar();
					}
				});
				btnNewButton.setBounds(589, 256, 94, 23);
				frame.getContentPane().add(btnNewButton);

				JButton btnNewButton_1 = new JButton("Cancelar");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
					}
				});
				btnNewButton_1.setBounds(476, 256, 89, 23);
				frame.getContentPane().add(btnNewButton_1);

				JLabel lblNewLabel = new JLabel("Adicionar FuncionÃ¡rios");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(10, 13, 156, 14);
				frame.getContentPane().add(lblNewLabel);

				email = new JTextField("teste@save.com");
				email.setBounds(49, 193, 310, 20);
				frame.getContentPane().add(email);
				email.setColumns(10);

				senha = new JPasswordField("123456");
				senha.setBounds(389, 194, 294, 18);
				frame.getContentPane().add(senha);

				JLabel label_email = new JLabel("Email");
				label_email.setBounds(49, 167, 46, 14);
				frame.getContentPane().add(label_email);

				JLabel lblNewLabel_1 = new JLabel("Senha");
				lblNewLabel_1.setBounds(387, 167, 46, 14);
				frame.getContentPane().add(lblNewLabel_1);

				frame.setLocationRelativeTo(frame);

				frame.setVisible(true);
			}
		});
		cadastrar.setBounds(692, 341, 125, 23);
		frame.getContentPane().add(cadastrar);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.setBounds(480, 86, 125, 23);
		frame.getContentPane().add(pesquisar);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
