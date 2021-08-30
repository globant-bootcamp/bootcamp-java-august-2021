package classStore;

public class Test {

	public static void main(String[] args) {
		Product productOne = new Computers(1, "Acer RaceX", 24000.89, "GeForce GTX1660");
		Product productTwo = new Clothes(2, "adidas Women's Essentials Logo Sweatshirt", 665.59, "M", 12);

		System.out.print(productOne.descriptionProduct());
		System.out.print(productTwo.descriptionProduct());
		System.out.print(productTwo.totalPrice());
	}

}
