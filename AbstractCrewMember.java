package il.ac.tau.cs.sw1.ex7.starfleet;

import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractCrewMember implements CrewMember, Comparable<AbstractCrewMember> {
    protected String name;
    protected int age;
    protected int yearsInService;
    public AbstractCrewMember(int age, int yearsInService, String name){
        this.name = name;
        this.age = age;
        this.yearsInService = yearsInService;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public int getYearsInService() {
        return this.yearsInService;
    }

    @Override
    public String toString(){
        String tos = "CrewWoman\n" +
                "\t" + "Name=" + name + "\n" +
                "\t" + "Age=" + age + "\n" +
                "\t" + "YearsInService=" + yearsInService; //ponder whether I need a /n in the end of this line
        return tos;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCrewMember that = (AbstractCrewMember) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(AbstractCrewMember o) {
        return name.compareTo(o.name);
    }
}
