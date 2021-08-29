public class Principal{
    public static void main(String[] args){

        NewPlayer jugador = new  NewPlayer(01, "T. Brady", 40, "Active", "Bucaneers", "QB", 5);
        InjuredPlayer lesionado = new InjuredPlayer(02, "Jj Watts");
        TransferiblePl transferible= new TransferiblePl(03, "Aaron Rodgers");
        jugador.showData("**********Jugador*********");
        jugador.name="Jose V.";
        jugador.showData("**********Nuevo Jugador*********");
        lesionado.showData("**********Jugador Intercambiado o Comprado**********");
        transferible.showData("**********Transferible**********");


    }
}