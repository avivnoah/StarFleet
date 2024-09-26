package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends AbstractFightingSpaceship{
	private int numberOfTechnicians;
	private final int ANNUALMAINTENANCECOST = 5000;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}
	@Override
	public int getAnnualMaintenanceCost(){
		int cost = ANNUALMAINTENANCECOST;
		int weaponCost = super.getAnnualMaintenanceCost();
		//weaponCost *= (int)((double) this.numberOfTechnicians / 10);
		weaponCost = weaponCost * (100 - 10 * this.numberOfTechnicians) / 100;
		return cost + weaponCost;
	}

	@Override
	public String toString(){
		String tos = super.toString().replaceFirst("AbstractFightingSpaceship", "Bomber") + "\n" +
				"\t" + "numberOfTechnicians=" + numberOfTechnicians;
		return tos;
	}
}
