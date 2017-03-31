import java.util.ArrayList;

public class Man extends Person {
	int toPropose = 0;

	public Man(String Name, int index) {
		this.Name = Name;
		this.index = index;
	}

	public void setPrefList(ArrayList<Integer> list) {
		this.prefList = list;
	}
	
	public int getPref() {
		return toPropose;
	}
	
	public void incPref() {
		toPropose++;
	}
	
}