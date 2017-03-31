import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class StableTest {

	public static void main(String[] args) {

		//String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\matching\\data\\sm-bbt-in.txt";
		String filename = args[0];
		
		ArrayList<Man> MenList = new ArrayList<Man>();
		ArrayList<Woman> WomenList = new ArrayList<Woman>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();
			while (line.charAt(0) == '#') {
				line = br.readLine();
			}

			String[] parts = line.split("=");
			int couples = Integer.parseInt(parts[1]);

			ArrayList<Person> allPeople = new ArrayList<Person>();
			for (int i = 1; i <= couples * 2; i++) {

				line = br.readLine();
				parts = line.split(" ");
				int index = Integer.parseInt(parts[0]);
				String name = parts[1];
				if (index % 2 == 0) {
					Woman wom = new Woman(name, index);
					allPeople.add(wom);
				} else {
					Man man = new Man(name, index);
					allPeople.add(man);
				}

			}

			line = br.readLine(); // Tom
			line = br.readLine();
			String[] array = line.split(" |\\: +");

			for (int k = 0; k < couples * 2; k++) {
				ArrayList<Integer> prefList = new ArrayList<Integer>();
				for (int i = 1; i < array.length; i++) {
					prefList.add(Integer.parseInt(array[i]));
				}
				int placer = Integer.parseInt(array[0]) - 1;
				allPeople.get(placer).setPrefList(prefList);
				line = br.readLine();
				if (line != null) {
					array = line.split(" |\\: +");
				}
			}

			br.close();

			for (int j = 0; j < couples * 2; j++) {
				if (j % 2 == 0) {
					MenList.add((Man) allPeople.get(j));
				} else {
					WomenList.add((Woman) allPeople.get(j));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.print("File not found exception");
		}

		catch (IOException e) {
			System.out.print("I/O exception");

		}

		ArrayDeque<Man> Proposers = new ArrayDeque<Man>();
		Proposers.addAll(MenList);
		while (!Proposers.isEmpty()) {
			Man Proposer = Proposers.poll();
			int i = Proposer.getPref();
			while (Proposer.getPartner() == null) {
				i = Proposer.getPref();
				int toPropose = Proposer.getList().get(i);
				Woman Proposed = WomenList.get(toPropose / 2 - 1);
				Proposer.incPref();
				if (Proposed.getPartner() == null) {
					Proposer.setPartner(Proposed);
					Proposed.setPartner(Proposer);
				} else {
					Man oldPartner = (Man) Proposed.getPartner();
					if (Proposed.getList().get(Proposer.getIndex() - 1) < Proposed.getList()
							.get(oldPartner.getIndex() - 1)) {
						Proposed.setPartner(Proposer);
						Proposer.setPartner(Proposed);
						oldPartner.setPartner(null);
						Proposers.add(oldPartner);
					}
				}
			}
		}
		for (int i = 0; i < WomenList.size(); i++) {
			System.out.println(MenList.get(i).getName() + " -- " + MenList.get(i).getPartner().getName());
		}

	}

}
