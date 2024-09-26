package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends AbstractFightingSpaceship {
	private final int ANNUALMAINTENANCECOST = 2500;
	private final int ENGINECOST = 1000;
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name,commissionYear,maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost(){
		int cost = ANNUALMAINTENANCECOST;
		int weaponCost = super.getAnnualMaintenanceCost();
		return (int) (cost + weaponCost + ENGINECOST*maximalSpeed);

	}

	// I know i didn't need to  implement it as it inherits the parent's toString.
	// And I know this toString is not very useful now, but it possibly improves the code's dynamic abilities
	@Override
	public String toString(){
		return super.toString().replaceFirst("AbstractFightingSpaceship", "Fighter");
	}
}
