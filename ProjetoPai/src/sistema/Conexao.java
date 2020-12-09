package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;

import Funcionario.Funcionario;

public class Conexao {

	// parâmetros para conexão
	private Connection conexao;
	private String URLBD = "jdbc:mysql://localhost:3307/empresa";
	private String usuario = "root";
	private String senha = "1234";

	// criando a conexão no construtor
	public Conexao() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection(URLBD, usuario, senha);
			System.out.println("Conexão ok!");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro de Conexão!");
		}
	}

	// criando um método para acessar a conexão
	public Connection getConexao() {
		return conexao;
	}

	public void Desconecta() {
		try {
			conexao.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
		}
	}

	public boolean cadastrarFunc(Funcionario Func) {
		try {
			PreparedStatement comando = (PreparedStatement) getConexao().prepareStatement(
					"INSERT INTO funcionario (nome, nomecompleto, endereco, telefone, disponibilidade) VALUES (?, ?, ?, ?, ?)");
			comando.setString(1, Func.getNome());
			comando.setString(2, Func.getNomeCompleto());
			comando.setString(3, Func.getEndereco());
			comando.setString(4, Func.getTelefone());
			comando.setString(5, Func.getDisponibilidade());
			comando.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public ResultSet listarFunc() {
		ResultSet dados = null;
		try {
			PreparedStatement comando = (PreparedStatement) getConexao().prepareStatement("SELECT * from funcionario");
			dados = comando.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dados;
	}

	public boolean deletarFunc(Funcionario Func) {
		try {
			PreparedStatement comando = (PreparedStatement) getConexao()
					.prepareStatement("DELETE from funcionario WHERE nome=?");
			comando.setString(1, Func.getNome());
			comando.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
