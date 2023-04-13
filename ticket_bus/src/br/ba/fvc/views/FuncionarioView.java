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
import java.sql.ResultSet;

public class FuncionarioView {

	private JFrame frame;
	private JTable table;
	private JTextField nome;
	private JTextField cpf;
	private JTextField email;
	private JTextField cargo;
	private JTextField input_filtrar;
	private JPasswordField senha;
	public DefaultTableModel list;
	public FuncionarioController user;
	private FuncionarioController funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuncionarioView window = new FuncionarioView(null);
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
	@SuppressWarnings("serial")
	public FuncionarioView(FuncionarioController fields) {
		FuncionarioController funcionario = new FuncionarioController();
		this.funcionario = funcionario;
		this.list = funcionario.listar();
		this.table = new JTable(this.list) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		this.user = fields;
		initialize();
	}

	private void home() {
		MenuView menu = new MenuView(this.user);
		menu.setVisible(true);
		frame.dispose();
	}

	private void cadastrar() {
		char[] senhaChar = senha.getPassword();

		String ConvertChar = String.valueOf(senhaChar);

		this.funcionario.setNome(nome.getText());
		this.funcionario.setCpf(cpf.getText());
		this.funcionario.setCargo(cargo.getText());
		this.funcionario.setEmail(email.getText());
		this.funcionario.setSenha(ConvertChar);
		this.list = funcionario.incluir();

		frame.setVisible(false);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void filtrar() {
		this.funcionario.setNome(input_filtrar.getText());

		this.list = this.funcionario.filtrar();

		input_filtrar.setText("");

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void limparFiltro() {
		this.list = funcionario.listar();
		this.list.fireTableDataChanged();
	}

	private void excluir() {
		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();

		this.list = this.funcionario.excluir(id);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	private void campos(String criarOuAlterar) {

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

		nome = new JTextField("");
		nome.getText();
		nome.setBounds(49, 78, 634, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);

		cpf = new JTextField("");
		cpf.setBounds(49, 130, 310, 20);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);

		cargo = new JTextField("");
		cargo.setBounds(387, 130, 294, 20);
		frame.getContentPane().add(cargo);
		cargo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("");
		URL logo = this.getClass().getResource("/public/dark_logo_min.png");
		lblNewLabel_6.setIcon(new ImageIcon(logo));
		lblNewLabel_6.setBounds(302, 289, 114, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		if (criarOuAlterar.equals("cadastrar")) {
			
			JLabel lblNewLabel = new JLabel("Adicionar Funcionários");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 13, 156, 14);
			frame.getContentPane().add(lblNewLabel);
						
			JButton adicionar = new JButton("Adicionar");
			adicionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cadastrar();
				}
			});
			adicionar.setBounds(589, 256, 94, 23);
			frame.getContentPane().add(adicionar);
		}else {
			
			JLabel lblNewLabel = new JLabel("Atualizar Funcionários");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel.setBounds(10, 13, 156, 14);
			frame.getContentPane().add(lblNewLabel);
			
			JButton alterar = new JButton("Atualizar");
			alterar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					alterar();
				}
			});
			alterar.setBounds(589, 256, 94, 23);
			frame.getContentPane().add(alterar);
		}

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(476, 256, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		email = new JTextField("");
		email.setBounds(49, 193, 310, 20);
		frame.getContentPane().add(email);
		email.setColumns(10);

		senha = new JPasswordField("");
		senha.setBounds(389, 194, 294, 18);
		frame.getContentPane().add(senha);

		JLabel label_email = new JLabel("");
		label_email.setBounds(49, 167, 46, 14);
		frame.getContentPane().add(label_email);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(387, 167, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		frame.setLocationRelativeTo(frame);

		frame.setVisible(true);
	}

	private void carregarCamposAlterar() {
		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();
		ResultSet result = null;

		try {
			result = funcionario.carregaCamposAlterar(id);
			result.next();
			
			nome.setText(result.getString("nome"));
			cpf.setText(result.getString("cpf"));
			cargo.setText(result.getString("cargo"));
			email.setText(result.getString("email"));
			senha.setText(result.getString("senha"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void alterar() {
		String id = this.table.getModel().getValueAt(this.table.getSelectedRow(), 0).toString();
		
		char[] senhaChar = senha.getPassword();

		String ConvertChar = String.valueOf(senhaChar);

		this.funcionario.setNome(nome.getText());
		this.funcionario.setCpf(cpf.getText());
		this.funcionario.setCargo(cargo.getText());
		this.funcionario.setEmail(email.getText());
		this.funcionario.setSenha(ConvertChar);
		this.list = funcionario.alterar(id);
		
		frame.setVisible(false);

		this.table.setModel(this.list);
		this.list.fireTableDataChanged();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {

		this.table.setRowSelectionAllowed(false);
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

		input_filtrar = new JTextField("");
		input_filtrar.setBounds(20, 87, 447, 20);
		frame.getContentPane().add(input_filtrar);
		input_filtrar.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Pesquisar");
		lblNewLabel_2.setBounds(20, 65, 76, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		URL urlToImage = this.getClass().getResource("/public/listagem_funcionario.png");
		lblNewLabel_3.setIcon(new ImageIcon(urlToImage));
		lblNewLabel_3.setBounds(711, 164, 106, 130);
		frame.getContentPane().add(lblNewLabel_3);

		JButton alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campos("alterar");
				carregarCamposAlterar();
			}
		});
		alterar.setBounds(692, 375, 125, 23);
		frame.getContentPane().add(alterar);

		JButton excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluir();
			}
		});
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

		JLabel lblNewLabel = new JLabel("Listar  Funcionário");
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
				campos("cadastrar");
				frame.setVisible(true);
			}
		});
		cadastrar.setBounds(692, 341, 125, 23);
		frame.getContentPane().add(cadastrar);

		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		pesquisar.setBounds(480, 86, 125, 23);
		frame.getContentPane().add(pesquisar);

		JButton limpar_filtro = new JButton("Limpar filtro");
		limpar_filtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparFiltro();
			}
		});
		limpar_filtro.setBounds(613, 86, 125, 23);
		frame.getContentPane().add(limpar_filtro);

		frame.setLocationRelativeTo(frame);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}
}
