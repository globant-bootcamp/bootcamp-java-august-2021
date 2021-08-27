package classStore;

public class Product {
	private int id;
	private String name;
	private double price;
	private Integer quantity;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(int id, String name, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String descriptionProduct() {
		String result = "Product:\n id = " + id + ",\n name = " + name + ",\n price = " + price;
		if (quantity == null) {
			result += "\n quantity field not updated";
		} else {
			result += "\n quantity = " + quantity;
		}
		return result;
	}

	public String totalPrice() {
		String totalPrice = "";
		if (quantity == null) {
			totalPrice = "\n ::quantity field not updated::";
		} else {
			totalPrice = "\n total price: " + (price * quantity);
		}
		return totalPrice;
	}

}
