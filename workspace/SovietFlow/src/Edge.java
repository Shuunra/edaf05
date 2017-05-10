
public class Edge {
	private int sink;
	private int source;
	private int capacity;
	private int realFlow;
	private int forwardFlow;
	//private int reverseFlow;
	
	// Reverse edge?
	Edge reverseEdge;
	
	
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
	
	public int getCFlow() {
		return realFlow;
	}
	
	public int getFFlow() {
		return forwardFlow;
	}
	
	public int getRFlow() {
		return reverseEdge.forwardFlow;
	}
	
	public void setCFlow(int newFlow) {
		realFlow = newFlow;
	}
	
	public void setFFlow(int newFlow) {
		forwardFlow = newFlow;
	}
	
	public void setRFlow(int newFlow) {
		reverseEdge.setCFlow(newFlow);
	}
	
}
