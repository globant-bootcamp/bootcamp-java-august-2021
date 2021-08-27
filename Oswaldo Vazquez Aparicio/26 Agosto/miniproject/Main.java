package miniproject;

public class Main {

    public static void main(String[] args){

        ShoppingList shoppingList = new ShoppingList();
        shoppingList.addProductToBuy(new Soap(10.0f, 2));
        shoppingList.addProductToBuy(new FabricSoftener(20.f, 5));
        shoppingList.addProductToBuy(new ToothPaste(15.99f, 2));

        shoppingList.printProducts();

    }

}
