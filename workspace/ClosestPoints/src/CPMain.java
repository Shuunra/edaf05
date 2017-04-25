import java.util.ArrayList;

public class CPMain {

	public static void main(String[] args) {
		// Layout:
		//
		// Parsing:
		// br.readNextLine() until last char can be parseInt
		// delimiters: whitespace, e
		// check size of row split
		// if contains '.' => parseDouble
		// else if size = +1 => parseScientific
		// else parseInt, might be unneeded though
		//
		// parseX:
		// Create Point object with specified parse method
		// Store in list P
		//
		//
		//

		// Don't forget to print the distance
	}

	// Algorithm:

	// Input list P
	ArrayList<Point> P = new ArrayList<Point>(); // Should be created in parsing
													// stage
	// Create P_x and P_y with Mergesort

	public ArrayList<Point> MergeSortX(ArrayList<Point> P) {
		return null;
	}

	public ArrayList<Point> MergeSortY(ArrayList<Point> P) {
		return null;
	}

	ArrayList<Point> Px = MergeSortX(P);
	ArrayList<Point> Py = MergeSortY(P);

	// public ArrayList<Point> CPRecursive(ArrayList<Point> Px, ArrayList<Point>
	// Py) {
	public PointPair CPRecursive(ArrayList<Point> Px, ArrayList<Point> Py) {
		PointPair minPair = null;

		// Call recursive part P_x,y
		// Base case if P.size()<4
		// In that case, brute force
		if (Px.size() < 4) {
			double minDist = Double.MAX_VALUE;
			for (int i = 0; i < Px.size() - 1; i++) {
				for (int j = i + 1; j < Px.size(); j++) {
					Point p1 = Px.get(i);
					Point p2 = Px.get(j);
					double dist = p1.getDist(p2);
					if (dist < minDist) {
						minDist = dist;
						minPair = new PointPair(p1, p2, dist);
					}
				}
			}
		}

		// Split P_x,y into Q_x,y and R_x,y
		ArrayList<Point> Qx = new ArrayList<Point>();
		ArrayList<Point> Qy = new ArrayList<Point>();
		ArrayList<Point> Rx = new ArrayList<Point>();
		ArrayList<Point> Ry = new ArrayList<Point>();

		for (int i = 0; i < Px.size(); i++) {
			if (i <= Px.size() / 2) {
				Qx.add(Px.get(i));
			} else {
				Rx.add(Px.get(i));
			}
		}

		for (int i = 0; i < Py.size(); i++) {
			if (i <= Py.size() / 2) {
				Qy.add(Py.get(i));
			} else {
				Ry.add(Py.get(i));
			}
		}

		// Make recursive call on Q_x,y and R_x,y
		PointPair QPair = CPRecursive(Qx, Qy);
		PointPair RPair = CPRecursive(Rx, Ry);
		double dQ = QPair.getDist();
		double dR = RPair.getDist();

		//
		// delta = min(d(q,q'),d(r,r'));
		double delta;
		// PointPair deltaPair;
		if (dQ < dR) {
			delta = dQ;
			// deltaPair = QPair;
		} else {
			delta = dR;
			// deltaPair = RPair;
		}

		// x* = max x coord of Q (last element);
		// L = (x,y), x = x*;
		// Point L = Qx.get(Qx.size() - 1);
		// double Lx = L.getXD();

		// S = Points in P within distance delta of L;
		ArrayList<Point> S = new ArrayList<Point>();

		// ArrayList<Point> Sx = MergeSortX(S);

		// Construct S_y (go through whole P, check for points within delta
		// distance in x coords)
		for (int i = 0; i < Px.size(); i++) {
			if (Math.abs(Px.get(i).getXD()) <= delta) {
				S.add(Px.get(i));
			}
		}
		ArrayList<Point> Sy = MergeSortY(S);
		// for each (S_y)
		// Compute distance from point i to i+15
		// (s,s') is minimum dist pair
		for (int i = 0; i < Sy.size(); i++) {
			for (int j = i + 1; j < i + 16; j++) {
				Point s1 = Sy.get(i);
				Point s2 = Sy.get(j);
				double dist = s1.getDist(s2);
				PointPair SPair = new PointPair(s1, s2, dist);
				if (dist < minPair.getDist()) {
					minPair = SPair;
				}
			}
		}
		//
		// If d(s,s') < delta
		// return (s,s')
		// Else if d(q,q') < d(r,r')
		// return (q,q')
		// Else
		// return (r,r')
		return minPair;
	}
}
