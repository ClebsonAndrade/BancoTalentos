package br.edu.ifs.modelo;

public class Empresa {
	
	private int id;
	private String razao_social;
	private String cnpj;
	private String telefone;
	private String email;
	private String senha;
	private String setor;
	private String atividade_economica;
	
	public Empresa() {
		super();
	}

	public Empresa(int id, String razao_social, String cnpj, String telefone, String email, String senha, String setor,
			String atividade_economica) {
		super();
		this.id = id;
		this.razao_social = razao_social;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.setor = setor;
		this.atividade_economica = atividade_economica;
	}

	public Empresa(String razao_social, String cnpj, String telefone, String email, String senha, String setor,
			String atividade_economica) {
		super();
		this.razao_social = razao_social;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.setor = setor;
		this.atividade_economica = atividade_economica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getAtividade_economica() {
		return atividade_economica;
	}

	public void setAtividade_economica(String atividade_economica) {
		this.atividade_economica = atividade_economica;
	}
}
