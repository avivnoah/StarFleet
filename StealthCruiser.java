package il.ac.tau.cs.sw1.ex7.starfleet;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	public static int stealthCruiserCount;
	private final int ENGINE_COST_PER_CRUISER = 50;

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		stealthCruiserCount ++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, new ArrayList<Weapon>(){{
			add(new Weapon ("Laser Cannons",10,100));
		}});
		//MAKE SURE THE EMPTY INITIALIZATION IS RIGHT!!!
	}
	@Override
	public int getAnnualMaintenanceCost(){
		int fighterCost = super.getAnnualMaintenanceCost();
		int engineCost = StealthCruiser.stealthCruiserCount * ENGINE_COST_PER_CRUISER;
		return fighterCost + engineCost;
	}

	@Override
	public String toString(){
		String tos = super.toString().replaceFirst("Fighter", "StealthCruiser") + "\n" +
				"\t" + "StealthCruiserCount=" + stealthCruiserCount;
		return tos;
	}
}
