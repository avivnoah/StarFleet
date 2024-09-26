package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class AbstractSpaceship implements Spaceship, Comparable<AbstractSpaceship>{
    protected String name;
    protected Set<? extends CrewMember> crewMembers;
    protected int commissionYear;
    protected float maximalSpeed;
    protected int firePower;
    private final int firePowerConstant = 10;
    public AbstractSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.crewMembers = crewMembers;
        this.commissionYear = commissionYear;
        this.maximalSpeed = maximalSpeed;
        this.firePower = firePowerConstant;
    }
    @Override
    public int getCommissionYear() {
        return this.commissionYear;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getFirePower() {
        return firePowerConstant;
    }
    @Override
    public abstract int getAnnualMaintenanceCost();
    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return this.crewMembers;
    }
    @Override
    public float getMaximalSpeed() {
        return this.maximalSpeed;
    }
    @Override
    public String toString(){
        String tos = "AbstractSpaceship\n" +
                "\t" + "Name=" + name + "\n" +
                "\t" + "CommissionYear=" + commissionYear + "\n" +
                "\t" + "MaximalSpeed=" + maximalSpeed + "\n" +
                "\t" + "FirePower=" + firePower + "\n" +
                "\t" + "CrewMembers=" + crewMembers.size() + "\n" +
                "\t" + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost();
        return tos;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSpaceship that = (AbstractSpaceship) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(AbstractSpaceship o) {
        return name.compareTo(o.name);
    }
}
