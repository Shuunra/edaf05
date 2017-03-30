import java.util.ArrayList;

public abstract class Person {
	String Name;
	int index;
	ArrayList<Integer> prefList;
	Person Partner = null;
	
	public int getIndex() {
		return index;
	}
	
	public String getName() {
		return Name;
	}
	
	public ArrayList<Integer> getList() {
		return prefList;
	}
	
	public Person getPartner() {
		return Partner;
	}
	
	public void setPartner(Person Partner) {
		this.Partner = Partner;
	}
	
	public void setPrefList(ArrayList<Integer> list) {
		this.prefList = list;
	}
}

