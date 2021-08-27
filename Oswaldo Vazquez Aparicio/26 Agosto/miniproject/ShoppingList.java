package miniproject;

import java.util.LinkedList;

public class ShoppingList {

    private final LinkedList<Product> products;

    public ShoppingList(){
        products = new LinkedList<>();
    }

    public void addProductToBuy(Product product){
        products.add(product);
    }

    public void printProducts(){
        String tableFormat = "%-30s%-15s%-15s%-15s%n";
        System.out.println("========================================================================");
        System.out.printf(tableFormat, "Name", "UnitPrice", "Quantity", "Total Price");
        System.out.println("========================================================================");
        products.forEach(product -> {
            String productName = product.getClass().getSimpleName();
            System.out.printf(tableFormat, productName, product.getUnitPrice(), product.getQuantity(), product.getTotalPrice());
        });
        System.out.println("========================================================================");
    }

}
