package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter {
	private final int ANNUALMAINTENANCECOST = 4000;
	private final int ENGINECOST = 500;
	private final int CREWMEMBERCOST = 500;
	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	@Override
	public int getAnnualMaintenanceCost(){
		int cost = ANNUALMAINTENANCECOST;
		int weaponCost = 0;
		for (Weapon weapon: weapons) {
			weaponCost += weapon.getAnnualMaintenanceCost();
		}
		int crewMemberCost = CREWMEMBERCOST * crewMembers.size();
		int engineCost = (int)(ENGINECOST * maximalSpeed);
		return cost + weaponCost + crewMemberCost + engineCost;
	}

	// I know i didn't need to  implement it as it inherits the parent's toString.
	// And I know this toString is not very useful now, but it possibly improves the code's dynamic abilities
	@Override
	public String toString(){
		return super.toString();
	}
}
