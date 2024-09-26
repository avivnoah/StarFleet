package il.ac.tau.cs.sw1.ex7.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public int compareByFirePower(Spaceship s1, Spaceship s2){
		return s1.getFirePower() - s2.getFirePower();
	}
	public int compareByCommissionYear(Spaceship s1, Spaceship s2){
		return s1.getCommissionYear() - s2.getCommissionYear();
	}
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		Collections.sort((List)fleet, new Comparator<Spaceship>(){
			@Override
			public int compare(Spaceship o1, Spaceship o2) {
				if(o1.getFirePower() != o2.getFirePower()){
					//minus to reverse
					return -Integer.compare(o1.getFirePower(), o2.getFirePower());
				}
				if(o1.getCommissionYear() != o2.getCommissionYear()){
					//minus to reverse
					return -Integer.compare(o1.getCommissionYear(), o2.getCommissionYear());
				}
				return o1.getName().compareTo(o2.getName());
			}
		});
        List<String> shipDescriptions = new ArrayList<>();
		for (Spaceship ship: fleet) {
			shipDescriptions.add(ship.toString());
		}
		return shipDescriptions;
    }

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		HashMap<String, Integer> spaceshipMap = new HashMap<>();
		for (Spaceship ship: fleet) {
			if(!spaceshipMap.containsKey(ship.getClass().getSimpleName())){
				spaceshipMap.put(ship.getClass().getSimpleName(), 1);
			}
			else{
				int tempCount = spaceshipMap.get(ship.getClass().getSimpleName());
				spaceshipMap.replace(ship.getClass().getSimpleName(), tempCount + 1);
			}
		}
		return spaceshipMap;
	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalCost = 0;
		for (Spaceship ship: fleet) {
			totalCost += ship.getAnnualMaintenanceCost();
		}
		return totalCost;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> weaponNames = new HashSet<>();
		for (Spaceship ship: fleet) {
			if (ship instanceof AbstractFightingSpaceship){
				for (Weapon weapon: ((AbstractFightingSpaceship) ship).weapons) {
					weaponNames.add(weapon.getName());
				}
			}
		}
		return weaponNames;
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int crewCounter = 0;
		for (Spaceship ship: fleet) {
			crewCounter += ship.getCrewMembers().size();
		}
		return crewCounter;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		float averageAge = 0f;
		int counter = 0;
		for (Spaceship ship: fleet) {
			for (CrewMember member:ship.getCrewMembers()) {
				if(member instanceof Officer){
					averageAge += member.getAge();
					counter ++;
				}
			}
		}
		return averageAge/counter;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> officerMap = new HashMap<>();
		for (Spaceship ship: fleet) {
			Officer maxRankedOfficer = null;
			for (CrewMember member: ship.getCrewMembers()){
				if(member instanceof Officer){
					if(maxRankedOfficer == null){
						maxRankedOfficer = (Officer) member;
					}
					else{
						if(maxRankedOfficer.getRank().compareTo(((Officer) member).getRank()) < 0){
							maxRankedOfficer = (Officer) member;
						}
					}
				}
			}
			if(maxRankedOfficer != null){
				//Assuming one officer can't inhabit two separate ships simultaneously.
				officerMap.put(maxRankedOfficer, ship);
			}
		}
		return officerMap;
    }

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> rankCountMap = new HashMap<>();
		List<Map.Entry<OfficerRank, Integer>> officerRanksSorted;
		for(Spaceship ship: fleet){
			for(CrewMember member: ship.getCrewMembers()){
				if(member instanceof Officer){
					if (!rankCountMap.containsKey(((Officer)member).getRank())){
						rankCountMap.put(((Officer)member).getRank(), 1);
					}
					else{
						int tempRankCounter = rankCountMap.get(((Officer)member).getRank());
						rankCountMap.replace(((Officer)member).getRank(), tempRankCounter + 1);
					}
				}
			}
		}
		officerRanksSorted = new ArrayList<>(rankCountMap.entrySet());
		Collections.sort((List) officerRanksSorted, new Comparator<Map.Entry<OfficerRank, Integer>>() {
			@Override
			public int compare(Map.Entry<OfficerRank, Integer> o1, Map.Entry<OfficerRank, Integer> o2) {
				if(o1.getValue().compareTo(o2.getValue()) != 0){
					return o1.getValue().compareTo(o2.getValue());
				}
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		return officerRanksSorted;
	}

}
