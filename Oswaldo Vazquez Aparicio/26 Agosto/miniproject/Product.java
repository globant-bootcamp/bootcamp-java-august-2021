package miniproject;

public class Product {

    private final float unitPrice;
    private final int quantity;

    public Product(float unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public float getTotalPrice() {
        return  quantity * unitPrice;
    }

}
