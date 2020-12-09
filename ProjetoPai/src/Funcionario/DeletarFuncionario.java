package Funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeletarFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textId;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarFuncionario frame = new DeletarFuncionario();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeletarFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(38, 43, 46, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textId.requestFocus();
				}
			}

		});
		textNome.setBounds(94, 40, 86, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(38, 91, 46, 14);
		contentPane.add(lblId);

		textId = new JTextField();
		textId.setBounds(94, 88, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);

		JButton btnDeletar = new JButton("DELETAR");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexao c = new Conexao();
				Funcionario func = new Funcionario();
				func.setNome(textNome.getText());
				if (c.deletarFunc(func)) {
					JOptionPane.showMessageDialog(null, "CADASTRO DELETADO COM SUCESSO!");
				} else
					JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL DELETAR O CADASTRO!");

				c.Desconecta();

			}
		});
		btnDeletar.setBounds(52, 206, 128, 23);
		contentPane.add(btnDeletar);

		JButton btnVoltarAoMenu = new JButton("VOLTAR AO MENU");
		btnVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPrincipal().setVisible(true);
				
				dispose();
			}
		});
		btnVoltarAoMenu.setBounds(243, 206, 149, 23);
		contentPane.add(btnVoltarAoMenu);

		JLabel lblOu = new JLabel("OU");
		lblOu.setBounds(123, 65, 46, 20);
		contentPane.add(lblOu);

		JLabel lblNewLabel = new JLabel("NOME COMPLETO:");
		lblNewLabel.setBounds(38, 127, 113, 14);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(139, 124, 229, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
