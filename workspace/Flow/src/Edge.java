
public class Edge {
	private int sink;
	private int source;
	private int capacity;
	
	// Reverse edge?
	//Edge reverseEdge;
	
	
	public Edge (int sink, int source, int capacity) {
		this.sink = sink;
		this.source = source;
		this.capacity = capacity;
	}
	
	public int getSink() {
		return sink;
	}
	
	public int getSource() {
		return source;
	}
	
	public int getCapacity() {
		return capacity;
	}


}
