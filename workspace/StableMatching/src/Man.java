import java.util.ArrayList;

public class Man extends Person {
	ArrayList<Person> Proposed = new ArrayList<Person>();

	public Man(String Name, int index) {
		this.Name = Name;
		this.index = index;
	}

	public boolean hasProposed(Person Lover) {
		if (Proposed.contains(Lover)) {
			return true;
		} else {
			return false;
		}
	}

	public void proposedTo(Person Lover) {
		Proposed.add(Lover);
	}

	public void setPrefList(ArrayList<Integer> list) {
		this.prefList = list;
	}
}