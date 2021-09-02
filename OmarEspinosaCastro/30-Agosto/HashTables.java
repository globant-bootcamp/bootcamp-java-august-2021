
package collection;

public class HashTables {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lengthMagazine = in.nextInt();
        int lengthNote = in.nextInt();
        String magazine[] = new String[lengthMagazine];
        for (int magazine_index = 0; magazine_index < lengthMagazine; magazine_index++) {
            magazine[magazine_index] = in.next();
        }
        String note[] = new String[lengthNote];
        for (int note_index = 0; note_index < lengthNote; note_index++) {
            note[note_index] = in.next();
        }
        System.out.println(ResultHashTables.checkMagazine(magazine, note)?"Yes":"No"); 
    }
}
