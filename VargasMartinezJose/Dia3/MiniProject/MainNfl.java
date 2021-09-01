package miniproject.bootcamp.mnfl;

public class MainNfl {
    public static final String PLAYER_LINE = "**********Player*********";
    public static final String NEW_PLAYER_LINE = "**********New Player*********";
    public static final String INJURED_PLAYER_LINE = "**********Injured Player**********";
    public static final String TRANSFERABLE_PLAYER_LINE = "**********Transferable Player**********";
    public static void main(String[] args) {
        Player player = new Player(01, "T. Brady", 40, "Active", "Bucaneers", "QB", 5);
        InjuredPlayer injured = new InjuredPlayer(02, "Jj Watts");
        TransferablePlayer transferable = new TransferablePlayer(03, "Aaron Rodgers");
        player.showData(PLAYER_LINE);
        player.name = "José V.";
        player.showData(NEW_PLAYER_LINE);
        injured.showData(INJURED_PLAYER_LINE);
        transferable.showData(TRANSFERABLE_PLAYER_LINE);
    }
}