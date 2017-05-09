import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class GorillaMain {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();
		HashMap<String, DNA> DNAlist = new HashMap<String, DNA>();
		String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\gorilla\\data\\HbB_FASTAs-in.txt";
		//String filename = "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\gorilla\\data\\Toy_FASTAs-in.txt";
		//String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\gorilla\\data\\Toy_FASTAs-in.txt";

		char[] ALPHABET = "ARNDCQEGHILKMFPSTWYVBZX".toCharArray();
		HashMap<Character, Integer> char2id = new HashMap<Character, Integer>();
		for (int i = 0; i < ALPHABET.length; i++) {
			char2id.put(ALPHABET[i], i);
		}

		int blosum[][] = { { 4, -1, -2, -2, 0, -1, -1, 0, -2, -1, -1, -1, -1, -2, -1, 1, 0, -3, -2, 0, -2, -1, 0 },
				{ -1, 5, 0, -2, -3, 1, 0, -2, 0, -3, -2, 2, -1, -3, -2, -1, -1, -3, -2, -3, -1, 0, -1 },
				{ -2, 0, 6, 1, -3, 0, 0, 0, 1, -3, -3, 0, -2, -3, -2, 1, 0, -4, -2, -3, 3, 0, -1 },
				{ -2, -2, 1, 6, -3, 0, 2, -1, -1, -3, -4, -1, -3, -3, -1, 0, -1, -4, -3, -3, 4, 1, -1 },
				{ 0, -3, -3, -3, 9, -3, -4, -3, -3, -1, -1, -3, -1, -2, -3, -1, -1, -2, -2, -1, -3, -3, -2 },
				{ -1, 1, 0, 0, -3, 5, 2, -2, 0, -3, -2, 1, 0, -3, -1, 0, -1, -2, -1, -2, 0, 3, -1 },
				{ -1, 0, 0, 2, -4, 2, 5, -2, 0, -3, -3, 1, -2, -3, -1, 0, -1, -3, -2, -2, 1, 4, -1 },
				{ 0, -2, 0, -1, -3, -2, -2, 6, -2, -4, -4, -2, -3, -3, -2, 0, -2, -2, -3, -3, -1, -2, -1, },
				{ -2, 0, 1, -1, -3, 0, 0, -2, 8, -3, -3, -1, -2, -1, -2, -1, -2, -2, 2, -3, 0, 0, -1 },
				{ -1, -3, -3, -3, -1, -3, -3, -4, -3, 4, 2, -3, 1, 0, -3, -2, -1, -3, -1, 3, -3, -3, -1 },
				{ -1, -2, -3, -4, -1, -2, -3, -4, -3, 2, 4, -2, 2, 0, -3, -2, -1, -2, -1, 1, -4, -3, -1 },
				{ -1, 2, 0, -1, -3, 1, 1, -2, -1, -3, -2, 5, -1, -3, -1, 0, -1, -3, -2, -2, 0, 1, -1 },
				{ -1, -1, -2, -3, -1, 0, -2, -3, -2, 1, 2, -1, 5, 0, -2, -1, -1, -1, -1, 1, -3, -1, -1 },
				{ -2, -3, -3, -3, -2, -3, -3, -3, -1, 0, 0, -3, 0, 6, -4, -2, -2, 1, 3, -1, -3, -3, -1 },
				{ -1, -2, -2, -1, -3, -1, -1, -2, -2, -3, -3, -1, -2, -4, 7, -1, -1, -4, -3, -2, -2, -1, -2 },
				{ 1, -1, 1, 0, -1, 0, 0, 0, -1, -2, -2, 0, -1, -2, -1, 4, 1, -3, -2, -2, 0, 0, 0 },
				{ 0, -1, 0, -1, -1, -1, -1, -2, -2, -1, -1, -1, -1, -2, -1, 1, 5, -2, -2, 0, -1, -1, 0 },
				{ -3, -3, -4, -4, -2, -2, -3, -2, -2, -3, -2, -3, -1, 1, -4, -3, -2, 11, 2, -3, -4, -3, -2 },
				{ -2, -2, -2, -3, -2, -1, -2, -3, 2, -1, -1, -2, -1, 3, -3, -2, -2, 2, 7, -1, -3, -2, -1 },
				{ 0, -3, -3, -3, -1, -2, -2, -3, -3, 3, 1, -2, 1, -1, -2, -2, 0, -3, -1, 4, -3, -2, -1 },
				{ -2, -1, 3, 4, -3, 0, 1, -1, 0, -3, -4, 0, -3, -3, -2, 0, -1, -4, -3, -3, 4, 1, -1 },
				{ -1, 0, 0, 1, -3, 3, 4, -2, 0, -3, -3, 1, -1, -3, -1, 0, -1, -3, -2, -2, 1, 4, -1 },
				{ 0, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, 0, 0, -2, -1, -1, -1, -1, -1 } };

		try {
			 // Kattis
			 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 String line = br.readLine().trim();
			 String[] parts = line.split("\\s");
			 int inputNbr = Integer.parseInt(parts[0]);
			 int queryNbr = Integer.parseInt(parts[1]);
			 for (int i = 0; i < inputNbr; i++) {
			 String name = br.readLine().trim();
			 String DNA = br.readLine().trim();
			 DNAlist.put(name, new DNA(name, DNA));
			 names.add(name);
			 }
			 for (int i = 0; i < queryNbr; i++) {
			 line = br.readLine().trim();
			 parts = line.split("\\s");
			 SequenceAlignment(DNAlist.get(parts[0]), DNAlist.get(parts[1]), blosum, char2id);
			 }

			// Input file
//			BufferedReader br = new BufferedReader(new FileReader(filename));
//			String line2 = br.readLine().trim();
//			String[] parts2;
//			String name2 = "";
//			StringBuilder sb = new StringBuilder();
//			parts2 = line2.split("\\s");
//			name2 = parts2[0].substring(1).trim();
//			line2 = br.readLine().trim();
//			while (line2 != null) {
//				line2.trim();
//				if (line2.charAt(0) == '>') {
//					DNAlist.put(name2, new DNA(name2, sb.toString()));
//					names.add(name2);
//					parts2 = line2.split("\\s");
//					name2 = parts2[0].substring(1).trim();
//					line2 = br.readLine().trim();
//					sb.delete(0, sb.length());
//				} else {
//					sb.append(line2);
//					line2 = br.readLine();
//					if(line2 == null) {
//						DNAlist.put(name2, new DNA(name2, sb.toString()));
//						names.add(name2);
//					}
//				}
//			}
//
//			for (int i = 0; i < names.size() - 1; i++) {
//				for (int j = i + 1; j < names.size(); j++) {
//					SequenceAlignment(DNAlist.get(names.get(i)), DNAlist.get(names.get(j)), blosum, char2id);
//				}
//			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void SequenceAlignment(DNA dna_1, DNA dna_2, int[][] blosum, HashMap<Character, Integer> char2id) {
		int delta = -4;
		int m = dna_1.getDNA().length();
		int n = dna_2.getDNA().length();
		int M[][] = new int[m + 1][n + 1];
		int alpha[][] = blosum;

		for (int i = 0; i <= m; i++) {
			M[i][0] = i * delta;
		}

		for (int j = 0; j <= n; j++) {
			M[0][j] = j * delta;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char currRowLetter = dna_1.getDNA().charAt(i - 1);
				char currColLetter = dna_2.getDNA().charAt(j - 1);
				int rowInd = char2id.get(currRowLetter);
				int colInd = char2id.get(currColLetter);
				M[i][j] = maxVal(alpha[rowInd][colInd] + M[i - 1][j - 1], delta + M[i - 1][j], delta + M[i][j - 1]);
			}
		}

		String Sequence1 = "";
		String Sequence2 = "";
		int i = dna_1.getDNA().length();
		int j = dna_2.getDNA().length();

		while (i > 0 && j > 0) { //Unsure
			int score = M[i][j];
			int moveLeft = M[i][j - 1] + delta;
			int moveUp = M[i - 1][j] + delta;
			char currRowLetter = dna_1.getDNA().charAt(i - 1);
			char currColLetter = dna_2.getDNA().charAt(j - 1);
			int rowInd = char2id.get(currRowLetter);
			int colInd = char2id.get(currColLetter);
			int moveDiag = M[i - 1][j - 1] + alpha[rowInd][colInd]; // Go backwards
			//int highestScore = maxVal(moveLeft, moveUp, moveDiag);
			if (score == moveDiag) {
				Sequence1 = dna_1.getDNA().charAt(i - 1) + Sequence1;
				Sequence2 = dna_2.getDNA().charAt(j - 1) + Sequence2;
				i--;
				j--;

			} else if (score == moveUp) {
				Sequence1 = dna_1.getDNA().charAt(i - 1) + Sequence1;
				Sequence2 = "-" + Sequence2;
				i--;

			} else if (score == moveLeft) {
				Sequence1 = "-" + Sequence1;
				Sequence2 = dna_2.getDNA().charAt(j - 1) + Sequence2;
				j--;
			}
		}
		
		if (i == 0) {
			while (0 < j) {
				Sequence1 = "-" + Sequence1;
				Sequence2 = dna_2.getDNA().charAt(j - 1) + Sequence2;
				j--;
			} 
		} else if (j == 0) {
			while (0 < i) {
				Sequence1 = dna_1.getDNA().charAt(i - 1) + Sequence1;
				Sequence2 = "-" + Sequence2;
				i--;
			}
		}
		
		//System.out.println(dna_1.getName().toString() + "--" + dna_2.getName().toString() + ": " + M[m][n]);	//Comment this row when trying for Kattis
		System.out.println(Sequence1.toString());
		System.out.println(Sequence2.toString());
	}

	private static int maxVal(int a, int b, int c) {
		int high = Math.max(a, b);
		int highest = Math.max(high, c);
		return highest;
	}

}