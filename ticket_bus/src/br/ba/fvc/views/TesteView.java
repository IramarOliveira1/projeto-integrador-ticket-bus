package br.ba.fvc.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.ba.fvc.controllrs.LoginController;

public class TesteView {

	JFrame frame;

	public LoginController user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteView window = new TesteView(null);
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
	 * @param fields
	 * @param fields
	 */
	public TesteView(LoginController fields) {
		this.user = fields;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("USUARIO " + this.user.getCargo());
		lblNewLabel.setBounds(68, 41, 325, 14);
		frame.getContentPane().add(lblNewLabel);

	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

}
