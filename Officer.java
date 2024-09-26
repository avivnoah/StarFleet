package il.ac.tau.cs.sw1.ex7.starfleet;

public class Officer extends CrewWoman {

	private OfficerRank rank;
		
	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age, yearsInService, name);
		this.rank = rank;
	}
	public OfficerRank getRank(){
		return this.rank;
	}
	@Override
	public String toString(){
		String tos = super.toString().replaceFirst("CrewMember", "Officer")  + "\n" +
				"\t" + "Rank=" + rank;
		return tos;
	}
	
}
