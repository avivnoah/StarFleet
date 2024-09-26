package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.Set;

public interface Spaceship {
    public int getCommissionYear();
    public String getName();
    public int getFirePower();
    public int getAnnualMaintenanceCost();
    public Set<? extends CrewMember> getCrewMembers();
    public float getMaximalSpeed();
}
