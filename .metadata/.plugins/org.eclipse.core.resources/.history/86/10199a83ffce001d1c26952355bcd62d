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

public class CadastrarCidadeView {

	private JFrame frame;
	private JTextField cidade;
	private JTextField uf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCidadeView window = new CadastrarCidadeView();
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
	public CadastrarCidadeView() {
		initialize();
	}
	
	private void close() {
		frame.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 458, 9);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBounds(366, 220, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton(" Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton.setBounds(267, 220, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		cidade = new JTextField();
		cidade.setBounds(10, 85, 274, 20);
		frame.getContentPane().add(cidade);
		cidade.setColumns(10);
		
		uf = new JTextField();
		uf.setBounds(10, 141, 86, 20);
		frame.getContentPane().add(uf);
		uf.setColumns(10);
		
		JLabel label_cidade = new JLabel("Cidade");
		label_cidade.setBounds(10, 65, 46, 14);
		frame.getContentPane().add(label_cidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(10, 116, 46, 14);
		frame.getContentPane().add(lblUf);
		
		JLabel lblNewLabel = new JLabel("Adicionar Cidades");
		lblNewLabel.setBounds(10, 20, 115, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel logo_cidade = new JLabel("");
		URL cidade_logo = this.getClass().getResource("/public/cidade.png");
		logo_cidade.setIcon(new ImageIcon(cidade_logo));
		logo_cidade.setBounds(346, 61, 122, 126);
		frame.getContentPane().add(logo_cidade);
		
		JLabel lblNewLabel_6 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_6.setIcon(new ImageIcon(logo));
		lblNewLabel_6.setBounds(197, 276, 114, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
		
	}
}
