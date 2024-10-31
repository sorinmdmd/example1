package business;

public class Feizeitbad {
	private String name;
	private float openAt;
	private float openUntil;
	private double temperatur;

	public Feizeitbad(String name, String openAt, String openUntil, String temperatur) {
		super();
		this.name = name;
		this.openAt = Float.parseFloat(openAt);
		this.openUntil = Float.parseFloat(openUntil);
		this.temperatur = Double.parseDouble(temperatur);
	}

	public String gibFreizeitbadZurueck(char trenner) {
		return this.getName() + trenner + this.getOpenAt() + trenner + this.getOpenUntil() + trenner
				+ this.getTemperatur();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getOpenAt() {
		return openAt;
	}

	public void setOpenAt(float openAt) {
		this.openAt = openAt;
	}

	public float getOpenUntil() {
		return openUntil;
	}

	public void setOpenUntil(float openUntil) {
		this.openUntil = openUntil;
	}

	public double getTemperatur() {
		return temperatur;
	}

	public void setTemperatur(double temperatur) {
		this.temperatur = temperatur;
	}

}
