import java.util.ArrayList;

public class Methods {
	
	public static ArrayList<Integer> inverseList(ArrayList<Integer> prefList) {
		int[] tempVector = new int[prefList.size()];
		for(int i=0; i < prefList.size(); i++) {
			tempVector[prefList.get(i)] = i;
		}
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for(int i=0; i < tempVector.length; i++) {
			tempList.set(i, tempVector[i]);
		}
		return tempList;
	}
	
}