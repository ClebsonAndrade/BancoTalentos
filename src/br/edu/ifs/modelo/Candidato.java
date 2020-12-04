package br.edu.ifs.modelo;

public class Candidato {
	
	private int id;
	private String nome;
	private String cpf;
	private String senha;
	private String formacao_academica;
	private String experiencia_prof;
	private String aperfeicoamento;
	private String telefone;
	private String email;
	
	public Candidato() {
		super();
	}

	public Candidato(int id, String nome, String cpf, String senha, String formacao_academica, String experiencia_prof,
			String aperfeicoamento, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.formacao_academica = formacao_academica;
		this.experiencia_prof = experiencia_prof;
		this.aperfeicoamento = aperfeicoamento;
		this.telefone = telefone;
		this.email = email;
	}
	
	

	public Candidato(String nome, String cpf, String senha, String formacao_academica, String experiencia_prof,
			String aperfeicoamento, String telefone, String email) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.formacao_academica = formacao_academica;
		this.experiencia_prof = experiencia_prof;
		this.aperfeicoamento = aperfeicoamento;
		this.telefone = telefone;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFormacao_academica() {
		return formacao_academica;
	}

	public void setFormacao_academica(String formacao_academica) {
		this.formacao_academica = formacao_academica;
	}

	public String getExperiencia_prof() {
		return experiencia_prof;
	}

	public void setExperiencia_prof(String experiencia_prof) {
		this.experiencia_prof = experiencia_prof;
	}

	public String getAperfeicoamento() {
		return aperfeicoamento;
	}

	public void setAperfeicoamento(String aperfeicoamento) {
		this.aperfeicoamento = aperfeicoamento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
