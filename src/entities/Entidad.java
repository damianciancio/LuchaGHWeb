package entities;

public class Entidad {
	private int id;
	private estadoData estData;
	public enum estadoData { New, Modified, Unmodified, Deleted };
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public estadoData getEstData() {
		return estData;
	}

	public void setEstData(estadoData estData) {
		this.estData = estData;
	}
	
	
}
