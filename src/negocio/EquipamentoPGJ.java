package negocio;

public class EquipamentoPGJ {

	private int id;
	private String tipo;
	private String modelo;
	private String situacao;
	private int pn;
	private String serial;
	private String comentario;
	
	public EquipamentoPGJ(){
		
	}

	public EquipamentoPGJ(int id, String tipo, String modelo, String situacao, int pn, String serial, String comentario) {
		this.id = id;
		this.tipo = tipo;
		this.modelo = modelo;
		this.situacao = situacao;
		this.pn = pn;
		this.serial = serial;
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public int getPn() {
		return pn;
	}

	public void setPn(int pn) {
		this.pn = pn;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

}
