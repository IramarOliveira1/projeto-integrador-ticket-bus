package br.ba.fvc.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class CadastrarRotaView {

	private JFrame frame;
	private JTextField placa;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarRotaView window = new CadastrarRotaView();
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
	public CadastrarRotaView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 681, 14);
		frame.getContentPane().add(separator);

		JLabel lblNomeMotorista = new JLabel("Nome Motorista");
		lblNomeMotorista.setBounds(10, 62, 149, 14);
		frame.getContentPane().add(lblNomeMotorista);

		JLabel lblPlacaVeculo = new JLabel("Placa Veículo");
		lblPlacaVeculo.setBounds(10, 116, 86, 14);
		frame.getContentPane().add(lblPlacaVeculo);

		JLabel label_destino = new JLabel("Cidade Destino");
		label_destino.setBounds(360, 172, 120, 14);
		frame.getContentPane().add(label_destino);

		JLabel label_origin = new JLabel("Cidade Origem");
		label_origin.setBounds(10, 172, 120, 14);
		frame.getContentPane().add(label_origin);

		JLabel lblDataPartida = new JLabel("Data Partida");
		lblDataPartida.setBounds(360, 116, 120, 14);
		frame.getContentPane().add(lblDataPartida);

		placa = new JTextField();
		placa.setBounds(10, 141, 316, 20);
		frame.getContentPane().add(placa);
		placa.setColumns(10);

		data = new JTextField();
		data.setBounds(360, 141, 316, 20);
		frame.getContentPane().add(data);
		data.setColumns(10);

		JComboBox<Object> motorista = new JComboBox<Object>();
		motorista.setBounds(10, 87, 666, 22);
		frame.getContentPane().add(motorista);

		JComboBox<Object> cidade_origin = new JComboBox<Object>();
		cidade_origin.setBounds(10, 194, 316, 22);
		frame.getContentPane().add(cidade_origin);

		JComboBox<Object> cidade_destino = new JComboBox<Object>();
		cidade_destino.setBounds(360, 194, 316, 22);
		frame.getContentPane().add(cidade_destino);

		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		cancelar.setBounds(435, 258, 111, 23);
		frame.getContentPane().add(cancelar);

		JButton cadastrar = new JButton("Cadastrar");
		cadastrar.setBounds(565, 258, 111, 23);
		frame.getContentPane().add(cadastrar);

		JLabel lblNewLabel = new JLabel("Adicionar Rotas");
		lblNewLabel.setBounds(10, 20, 115, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_6.setIcon(new ImageIcon(logo));
		lblNewLabel_6.setBounds(304, 313, 114, 14);
		frame.getContentPane().add(lblNewLabel_6);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
