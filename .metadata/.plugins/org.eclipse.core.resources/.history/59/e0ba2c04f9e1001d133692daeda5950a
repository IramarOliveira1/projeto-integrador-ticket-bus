package br.ba.fvc.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import br.ba.fvc.controllrs.FuncionarioController;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.net.URL;

public class MenuView {

	private JFrame frame;
	public FuncionarioController user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView window = new MenuView(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuView(FuncionarioController fields) {
		this.user = fields;
		initialize();
	}

	private void windowEmployee() {
		FuncionarioView windowEmployee = new FuncionarioView(this.user);
		windowEmployee.setVisible(true);
		frame.dispose();
	}
	
	private void windowVehicle() {
		ListarVeiculoView windowVehicle = new ListarVeiculoView(this.user);
		windowVehicle.setVisible(true);
		frame.dispose();
	}

	private void windowCity() {
		ListarCidadeView windowCity = new ListarCidadeView(this.user);
		windowCity.setVisible(true);
		frame.dispose();
	}
	
	private void windowRouter() {
		ListarRotaView windowRouter = new ListarRotaView(this.user);
		windowRouter.setVisible(true);
		frame.dispose();
	}
	
	private void windowSale() {
		ListarVendaView windowSale = new ListarVendaView(this.user);
		windowSale.setVisible(true);
		frame.dispose();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Funcionario: " + this.user.getLogado());
		lblNewLabel.setBounds(136, 28, 248, 14);
		frame.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 414, 2);
		frame.getContentPane().add(separator);

		JButton btn_funcionario = new JButton("");
		btn_funcionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowEmployee();
			}
		});
		URL funcionario_image = this.getClass().getResource("/public/funcionario_menu.png");
		btn_funcionario.setIcon(new ImageIcon(funcionario_image));
		btn_funcionario.setBounds(20, 66, 97, 73);
		frame.getContentPane().add(btn_funcionario);

		JButton btn_veiculos= new JButton("");
		btn_veiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowVehicle();
			}
		});
		URL onibus_image = this.getClass().getResource("/public/onibus_menu.png");
		btn_veiculos.setIcon(new ImageIcon(onibus_image));
		btn_veiculos.setBounds(20, 177, 97, 73);
		frame.getContentPane().add(btn_veiculos);

		JButton btn_cidade = new JButton("");
		btn_cidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowCity();
			}
		});
		URL cidade_image = this.getClass().getResource("/public/cidade_menu.png");
		btn_cidade.setIcon(new ImageIcon(cidade_image));
		btn_cidade.setBounds(300, 66, 97, 73);
		frame.getContentPane().add(btn_cidade);

		JButton btn_rota = new JButton("");
		btn_rota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowRouter();
			}
		});
		URL rota_image = this.getClass().getResource("/public/rota_menu.png");
		btn_rota.setIcon(new ImageIcon(rota_image));
		btn_rota.setBounds(308, 177, 89, 73);
		frame.getContentPane().add(btn_rota);

		JButton btn_venda = new JButton("");
		btn_venda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowSale();
			}
		});
		URL venda_image = this.getClass().getResource("/public/venda_menu.png");
		btn_venda.setIcon(new ImageIcon(venda_image));
		btn_venda.setBounds(164, 119, 97, 73);
		frame.getContentPane().add(btn_venda);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(Boolean visible) {
		frame.setVisible(visible);
	}
}
