package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.List;
import java.util.Set;

public abstract class AbstractFightingSpaceship extends AbstractSpaceship{

    protected List<Weapon> weapons;
    public AbstractFightingSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name,commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }
    public List<Weapon> getWeapon(){
        return this.weapons;
    }
    @Override
    public int getFirePower() {
        int totalFirePower = super.getFirePower();
        for (Weapon weapon:this.weapons) {
            totalFirePower += weapon.getFirePower();
        }
        this.firePower = totalFirePower;
        return totalFirePower;
    }
    @Override
    public int getAnnualMaintenanceCost(){
        int weaponCost = 0;
        for (Weapon weapon:this.weapons) {
            weaponCost+= weapon.getAnnualMaintenanceCost();
        }
        return weaponCost;
    }
    @Override
    public String toString(){
        StringBuilder tos = new StringBuilder(super.toString().replaceFirst("AbstractSpaceship", "AbstractFightingSpaceship") + "\n" +
                "\t" + "WeaponArray=[");
        for (Weapon weapon: this.weapons) {
            if(weapon != weapons.getLast()) {
                tos.append(weapon.toString()).append(", ");
            }
            else{
                tos.append(weapon.toString()).append("]");
            }
        }
        return tos.toString();
    }
}
