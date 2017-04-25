
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SpanningMain {

	public static void main(String[] args) {

		HashMap<String, City> cities = new HashMap<String, City>();

		// ArrayList<City> cities = new ArrayList<City>();
		// ArrayList<Edge> edges = new ArrayList<Edge>();

		// String filename =
		// "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\spanning-usa\\data\\USA-highway-miles.txt";
		// String filename =
		// "C:\\Users\\Myky\\Documents\\edaf05_2\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-alpha.txt";
		// String filename =
		// "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\spanning-usa\\data\\tinyEWG-alpha.txt";
		//String filename = "/Users/richardluong/Downloads/edaf05-master 2/in3/USA-highway-miles.in";
		 String filename = "C:\\Users\\Shintai\\Desktop\\edaf05\\algdes-labs-master\\spanning-usa\\data\\USA-highway-miles.txt";

		try {

			BufferedReader br = new BufferedReader(new FileReader(filename));
			String line = br.readLine();

			while (line != null) {
				
				line = line.trim();
				
				if (!line.contains("--")) {
					cities.put(line, new City(line));
				} else {
					String[] parsed = line.split("--|\\[|\\]");
					
					City a = cities.get(parsed[0].trim());
					City b = cities.get(parsed[1].trim());

					int dist = Integer.parseInt(parsed[2].trim());

					Edge e = new Edge(a, b, dist);
					Edge e2 = new Edge(b, a, dist);
					
					a.addEdge(e);
					b.addEdge(e2);
					
				}
				
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.print("File not found exception");
		}

		catch (IOException e) {
			System.out.print("I/O exception");

		}
		
		Prim2(cities.values());
		
	}
	
	public static void Prim2(Collection<City> cities) {
		
		PriorityQueue<City> q = new PriorityQueue<City>();

//		FOR EACH v : d(v) ; Already done at initialization of city object.
		
//		FOR EACH v : insert v with key d(v) into priority queue.		
		for (City c : cities) {
			q.offer(c);
		}

//		s any node in V.
//		d(s)  0.
		City s = q.poll();
		s.dist = 0;
		q.offer(s);
		
//		Total distance of spanning tree		
		int total = 0;

//		WHILE (the priority queue is not empty)
		while(!q.isEmpty()) {
//			u  delete-min from priority queue.
			City u = q.poll();
			total += u.dist;
//			FOR EACH edge (u, v) E incident to u:
			for (Edge edge : u.allEdges) {

//				IF d(v) > c(u, v)
				if (edge.v.dist > edge.dist) {
//					decrease-key of v to c(u, v) in priority queue.
//					d(v) = c(u, v).
					edge.v.dist = edge.dist;
				}
				
			}
			
//			As the objects in the queue is changed, we take all objects out and put them in again.			
			PriorityQueue<City> tempQ = new PriorityQueue<City>();
			while (!q.isEmpty()) {
				tempQ.offer(q.poll());
			}
			q = tempQ;
		}
		
		System.out.println(total);
		
	}
}
