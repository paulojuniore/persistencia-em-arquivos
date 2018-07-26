package arquivos_serializados;

import java.io.Serializable;

public class Account implements Serializable {
	
	private int conta;
	private String nome;
	private String sobrenome;
	private double saldo;
	
	// inicializa uma Account com os valores fornecidos.
	public Account(int conta, String nome, String sobrenome, double saldo) {
		this.setConta(conta);
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setSaldo(saldo);
	}

	// retorna o numero da conta.
	public int getConta() {
		return conta;
	}

	// altera o numero da conta.
	public void setConta(int conta) {
		this.conta = conta;
	}

	// retorna o nome do usuario.
	public String getNome() {
		return nome;
	}

	// altera o nome do usuario.
	public void setNome(String nome) {
		this.nome = nome;
	}

	// retorna o sobrenome do usuario.
	public String getSobrenome() {
		return sobrenome;
	}

	// altera o sobrenome do usuario.
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	// retorna o saldo da conta.
	public double getSaldo() {
		return saldo;
	}

	// altera o saldo da conta.
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
