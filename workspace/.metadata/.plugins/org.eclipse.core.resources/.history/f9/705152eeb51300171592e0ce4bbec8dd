import java.util.ArrayList;
import java.util.PriorityQueue;

public class StableTest {

	public static ArrayList<Integer> inverseList(ArrayList<Integer> prefList) {
		int[] tempVector = new int[prefList.size()];
		for (int i = 0; i < prefList.size(); i++) {
			tempVector[prefList.get(i)] = i;
		}
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int i = 0; i < tempVector.length; i++) {
			tempList.set(i, tempVector[i]);
		}
		return tempList;
	}

	public static void main(String[] args) {

		ArrayList<Man> MenList = new ArrayList<Man>();
		ArrayList<Woman> WomenList = new ArrayList<Woman>();
		PriorityQueue<Man> Proposers = new PriorityQueue<Man>();
		Proposers.addAll(MenList);
		while (!Proposers.isEmpty()) {
			int i = 0; // Kommer bli fel med indexering, fixa
			Man Proposer = Proposers.poll();
			while (Proposer.getPartner() != null) {
				int toPropose = Proposer.getList().get(i);
				Woman Proposed = WomenList.get(toPropose);
				if (Proposed.getPartner() == null) {
					Proposer.setPartner(Proposed);
					Proposed.setPartner(Proposer);
				} else {
					Man oldPartner = (Man) Proposed.getPartner();
					if (Proposed.getList().get(Proposer.getIndex()) < Proposed.getList().get(oldPartner.getIndex())) {
						Proposed.setPartner(Proposer);
						Proposer.setPartner(Proposed);
						oldPartner.setPartner(null);
						Proposers.add(oldPartner);
					} else {
						i++;
					}
				}
			}
		}

		// Create an ArrayList with all men and one with all women
		// inverseList all the women
		// Put all men in a Queue
		// while(man left in Queue)
		// Take out a man from Queue and let him propose to highest ranked woman
		// in his List
		// If w is free, match them
		// Else if w is engaged to m'
		// If w prefers m over m', match them and place m' in Queue
		// Else if w prefers m' over m, i++ (for next woman)
		// Create and print Matching List

	}

}
