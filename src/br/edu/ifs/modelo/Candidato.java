package br.edu.ifs.modelo;

public class Candidato {
	
	private int id;
	private String nome;
	private String cpf;
	private String senha;
	private String formacaoAcademica;
	private String experienciaProf;
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
		this.formacaoAcademica = formacao_academica;
		this.experienciaProf = experiencia_prof;
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
		this.formacaoAcademica = formacao_academica;
		this.experienciaProf = experiencia_prof;
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

	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacao_academica) {
		this.formacaoAcademica = formacao_academica;
	}

	public String getExperienciaProf() {
		return experienciaProf;
	}

	public void setExperienciaProf(String experiencia_prof) {
		this.experienciaProf = experiencia_prof;
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
