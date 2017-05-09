import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SovietMain {

	public static void main(String[] args) {
		
		String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\flow\\data\\rail.txt";
		ArrayList<String> railStation = new ArrayList<String>();
		ArrayList<String> railroads = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine().trim();
			int n = Integer.parseInt(line);
			for(int i = 0; i < n; i++) {
				line = br.readLine().trim();
				railStation.add(line);
			}
			line = br.readLine().trim();
			int m = Integer.parseInt(line);
			for(int i = 0; i < m; i++) {
				line = br.readLine().trim();
				String[] parts = line.split("\\s+");
				//Manipulate railStations a bit
				railroads.add(parts[parts.length-1]);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String BFS(ArrayList<String> graph, String source, String sink) {
		ArrayList<String> searchRoads = new ArrayList<String>();
		ArrayList<String> finalRoad = new ArrayList<String>();
		searchRoads.add(source);
		String endRoad = "asdf"; //null
		for(int i = 0; i < source.length(); i++) {
			searchRoads.add(source.substring(i, i));
		}
		int a = 1;
		while(a < searchRoads.size()) {
			boolean foundRoad = false;
			String currentStation = searchRoads.get(a);
			for(int i = 0; i < currentStation.length(); i++) {
				int b = 0;
				if(!searchRoads.contains(currentStation.substring(b, b))) {
					searchRoads.add(currentStation.substring(b, b));
					//b.addParent;
					if(b == sink.length()) {
						foundRoad = true;
						b = endRoad.length();
						break;
					}
				}
			}
			a++;
			if(foundRoad == true) {
				break;
			}
		}
		String reachedEnd = null;
		while(!reachedEnd.equals(source)) {
			finalRoad.add("endRoad");
			reachedEnd = "endRoadParent";
		}
		return null;
	}

	
	public ArrayList<String> findMinCut(ArrayList<String> railway) {
		//Create G_f
		//Reach furthermost nodes
		//Add these to ArrayList<String> foundCut
		//return foundCut
		return null;
	}
	
	
}
