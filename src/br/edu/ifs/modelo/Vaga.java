package br.edu.ifs.modelo;

public abstract class Vaga {
	private int id;
	private String area;
	private String sub_area;
	private String descricao;
	private String competencia;
	private String habilidade;
	private String atitude;
	private String contratacao;
	private String requisitos;
	private String faixa_salarial;
	public Vaga(int id, String area, String sub_area, String descricao, String competencia, String habilidade,
			String atitude, String contratacao, String requisitos, String faixa_salarial) {
		super();
		this.id = id;
		this.area = area;
		this.sub_area = sub_area;
		this.descricao = descricao;
		this.competencia = competencia;
		this.habilidade = habilidade;
		this.atitude = atitude;
		this.contratacao = contratacao;
		this.requisitos = requisitos;
		this.faixa_salarial = faixa_salarial;
	}
	public Vaga(String area, String sub_area, String descricao, String competencia, String habilidade, String atitude,
			String contratacao, String requisitos, String faixa_salarial) {
		super();
		this.area = area;
		this.sub_area = sub_area;
		this.descricao = descricao;
		this.competencia = competencia;
		this.habilidade = habilidade;
		this.atitude = atitude;
		this.contratacao = contratacao;
		this.requisitos = requisitos;
		this.faixa_salarial = faixa_salarial;
	}
	public Vaga() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getSub_area() {
		return sub_area;
	}
	public void setSub_area(String sub_area) {
		this.sub_area = sub_area;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCompetencia() {
		return competencia;
	}
	public void setCompetencia(String competencia) {
		this.competencia = competencia;
	}
	public String getHabilidade() {
		return habilidade;
	}
	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
	public String getAtitude() {
		return atitude;
	}
	public void setAtitude(String atitude) {
		this.atitude = atitude;
	}
	public String getContratacao() {
		return contratacao;
	}
	public void setContratacao(String contratacao) {
		this.contratacao = contratacao;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getFaixa_salarial() {
		return faixa_salarial;
	}
	public void setFaixa_salarial(String faixa_salarial) {
		this.faixa_salarial = faixa_salarial;
	}
}
