package polymorphism;

public abstract class Place {
	private String name;
	private double large;
	private double width;
	
	public Place() {}

	public Place(String name, double large, double width) {
		super();
		this.name = name;
		this.large = large;
		this.width = width;
	}
	
	public abstract String typeBuilding();
	
	public double getArea() {
		return this.large * this.width;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLarge() {
		return large;
	}

	public void setLarge(double large) {
		this.large = large;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	

}
