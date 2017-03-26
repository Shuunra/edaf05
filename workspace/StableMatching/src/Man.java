import java.util.ArrayList;

public class Man extends Person {
	ArrayList<Person> Proposed = new ArrayList<Person>();
	int weight;
	
	public Man(String Name, int index, ArrayList<Integer> prefList, Person Partner) {
		this.Name = Name;
		this.index = index;
		this.prefList = prefList;
		this.Partner = Partner;
	}
	
	public boolean hasProposed(Person Lover) {
		if(Proposed.contains(Lover)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void proposedTo(Person Lover) {
		Proposed.add(Lover);
	}
	
}