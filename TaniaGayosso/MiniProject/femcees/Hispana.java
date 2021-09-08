package mini.project.femcees;

public class Hispana extends Femcees implements Activities, RecordLabel {

	private String previousName;

	public Hispana() {

	}

	public Hispana(String name, String stageName, String nationality, String popularSong, int spotifyPlays,
			String previousName) {
		super(name, stageName, nationality, popularSong, spotifyPlays);
		this.previousName = previousName;
	}

	public String getPreviousName() {
		return previousName;
	}

	public void setPreviousName(String previousName) {
		this.previousName = previousName;
	}
	
	public void showData() {
		System.out.println("Her previous stage name was "+ this.previousName);
	}
	

	@Override
	public String createSongs() {
		return "The last song Hispana released was No puedes parar";
	}

	@Override
	public String giveConcerts() {
		return "The next concert of Hispana is in Pátzcuaro, Michoacán on September 4th";
	}

	@Override
	public String sellingMerch() {
		return "The new merch is available at mambastik.com.mx";
	}
	
	@Override
	public String nameOfRecordLabel() {
		return "Universal Music";
	}
	
	@Override
	public int numberOfAlbums() {
		return 4;
	}

	@Override
	public String nameOfAlbums() {
		return "Mamba Negra, Los González, Mudando de piel y Mujer Fuego";
	}
}
