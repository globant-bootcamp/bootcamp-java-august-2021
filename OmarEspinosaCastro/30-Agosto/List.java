
package collection;

public class List {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int numberElements = in.nextInt();
        ArrayList<Integer> lista = new ArrayList();
        for (int i = 0; i < numberElements; i++) {
            int valueElement = in.nextInt();
            lista.add(valueElement);
        }
        int queries = in.nextInt();
        for (int numberQuery = 0; numberQuery < queries; numberQuery++) {
            String querie = in.next();
            if (querie.equals("Insert")) {
                int index = in.nextInt();
                int value = in.nextInt();
                lista.add(index, value);
            }else{
                int index = in.nextInt();
                lista.remove(index);
            }
        }
        for (Integer elemento : lista) {
            System.out.print(elemento + " ");
        }
    }
}
