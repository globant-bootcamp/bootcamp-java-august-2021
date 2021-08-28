package miniproject;

import java.util.Arrays;

public class ShoppingList {

    private final Product[] products;

    public ShoppingList(Product ... products){
        this.products = products;
    }

    public void printProducts(){
        String tableFormat = "%-30s%-15s%-15s%-15s%n";
        String separatorLine = "========================================================================";
        System.out.println(separatorLine);
        System.out.printf(tableFormat, "Name", "UnitPrice", "Quantity", "Total Price");
        System.out.println(separatorLine);
        Arrays.stream(products).forEach(product -> {
            String productName = product.getClass().getSimpleName();
            System.out.printf(tableFormat, productName, product.getUnitPrice(), product.getQuantity(), product.getTotalPrice());
        });
        System.out.println(separatorLine);
    }

}
