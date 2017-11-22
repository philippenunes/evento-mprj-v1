package negocio;

public class Evento {

	private int id;
	private String solicitante;
	private String telefone;
	private String nomeEvento;
	private String dataEvento;
	private String localEvento;
	private String horaInicio;
	private String horaTermino;
	private String presencaTecnico;
	private String acessoRede;
	private int registro;
	private String observacao;
	private Equipamento equipamento;


	public Evento(int id, String solicitante, String telefone, String nomeEvento, String data, String localEvento,
			String horaInicio, String horaTermino, String presencaTecnico, String acessoRede, int registro,
			String observacao, int notebook, int impressora) {

		Equipamento equipamento = new Equipamento(notebook, impressora);
		
		this.id = id;
		this.solicitante = solicitante;
		this.telefone = telefone;
		this.nomeEvento = nomeEvento;
		this.dataEvento = data;
		this.localEvento = localEvento;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.presencaTecnico = presencaTecnico;
		this.acessoRede = acessoRede;
		this.registro = registro;
		this.observacao = observacao;
		this.equipamento = equipamento;
		
		
	}

	public Evento() {

	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getPresencaTecnico() {
		return presencaTecnico;
	}

	public void setPresencaTecnico(String presencaTecnico) {
		this.presencaTecnico = presencaTecnico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}

	public String getAcessoRede() {
		return acessoRede;
	}

	public void setAcessoRede(String acessoRede) {
		this.acessoRede = acessoRede;
	}

}
