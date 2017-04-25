
public class PointPair {

	Point p1;
	Point p2;
	double dist;

	public PointPair(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		dist = Math.sqrt((p1.getXD() - p2.getXD()) * (p1.getXD() - p2.getXD())
				+ (p1.getYD() - p2.getYD()) * (p1.getYD() - p2.getYD()));

	}
	
	public PointPair(Point p1, Point p2, double dist) {
		this.p1 = p1;
		this.p2 = p2;
		this.dist = dist;
	}
	
	public double getDist() {
		return dist;
	}
	
	public void setDist(double dist) {
		this.dist = dist;
	}

}
