package Funcionario;

import java.io.File;

import javax.swing.JTextField;

public class Funcionario {

	private String nome;
	private String nomecompleto;
	private String telefone;
	private String endereco;
	private String disponibilidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeCompleto() {
		return nomecompleto;
	}

	public void setNomeCompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
