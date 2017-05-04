import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TempParser {

	public static void main(String[] args) {
		
		ArrayList<DNA> DNAlist = new ArrayList<DNA>();
		String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\gorilla\\data\\HbB_FASTAs-in.txt";

		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// Kattis
			String line = br.readLine().trim();
			String[] parts = line.split("\\s");
			int inputNbr = Integer.parseInt(parts[0]);
			int queryNbr = Integer.parseInt(parts[1]);
			for (int i = 0; i < inputNbr; i++) {
				String name = br.readLine().trim();
				String DNA = br.readLine().trim();
				DNAlist.add(new DNA(name, DNA));
			}
			for (int i = 0; i < queryNbr; i++) {
				line = br.readLine().trim();
				parts = line.split("\\s");
				// Call method on parts[1] and parts[2], aka. use SequenceAlignment on the string
			}

			// Input file
			String line2 = br.readLine().trim();
			String[] parts2;
			String name2 = "asdf";
			StringBuilder sb = new StringBuilder();
			parts2 = line2.split("\\s");
			name2 = parts2[0].substring(1).trim();
			line2 = br.readLine().trim();
			while (line2 != null) {
				if (line2.charAt(0) == '>') {
					DNAlist.add(new DNA(name2, sb.toString()));		//Add to list with all species
					parts2 = line2.split("\\s");
					name2 = parts2[0].substring(1).trim();
					line2 = br.readLine().trim();
					sb.delete(0, sb.length());
				} else {
					sb.append(line2);
					line2 = br.readLine().trim();
				}
			}
			
			for(int i = 0; i < DNAlist.size() - 1; i++) {
				for(int j = i + 1; j < DNAlist.size(); j++) {
					//SequenceAlignment between i and j, print in format:
					//Species1--Species2: score
					//Species1DNA
					//Species2DNA
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
