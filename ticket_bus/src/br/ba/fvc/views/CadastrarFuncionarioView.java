package br.ba.fvc.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
<<<<<<< HEAD

import br.ba.fvc.controllrs.FuncionarioController;

=======
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JPasswordField;

public class CadastrarFuncionarioView {

	private JFrame frame;
	private JTextField nome;
	private JTextField cpf;
<<<<<<< HEAD
	private JTextField email;
=======
	private JTextField textField_2;
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
	private JTextField cargo;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarFuncionarioView window = new CadastrarFuncionarioView();
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
	public CadastrarFuncionarioView() {
		initialize();
	}

<<<<<<< HEAD
	private void cadastrar() {
		FuncionarioController funcionario = new FuncionarioController();
		char[] senhaChar = senha.getPassword();

		String ConvertChar = String.valueOf(senhaChar);

		funcionario.setNome(nome.getText());
		funcionario.setCpf(cpf.getText());
		funcionario.setCargo(cargo.getText());
		funcionario.setEmail(email.getText());
		funcionario.setSenha(ConvertChar);
		funcionario.incluir();
=======
	private void close() {
		frame.setVisible(false);
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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

<<<<<<< HEAD
		nome = new JTextField("teste save");
=======
		nome = new JTextField();
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		nome.setBounds(49, 78, 634, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);

<<<<<<< HEAD
		cpf = new JTextField("999.444.666-11");
=======
		cpf = new JTextField();
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		cpf.setBounds(49, 130, 310, 20);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);

<<<<<<< HEAD
		cargo = new JTextField("empresario");
=======
		cargo = new JTextField();
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		cargo.setBounds(387, 130, 294, 20);
		frame.getContentPane().add(cargo);
		cargo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_6.setIcon(new ImageIcon(logo));
		lblNewLabel_6.setBounds(302, 289, 114, 14);
		frame.getContentPane().add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Adicionar");
<<<<<<< HEAD
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
=======
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		btnNewButton.setBounds(589, 256, 94, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				frame.setVisible(false);
=======
				close();
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
			}
		});
		btnNewButton_1.setBounds(476, 256, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

<<<<<<< HEAD
		JLabel lblNewLabel = new JLabel("Adicionar FuncionÃ¡rios");
=======
		JLabel lblNewLabel = new JLabel("Adicionar funcionários");
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 156, 14);
		frame.getContentPane().add(lblNewLabel);

<<<<<<< HEAD
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
=======
		textField_2 = new JTextField();
		textField_2.setBounds(49, 193, 310, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);

		senha = new JPasswordField();
		senha.setBounds(389, 194, 294, 18);
		frame.getContentPane().add(senha);

		JLabel email = new JLabel("Email");
		email.setBounds(49, 167, 46, 14);
		frame.getContentPane().add(email);
>>>>>>> 1c435c280ed7b4627346279ca7ad428c3e44a9ff

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(387, 167, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
