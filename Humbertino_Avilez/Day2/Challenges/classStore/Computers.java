package classStore;

public class Computers extends Product {
	private String graphicsCoprocessor;

	public Computers(int id, String name, double price, String graphicsCoprocessor) {
		super(id, name, price);
		this.graphicsCoprocessor = graphicsCoprocessor;
	}

	public Computers(int id, String name, double price, String graphicsCoprocessor, int quantity) {
		super(id, name, price, quantity);
		this.graphicsCoprocessor = graphicsCoprocessor;
	}

	public String getGraphicsCoprocessor() {
		return graphicsCoprocessor;
	}

	public void setGraphicsCoprocessor(String graphicsCoprocessor) {
		this.graphicsCoprocessor = graphicsCoprocessor;
	}

	@Override
	public String descriptionProduct() {
		return super.descriptionProduct() + "\n graphicsCoprocessor = " + graphicsCoprocessor + "\n";
	}

}
