package br.edu.ifs.modelo;

public class Empresa {
	
	private int id;
	private String razaoSocial;
	private String cnpj;
	private String telefone;
	private String email;
	private String senha;
	private String setor;
	private String atividadeEconomica;
	
	public Empresa() {
		super();
	}

	public Empresa(int id, String razao_social, String cnpj, String telefone, String email, String senha, String setor,
			String atividade_economica) {
		super();
		this.id = id;
		this.razaoSocial = razao_social;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.setor = setor;
		this.atividadeEconomica = atividade_economica;
	}

	public Empresa(String razao_social, String cnpj, String telefone, String email, String senha, String setor,
			String atividade_economica) {
		super();
		this.razaoSocial = razao_social;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.setor = setor;
		this.atividadeEconomica = atividade_economica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razao_social) {
		this.razaoSocial = razao_social;
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

	public String getAtividadeEconomica() {
		return atividadeEconomica;
	}

	public void setAtividadeEconomica(String atividade_economica) {
		this.atividadeEconomica = atividade_economica;
	}
}
