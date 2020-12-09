package Funcionario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQualOpoDesejada = new JLabel("\t\t\t\t\t\t\t\t\tQual op\u00E7\u00E3o desejada:\r\n");
		lblQualOpoDesejada.setFont(new Font("Sylfaen", Font.PLAIN, 26));
		lblQualOpoDesejada.setBounds(84, 11, 237, 82);
		contentPane.add(lblQualOpoDesejada);
		
		JButton btnAdd = new JButton("ADICIONAR FUNCIONARIO");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NovoFuncionario().setVisible(true);
				
				dispose();
			}
		});
		btnAdd.setBounds(60, 104, 280, 23);
		contentPane.add(btnAdd);
		
		JButton btnListarFuncionarios = new JButton("LISTAR FUNCIONARIOS");
		btnListarFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ListarFuncionario().setVisible(true);
				dispose();
			}
		});
		btnListarFuncionarios.setBounds(60, 155, 280, 23);
		contentPane.add(btnListarFuncionarios);
		
		JButton btnDeletarFuncionario = new JButton("DELETAR FUNCIONARIO");
		btnDeletarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeletarFuncionario().setVisible(true);
				dispose();
			}
		});
		btnDeletarFuncionario.setBounds(60, 203, 280, 23);
		contentPane.add(btnDeletarFuncionario);
		
	
	}
}
