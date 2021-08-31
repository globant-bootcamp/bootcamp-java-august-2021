package miniproject.bootcamp.mnfl;

public class MainNfl {

    public static final String PLAYER_LINE = "**********Player*********";
    public static final String NEW_PLAYER_LINE = "**********New Player*********";
    public static final String INJ_PLAYER_LINE = "**********Injured Player**********";
    public static final String TRANSF_PLAYER = "**********Transferable Player**********";

    public static void main(String[] args) {

        NewPlayer player = new NewPlayer(01, "T. Brady", 40, "Active", "Bucaneers", "QB", 5);
        InjuredPlayer injured = new InjuredPlayer(02, "Jj Watts");
        TransferablePl transferable = new TransferablePl(03, "Aaron Rodgers");
        player.showData(PLAYER_LINE);
        player.name = "José V.";
        player.showData(NEW_PLAYER_LINE);
        injured.showData(INJ_PLAYER_LINE);
        transferable.showData(TRANSF_PLAYER);

    }
}