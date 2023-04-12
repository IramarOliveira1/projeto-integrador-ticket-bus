package br.ba.fvc.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class CadastrarVendaView {

	private JFrame frame;
	private JTextField nome;
	private JTextField cpf;
	private JTextField valor;
	private JTextField hora;
	private JTextField data;
	private JTextField poltrona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVendaView window = new CadastrarVendaView();
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
	public CadastrarVendaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 714, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Adicionar Vendas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 18, 145, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("CPF");
		lblNewLabel_4.setBounds(361, 53, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_7 = new JLabel("Data Partida");
		lblNewLabel_7.setBounds(10, 167, 122, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Hora Partida");
		lblNewLabel_8.setBounds(361, 167, 145, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nome");
		lblNewLabel_9.setBounds(10, 53, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Poltrona");
		lblNewLabel_10.setBounds(10, 209, 70, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Valor Passagem:");
		lblNewLabel_11.setBounds(30, 209, 102, -14);
		frame.getContentPane().add(lblNewLabel_11);
		
		nome = new JTextField();
		nome.setBounds(10, 78, 327, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setBounds(361, 78, 327, 20);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		valor = new JTextField();
		valor.setBounds(361, 231, 327, 20);
		frame.getContentPane().add(valor);
		valor.setColumns(10);
		
		hora = new JTextField();
		hora.setBounds(361, 183, 327, 20);
		frame.getContentPane().add(hora);
		hora.setColumns(10);
		
		data = new JTextField();
		data.setBounds(10, 184, 327, 17);
		frame.getContentPane().add(data);
		data.setColumns(10);
		
		poltrona = new JTextField();
		poltrona.setBounds(10, 231, 327, 20);
		frame.getContentPane().add(poltrona);
		poltrona.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Valor Passagem");
		lblNewLabel_12.setBounds(361, 209, 102, 23);
		frame.getContentPane().add(lblNewLabel_12);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 43, 678, 12);
		frame.getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(402, 279, 138, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Concluir venda");
		btnNewButton_1.setBounds(550, 279, 140, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JComboBox<Object> origem = new JComboBox<Object>();
		origem.setBounds(10, 134, 327, 22);
		frame.getContentPane().add(origem);
		
		JComboBox<Object> destino = new JComboBox<Object>();
		destino.setBounds(361, 134, 327, 22);
		frame.getContentPane().add(destino);
		
		JLabel lblNewLabel_2 = new JLabel("Cidade Origem");
		lblNewLabel_2.setBounds(10, 109, 122, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Cidade Destino");
		lblNewLabel_5.setBounds(361, 109, 132, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_6.setIcon(new ImageIcon(logo));
		lblNewLabel_6.setBounds(305, 329, 114, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
