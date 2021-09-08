package mini.project.femcees;

public class Femcees{

	private String name;
	private String stageName;
	private String nationality;
	private String popularSong;
	private int spotifyPlays;

	public Femcees(){

	}

	public Femcees(String name, String stageName){

	}

	public Femcees(String nationality, String popularSong, int spotifyPlays){

	}

	public Femcees(String name, String stageName, String nationality, String popularSong, int spotifyPlays){

	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getStageName(){
		return stageName;
	}

	public void setStageName(String stageName){
		this.stageName = stageName;
	}

	public String getNationality(){
		return nationality;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getPopularSong(){
		return popularSong;
	}

	public void setPopularSong(String popularSong){
		this.popularSong = popularSong;
	}

	public int getSpotifyPlays(){
		return spotifyPlays;
	}

	public void setSpotifyPlays(int spotifyPlays){
		this.spotifyPlays = spotifyPlays;
	}

	public void showData(){

		System.out.println(this.name);
		System.out.println("Her stage name is " + this.stageName);
		System.out.println("She is from " + this.nationality);
		System.out.println("Her most popular song is " + this.popularSong);
		System.out.println("That song has" + " " + this.spotifyPlays + " " + "plays on Spotify");

	}

	public void showDataGroups(){
		System.out.println(this.stageName);
		System.out.println("They are from: " + this.nationality);
		System.out.println("Their most popular song is " + this.popularSong);
		System.out.println("That song has " + " " + this.spotifyPlays + " " + "plays on Spotify");
	}

	@Override
	public String toString(){
		return "Femcees [name=" + name + ", stageName=" + stageName + ", nationality=" + nationality + ", popularSong="
				+ popularSong + ", spotifyPlays=" + spotifyPlays + "]";
	}

//	public String toString2(){
//		return "Femcees [nationality=" + nationality + ", popularSong=" + popularSong + ", spotifyPlays=" + spotifyPlays
//				+ "]";
//	}

}
