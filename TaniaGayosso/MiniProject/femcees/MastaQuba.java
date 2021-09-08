package mini.project.femcees;

public class MastaQuba extends Femcees implements Activities{

	private String soloist;
	private String pastGroups;

	public MastaQuba(){
	}

	public MastaQuba(String name, String stageName, String nationality, String popularSong, int spotifyPlays,
			String soloist, String pastGroups){
		super(name, stageName, nationality, popularSong, spotifyPlays);
		this.soloist = soloist;
		this.pastGroups = pastGroups;
	}

	public String getSoloist(){
		return soloist;
	}

	public void setSoloist(String soloist){
		this.soloist = soloist;
	}

	public String getPastGroups(){
		return pastGroups;
	}

	public void setPastGroups(String pastGroups){
		this.pastGroups = pastGroups;
	}

	public void showData(){

		System.out.println("She is a soloist");
		System.out.println("She participates in " + this.pastGroups + " " + "from 2015 to 2017");

	}

	@Override
	public String toString() {
		return "MastaQuba [soloist=" + soloist + ", pastGroups=" + pastGroups + "]";
	}
	
	@Override
	public String createSongs(){
		return "The last song Masta Quba released was Nosotras tenemos otros datos soon";
	}
	
	@Override
	public String giveConcerts() {
		return "The next concert of Masta Quba is in Mexico, City on November 1st";
	}
	
	@Override
	public String sellingMerch() {
		return "The new merch: Skirts, caps and earrings are available at mastaquba.com.mx";
	}
}
