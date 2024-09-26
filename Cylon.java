package il.ac.tau.cs.sw1.ex7.starfleet;

public class Cylon extends CrewWoman{
	private int modelNumber;
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		super(age, yearsInService, name);
		this.modelNumber = modelNumber;
	}

	public int getModelNumber(){
		return this.modelNumber;
	}
	@Override
	public String toString(){

		String tos = super.toString().replaceFirst("CrewMember", "Cylon") + "\n" +
				"\t" + "ModelNumber=" + modelNumber;
		return tos;
	}
}
