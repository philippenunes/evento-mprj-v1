package negocio;

public class Equipamento {

	private int id;
	private int notebook;
	private int impressora;

	public Equipamento() {

	}

	public Equipamento(int notebook, int impressora) {
		this.notebook = notebook;
		this.impressora = impressora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNotebook() {
		return notebook;
	}

	public void setNotebook(int notebook) {
		this.notebook = notebook;
	}

	public int getImpressora() {
		return impressora;
	}

	public void setImpressora(int impressora) {
		this.impressora = impressora;
	}

}
