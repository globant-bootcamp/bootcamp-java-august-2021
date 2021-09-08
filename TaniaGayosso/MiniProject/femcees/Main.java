package mini.project.femcees;

public class Main {

	public static void main(String[] args) {

		Femcees femcee = new Femcees();
		femcee.setName("Fabiola Ledesma");
		femcee.setStageName("Masta Quba");
		femcee.setNationality("Quéretaro, México");
		femcee.setPopularSong("Autodefensa");
		femcee.setSpotifyPlays(245671);
		femcee.showData();

		MastaQuba mastaQuba = new MastaQuba();
		mastaQuba.setSoloist("");
		mastaQuba.setPastGroups("Batallones Femeninos");
		mastaQuba.showData();

		System.out.println("=================================================");

		SomosGuerreras somosGuerreras = new SomosGuerreras();
		somosGuerreras.setMembersOfGroup("Rebeca Lane, Audry Funk y Nakury");
		somosGuerreras.showData();

		Femcees groupOfFemcees = new Femcees();
		groupOfFemcees.setNationality("Guatemala, Mexico-USA and Costa Rica");
		groupOfFemcees.setPopularSong("Somos Guerreras");
		groupOfFemcees.setSpotifyPlays(58516);
		groupOfFemcees.showDataGroups();

		System.out.println("=================================================");

		Femcees femcee2 = new Femcees();
		femcee2.setName("Patricia Polet González Osoria");
		femcee2.setStageName("Hispana");
		femcee2.setNationality("Coahuila, México");
		femcee2.setPopularSong("La Mexicana");
		femcee2.setSpotifyPlays(4694919);
		femcee2.showData();

		Hispana hispana = new Hispana();
		hispana.setPreviousName("Mamba Negra");
		hispana.showData();
	}

}
