
package collection;

public class Map {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lengthDirectory = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> directorio = new HashMap<String, Integer>();
        for (int rowDirectory = 0; rowDirectory < lengthDirectory; rowDirectory++) {
            String nameClave = in.nextLine();
            int valueNumber = in.nextInt();
            directorio.put(nameClave, valueNumber);
            in.nextLine();
        }
        String findUser =  findUser = in.nextLine();
        while (!findUser.equals("")) {
            if(directorio.containsKey(findUser)){
                System.out.println(findUser+"="+directorio.get(findUser));
            }else{
                System.out.println("Not found");
            }
            findUser = in.nextLine();
        }
    }
}
