import java.util.*;

public class BFSTraversal {
    private int BFnode;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;

    BFSTraversal(int v) {
        BFnode = v;
        adj = new LinkedList[BFnode];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<Integer>();
    }

    void insertEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void BFS(int n) {
        boolean nodebf[] = new boolean[BFnode];
        int a;
        nodebf[n] = true;
        que.add(n);
        while (!que.isEmpty()) {
            n = que.poll();
            System.out.print(n + " ");
            Collections.sort(adj[n]);
            for (int i = 0; i < adj[n].size(); i++) {
                a = adj[n].get(i);
                if (!nodebf[a]) {
                    nodebf[a] = true;
                    que.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);
        graph.insertEdge(3, 2);
        graph.insertEdge(2, 1);
        graph.insertEdge(2, 4);
        graph.insertEdge(4, 5);
        graph.insertEdge(4, 0);
        graph.insertEdge(1, 5);
        graph.insertEdge(1, 0);
        graph.insertEdge(0, 5);
        graph.insertEdge(0, 4);
        graph.insertEdge(0, 1);


        System.out.println("Breadth First Traversal for the graph starting from node 3 is: ");
        graph.BFS(3);
    }
}