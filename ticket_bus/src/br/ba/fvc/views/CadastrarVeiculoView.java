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

public class CadastrarVeiculoView {

	private JFrame frame;
	private JTextField placa;
	private JTextField data_compra;
	private JTextField modelo;
	private JTextField qtd;
	private JTextField numero_veiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVeiculoView window = new CadastrarVeiculoView();
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
	public CadastrarVeiculoView() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 610, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 563, 9);
		frame.getContentPane().add(separator);

		qtd = new JTextField();
		qtd.setBounds(313, 195, 260, 20);
		frame.getContentPane().add(qtd);
		qtd.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel(" Quant. de poltrona");
		lblNewLabel_5.setBounds(309, 170, 115, 14);
		frame.getContentPane().add(lblNewLabel_5);

		data_compra = new JTextField();
		data_compra.setBounds(10, 195, 260, 20);
		frame.getContentPane().add(data_compra);
		data_compra.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel(" Modelo");
		lblNewLabel_2.setBounds(311, 107, 68, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel(" Data da compra");
		lblNewLabel_4.setBounds(10, 170, 115, 14);
		frame.getContentPane().add(lblNewLabel_4);

		modelo = new JTextField();
		modelo.setBounds(313, 132, 260, 20);
		frame.getContentPane().add(modelo);
		modelo.setColumns(10);

		JButton btnNewButton = new JButton(" Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(361, 257, 89, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton(" Adicionar");
		btnNewButton_1.setBounds(473, 257, 100, 23);
		frame.getContentPane().add(btnNewButton_1);

		placa = new JTextField();
		placa.setBounds(10, 132, 260, 20);
		frame.getContentPane().add(placa);
		placa.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel(" Placa");
		lblNewLabel_1.setBounds(10, 107, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		numero_veiculo = new JTextField();
		numero_veiculo.setBounds(10, 76, 563, 20);
		frame.getContentPane().add(numero_veiculo);
		numero_veiculo.setColumns(10);

		JLabel nemeracao = new JLabel("Numeração Veículo");
		nemeracao.setBounds(10, 51, 159, 14);
		frame.getContentPane().add(nemeracao);

		JLabel lblNewLabel = new JLabel("Adicionar Veículos");
		lblNewLabel.setBounds(10, 20, 115, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_6.setIcon(new ImageIcon(logo));
		lblNewLabel_6.setBounds(245, 317, 114, 14);
		frame.getContentPane().add(lblNewLabel_6);
		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
