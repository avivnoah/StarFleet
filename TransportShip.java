package il.ac.tau.cs.sw1.ex7.starfleet;

import javax.naming.CannotProceedException;
import java.util.List;
import java.util.Set;

public class TransportShip extends AbstractSpaceship{
	private int cargoCapacity;
	private int passengerCapacity;
	private final int ANNUALMAINTENANCECOST = 3000;
	private final int CARGOCOST = 5;
	private final int PASSENGERCOST = 3;
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}
	public int getCargoCapacity(){
		return this.cargoCapacity;
	}
	public int getPassengerCapacity(){
		return this.passengerCapacity;
	}
	@Override
	public int getAnnualMaintenanceCost(){
		int cost = ANNUALMAINTENANCECOST + CARGOCOST*this.cargoCapacity + PASSENGERCOST*this.passengerCapacity;
		return cost;
	}

	@Override
	public String toString(){
		String tos = super.toString().replaceFirst("AbstractSpaceship", "TransportShip") + "\n" +
				"\t" + "CargoCapacity=" + cargoCapacity + "\n"+
				"\t" + "PassengerCapacity=" + passengerCapacity;
		return tos;
	}
}
