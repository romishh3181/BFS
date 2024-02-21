import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list

    public BFS(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS traversal from a given source vertex
    public void bfs(int source) {
        // Mark all the vertices as not visited
        int status[] = new int[V];
        int d[]=new int[V];
        int pi[]=new int[V];
        Arrays.fill(status,-1);
        Arrays.fill(d,0);
        Arrays.fill(pi,0);

        status[source]=0;
        d[source]=0;
        pi[source]=0;
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current ass4.node as visited and enqueue it
        //visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            source = queue.poll();
            System.out.print(source+"");
           // System.out.print(source + " ");

            // Get all adjacent vertices of the dequeued vertex
            // If an adjacent vertex has not been visited, then mark it
            // visited and enqueue it
            for (Integer neighbor : adjList[source]) {
                if(status[neighbor]==-1){
                    status[neighbor]=0;
                    d[neighbor]=d[source]+1;
                    pi[neighbor]=source;
                    queue.add(neighbor);
                }
            }
            status[source]=1;
        }

        }


    public static void main(String[] args) {
        BFS graph = new BFS(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(2, 0);
        graph.addEdge(3, 0);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);

        System.out.println("Breadth First Traversal (starting from vertex 0):");
        graph.bfs(0);
    }
}
