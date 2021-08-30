package com.bootcamp.daytwo.miniproject;

public class Main {

    public static final Person[] MEMBERS_CLUB = new Person[12];
    public static final String BEFORE_GAME = "========== Before game ==========";
    public static final String IN_GAME = "========== In game ==========";
    public static final String AFTER_GAME = "========== After game ==========";
    public static final String CITY = "Madrid";

    public static void main(String[] args) {
        createMembersClub();
        beforeGame();
        inGame();
        afterGame();
    }

    public static void createMembersClub() {
        MEMBERS_CLUB[0] = new Coach("Franklin", "Rijkaard", 45);
        MEMBERS_CLUB[1] = new Player("Victor", "Valdés", 25, 1, "GoalKeeper");
        MEMBERS_CLUB[2] = new Player("Gianluca", "Zambrotta", 30, 11, "Defender");
        MEMBERS_CLUB[3] = new Player("Eric", "Abidal", 28, 22, "Defender");
        MEMBERS_CLUB[4] = new Player("Carles", "Puyol", 29, 5, "Defender");
        MEMBERS_CLUB[5] = new Player("Gabriel", "Milito", 27, 3, "Defender");
        MEMBERS_CLUB[6] = new Player("Xavi", "Hernández", 27, 6, "Midfielder");
        MEMBERS_CLUB[7] = new Player("Andres", "Iniesta", 23, 8, "Midfielder");
        MEMBERS_CLUB[8] = new Player("Yaya", "Touré", 24, 24, "Midfielder");
        MEMBERS_CLUB[9] = new Player("Ronaldo", "De Assis", 27, 10, "Attacker");
        MEMBERS_CLUB[10] = new Player("Leonel", "Messi", 20, 19, "Attacker");
        MEMBERS_CLUB[11] = new Player("Samuel", "Eto'o", 26, 9, "Attacker");
    }

    public static void beforeGame() {
        System.out.println(BEFORE_GAME);
        for (Person person : MEMBERS_CLUB) {
            person.travelToGame(CITY);
            person.meetToGame(CITY);
        }
        System.out.println(BEFORE_GAME);
    }

    public static void inGame() {
        System.out.println(IN_GAME);
        for (Person person : MEMBERS_CLUB) {
            if (person instanceof Coach) {
                ((Coach) person).leadTraining();
                ((Coach) person).leadGame();
            } else {
                ((Player) person).training();
                ((Player) person).playGame();
            }
        }
        System.out.println(IN_GAME);
    }

    public static void afterGame() {
        System.out.println(AFTER_GAME);
        for (Person person : MEMBERS_CLUB) {
            if (person instanceof Coach) {
                ((Coach) person).interview();
            } else {
                ((Player) person).interview();
            }
        }
        System.out.println(AFTER_GAME);
    }
}
