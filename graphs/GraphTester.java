import java.util.Queue;

public class GraphTester {
	public static void main(String[] args) { 
		String houston = "Houston"; 
		String denver = "Denver"; 
		String dallas = "Dallas";
		
		WeightedGraph<String> graph = new WeightedGraph<>(); 
		graph.addVertex(houston);
		graph.addVertex(denver);
		graph.addVertex(dallas);
		
		graph.addEdge(denver, dallas, 200);
		graph.addEdge(denver, houston, 300);
		
		Queue<String> q = graph.getToVertices(denver); 
		System.out.println(q);
	}

}
