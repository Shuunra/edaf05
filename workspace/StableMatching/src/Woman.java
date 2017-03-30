import java.util.ArrayList;

public class Woman extends Person {
	
	public Woman(String Name, int index) {
		this.Name = Name;
		this.index = index;
	}
	
	public Woman(String Name, int index, ArrayList<Integer> prefList, Person Partner) {
		this.Name = Name;
		this.index = index;
		this.prefList = prefList;
		this.Partner = Partner;
		this.prefList = inverseList(this.prefList);
	}
	
	public static ArrayList<Integer> inverseList(ArrayList<Integer> prefList) {
		//int[] tempVector = new int[prefList.size()];
		//for(int i=0; i < prefList.size(); i++) {
		//	tempVector[prefList.get(i)] = i;
		//}
		ArrayList<Integer> tempList = new ArrayList<Integer>();		//Snyggare implementering?
		for (int i = 0; i < prefList.size()*2; i++) {
			tempList.add(-1);
		}
		for(int i=0; i < prefList.size(); i++) {
			tempList.set(prefList.get(i)-1, i);
		}
		return tempList;
	}
	
	public void setPrefList(ArrayList<Integer> list) {
		this.prefList = inverseList(list);
	}
	
}