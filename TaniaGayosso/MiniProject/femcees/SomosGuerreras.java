package mini.project.femcees;

public class SomosGuerreras extends Femcees{

	public SomosGuerreras(){

	}

	public SomosGuerreras(String popularSong, String nationality, int spotifyPlays, String membersOfGroup){
		super(popularSong, nationality, spotifyPlays);
		this.membersOfGroup = membersOfGroup;
	}

	private String membersOfGroup;

	public String getMembersOfGroup(){
		return membersOfGroup;
	}

	public void setMembersOfGroup(String membersOfGroup){
		this.membersOfGroup = membersOfGroup;
	}

	public void showData(){

		System.out.println("The members of Somos Guerreras are: " + this.membersOfGroup);

	}

	@Override
	public String toString(){
		return "SomosGuerreras [membersOfGroup= + membersOfGroup]";
	}

}
