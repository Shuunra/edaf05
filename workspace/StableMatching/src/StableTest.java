import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

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
		
		//String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\matching\\data\\sm-friends-in.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(""));
	    try {
	        String line = br.readLine();
	        int couples = Integer.parseInt(line);
	        
	        ArrayList<Person> allPeople = new ArrayList<Person>();
	        for (int i = 1; i <= couples*2; i++) {
	        	line = br.readLine();
		        String[] parts = line.split(" ");
		        int nbr = Integer.parseInt(parts[0]);
		        String name = parts[1];
		        if (nbr % 2 == 0) {
		        	Woman wom = new Woman(name, nbr, null, null);
		        	allPeople.add(wom);
		        } else {
		        	Man man = new Man(name, nbr, null, null);
		        	allPeople.add(man);
		        }
		        
	        }
		        
		        line = br.readLine();
		        String[] array = line.split(" +");
		        
		        for(int k = 0; k < couples*2; k++) {
		        	ArrayList<Integer> prefList = new ArrayList<Integer>();
		        	for(int i = 1; i < array.length; i++) {
		        	prefList.add(i);
		        	}	
		        allPeople.get(k).setPrefList(prefList); 
		        }
		        
		        ArrayList<Man> MenList = new ArrayList<Man>();
		        ArrayList<Woman> WomenList = new ArrayList<Woman>();
		        for(int j = 0; j < couples*2; j++) {
		        	if (j % 2 == 0) {
		        		MenList.add(allPeople.get(j));
		        	} else {
		        		WomenList.add(allPeople.get(j));
		        	}
	    } finally {
	        br.close();
	    }
	}
		
//		ArrayList<Integer> RossList = new ArrayList<Integer>();
//		RossList.add(6);
//		RossList.add(4);
//		RossList.add(2);
//		Man Ross = new Man("Ross", 1, RossList, null);
//		
//		ArrayList<Integer> MonicaList = new ArrayList<Integer>();
//		MonicaList.add(3);
//		MonicaList.add(5);
//		MonicaList.add(1);
//		Woman Monica = new Woman("Monica", 1, MonicaList, null);
//		
//		ArrayList<Integer> ChandlerList = new ArrayList<Integer>();
//		ChandlerList.add(2);
//		ChandlerList.add(6);
//		ChandlerList.add(4);
//		Man Chandler = new Man("Chandler", 1, ChandlerList, null);
//		
//		ArrayList<Integer> PhoebeList = new ArrayList<Integer>();
//		PhoebeList.add(5);
//		PhoebeList.add(1);
//		PhoebeList.add(3);
//		Woman Phoebe = new Woman("Phoebe", 1, PhoebeList, null);
//		
//		ArrayList<Integer> JoeyList = new ArrayList<Integer>();
//		JoeyList.add(6);
//		JoeyList.add(4);
//		JoeyList.add(2);
//		Man Joey = new Man("Joey", 1, JoeyList, null);
//		
//		ArrayList<Integer> RachelList = new ArrayList<Integer>();
//		RachelList.add(1);
//		RachelList.add(5);
//		RachelList.add(3);
//		Woman Rachel = new Woman("Rachel", 1, RachelList, null);
//		
//		
		
		//ArrayList<Man> MenList = new ArrayList<Man>();
//		MenList.add(Ross);
//		MenList.add(Chandler);
//		MenList.add(Joey);
		//ArrayList<Woman> WomenList = new ArrayList<Woman>();
//		WomenList.add(Monica);
//		WomenList.add(Phoebe);
//		WomenList.add(Rachel);
		ArrayDeque<Man> Proposers = new ArrayDeque<Man>();
		Proposers.addAll(MenList);
		while (!Proposers.isEmpty()) {
			int i = 0;
			Man Proposer = Proposers.poll();
			while (Proposer.getPartner() == null) {
				int toPropose = Proposer.getList().get(i);
				Woman Proposed = WomenList.get(toPropose/2-1);		//Snyggare implementering?
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
		for(int i = 0; i < WomenList.size()-1; i++) {
			System.out.println(MenList.get(i).getName() + " -- " + MenList.get(i).getPartner().getName());
		}
		
//		System.out.print(MenList.get(WomenList.size()-1).getName() + " -- " + MenList.get(WomenList.size()-1).getPartner().getName());
		


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
