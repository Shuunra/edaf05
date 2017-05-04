import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TempParser {

	public static void main(String[] args) {

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
			}
			for (int i = 0; i < queryNbr; i++) {
				line = br.readLine().trim();
				parts = line.split("\\s");
				// Call method on parts[1] and parts[2]
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
					DNA obj = new DNA(name2, sb.toString());
					//Add to list with all species
					parts2 = line2.split("\\s");
					name2 = parts2[0].substring(1).trim();
					line2 = br.readLine().trim();
					sb.delete(0, sb.length());
				} else {
					sb.append(line2);
					line2 = br.readLine().trim();
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
