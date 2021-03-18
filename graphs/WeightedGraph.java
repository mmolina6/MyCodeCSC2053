import java.util.ArrayDeque;
import java.util.Queue;

//----------------------------------------------------------------------------
// WeightedGraph.java            by Dale/Joyce/Weems                Chapter 10
//
// Implements a directed graph with weighted edges.
// Vertices are objects of class T and can be marked as having been visited.
// Edge weights are integers.
// Equivalence of vertices is determined by the vertices' equals method.
//
// General precondition: Except for the addVertex and hasVertex methods, 
// any vertex passed as an argument to a method is in this graph.
//----------------------------------------------------------------------------


public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
  public static final int NULL_EDGE = 0;
  private static final int DEFCAP = 50;  // default capacity
  private int numVertices;
  private int maxVertices;
  private T[] vertices;
  private int[][] edges;
  private boolean[] marks;  // marks[i] is mark for vertices[i]
  //boolean array called marks and is the same size as the vertices array
  //when array marks is initialized, it is false because no vertex has been visited
  //will be marked true when bfs is started and vertices are visited 

  public WeightedGraph()
  // Instantiates a graph with capacity DEFCAP vertices.
  {
    numVertices = 0;
    maxVertices = DEFCAP;
    vertices = (T[]) new Object[DEFCAP]; //create the one dimensional array (?)
    marks = new boolean[DEFCAP];
    edges = new int[DEFCAP][DEFCAP];
  }
 
  public WeightedGraph(int maxV)
  // Instantiates a graph with capacity maxV.
  {
    numVertices = 0;
    maxVertices = maxV;
    vertices = (T[]) new Object[maxV];
    marks = new boolean[maxV];
    edges = new int[maxV][maxV];
  }

  public boolean isEmpty()
  // Returns true if this graph is empty; otherwise, returns false.
  {
	  return (numVertices == 0);
  }

  public boolean isFull()
  // Returns true if this graph is full; otherwise, returns false.
  {
	  return (numVertices==maxVertices);
  }

  public void addVertex(T vertex)
  // Preconditions:   This graph is not full.
  //                  vertex is not already in this graph.
  //                  vertex is not null.
  //
  // Adds vertex to this graph.
  {
	  vertices[numVertices] = vertex;
	  for(int i =0;i<numVertices;i++) {
		  edges[numVertices][i] = NULL_EDGE;
		  edges[i][numVertices] = NULL_EDGE;
	  }
	  numVertices++; 
    
  }

  public boolean hasVertex(T vertex)
  // Returns true if this graph contains vertex; otherwise, returns false.
  {
	  for(int i=0;i<numVertices;i++) {
		  if(vertices[i].equals(vertex)) {
			  return true;
		  }
	  }
	 return false; //sequential search, search through vertices array and search for the vertex - check if the vertex exists 
	 //if it does, ret true, if not ret false 
  }
  
  private int indexIs(T vertex)
  // Returns the index of vertex in vertices.
  //need to know where in the a.matrix are we putting the connection 
  //search the vertices array for the vertex we are looking for and return the index place 
	  {
		  for(int i=0;i<numVertices;i++) {
			  if(vertices[i].equals(vertex)) {
				  return i;
			  }
		  }
		  return -1; //indicator that the vertex doesnt exist: the vertex is not in the graph
		  //doesnt have an index place 
  }
  //private helper method 
  //return the index place of a vertex 
  //helpful with addedge method 

  public void addEdge(T fromVertex, T toVertex, int weight)
  // Adds an edge with the specified weight from fromVertex to toVertex.
  //want to add edge between michael and pam
  //micheal -> fromvertex and pam -> tovertex 
  //takes a weight 
  //using index is 
  //row (front vertex), col 
  {
	  int row = indexIs(fromVertex);; 
	  int col = indexIs(toVertex);; 
	  edges[row][col] = weight; 
   
  }

  public int weightIs(T fromVertex, T toVertex)
  // If edge from fromVertex to toVertex exists, returns the weight of edge;
  // otherwise, returns a special �null-edge� value.
  //need to now row of fromvertex and col of tovertex and return the value in that place 
  {
	  int row = indexIs(fromVertex);; 
	  int col = indexIs(toVertex);; 
	  int weight = edges[row][col]; //need to do a check -- check if it exists 
	  								//if not, need exception (if edgeexists [method]) and have an exception
	  
	  return weight; 
   //get weight and return weight 
  }

  public Queue<T> getToVertices(T vertex)
  // Returns a queue of the vertices that vertex is adjacent to.
  {
	  Queue<T> queue = new ArrayDeque<>();
	    int row = indexIs(vertex);
	    for(int col=0;col<numVertices;col++) {
	    	if(edges[row][col] != NULL_EDGE) {
	    		queue.add(vertices[col]);
	    	}
	    }
	    return queue;
  }
  //returns a queue of a given vertex's adjacent vertices 
  //get micheal's index, loop through all the col, is there is a one, add 
  //add vertex to queue and return it 

  public void clearMarks()
  // Unmarks all vertices.
  {
	marks = new boolean[maxVertices]; 
	//create a new boolean with a size of maxVertices 
  }

  public void markVertex(T vertex)
  // Marks vertex.
  {
	//marks = new boolean[maxVertices]; 
	  int index = indexIs(vertex); //gives the index place of the vertex 
	  marks[index] = true; 
	
	//mark the vertex as having been visited 
	 //set it to true once the vertex has been visited 
  }

  public boolean isMarked(T vertex)
  // Returns true if vertex is marked; otherwise, returns false.
  //given a vertex 
  //use index is 
  //get index place of vertex (index is) 
  //return value of marks at that index place
  
  {
	 int index = indexIs(vertex); //gives the index place of the vertex 
	 if (marks[index] == true) { 
		 return true; 
	 }
	 else { 
		 return false; 
	 }
	 
//	 marks[index] gets the value of marks (?) 
	 //trying to find out if the vertex has been visited 
	 //get index place of the vertex 
	 
  }
  
  public T getUnmarked()
  // Returns an unmarked vertex if any exist; otherwise, returns null.
  //not marked false 
  //marked true 
  //return first false value in marks 
  {
	  for (int i = 0; i<maxVertices; i++) {
		  if (marks[i] == false) {
			  return vertices[i]; //return first vertex that has not been visited 
		  }

	  }
	  return null;
  }

  public boolean edgeExists(T vertex1, T vertex2)
  // Preconditions:  vertex1 and vertex2 are in the set of vertices
  //
  // Return value = (vertex1, vertex2) is in the set of edges
  {
    return (edges[indexIs(vertex1)][indexIs(vertex2)] != NULL_EDGE);
  }

  public boolean removeEdge(T vertex1, T vertex2)
  // Preconditions:  vertex1 and vertex2 are in the set of vertices
  //
  // Return value = true if edge was in the graph (and has been removed)
  //              = false if edge was not in the graph
  {
    boolean existed = edgeExists(vertex1, vertex2);
    edges[indexIs(vertex1)][indexIs(vertex2)] = NULL_EDGE;
    return existed;
  }
  
}
