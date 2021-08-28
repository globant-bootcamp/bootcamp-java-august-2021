package miniproject;

public class Main {

    public static void main(String[] args) {

        ShoppingList shoppingList = new ShoppingList(
                new Soap(10.0f, 2),
                new FabricSoftener(20.f, 5),
                new ToothPaste(15.99f, 2)
        );

        shoppingList.printProducts();

    }

}
