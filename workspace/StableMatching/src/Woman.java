import java.util.ArrayList;

public class Woman extends Person {

	public Woman(String Name, int index) {
		this.Name = Name;
		this.index = index;
	}

	public static ArrayList<Integer> inverseList(ArrayList<Integer> prefList) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i < prefList.size() * 2; i++) {
			tempList.add(-1);
		}
		for (int i = 0; i < prefList.size(); i++) {
			tempList.set(prefList.get(i) - 1, i);
		}
		return tempList;
	}

	public void setPrefList(ArrayList<Integer> list) {
		this.prefList = inverseList(list);
	}

}