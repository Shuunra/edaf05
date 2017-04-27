
public class Point {

//	int xInt;
//	int yInt;
	double xDouble;
	double yDouble;

	public Point(double x, double y) {
		xDouble = x;
		yDouble = y;
	}

	// public Point(int x, int y) {
	// xInt = x;
	// yInt = y;
	// }

	public double getDist(Point p) {
		return Math.sqrt((xDouble - p.getXD()) * (xDouble - p.getXD()) + (yDouble - p.getYD()) * (yDouble - p.getYD()));
	}

	public double getXD() {
		return xDouble;
	}

	public double getYD() {
		return yDouble;
	}

	// public int getXI() {
	// return xInt;
	// }
	//
	// public int getYI() {
	// return yInt;
	// }

}
