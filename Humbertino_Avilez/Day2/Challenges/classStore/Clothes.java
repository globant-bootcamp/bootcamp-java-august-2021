package classStore;

public class Clothes extends Product {
	private String size;

	public Clothes(int id, String name, double price, String size) {
		super(id, name, price);
		this.size = size;
	}

	public Clothes(int id, String name, double price, String size, int quantity) {
		super(id, name, price, quantity);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String descriptionProduct() {
		return super.descriptionProduct() + "\n size = " + size + "\n";
	}

}
