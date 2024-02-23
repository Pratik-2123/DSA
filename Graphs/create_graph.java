package Graphs;
import java.util.*;
public class create_graph {
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge> [] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                bfsUtil(graph,vis);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> [] graph, boolean vis[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {   // visited array me curr ke jagah pe false hy tho usse visit kr rahe hy
                System.out.print(curr+" ");
                vis[curr] = true;   // visited me true kar rahe hy i.e we have visited that particular node
                // add the neibhours to the queue
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                dfsUtil(graph, i, vis);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        System.out.print(curr+" ");
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {  // jo dest. not visited hy usko visit karvayege
                dfsUtil(graph, e.dest, vis);
            }
        }
    } 

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean vis[]) {
        if(src == dest) {
            return true;
        }

        vis[src] = true;

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            //e.dest mtlb neibhour
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //Case 3
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }

            //Case 1
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }

            //Case 2 -> do nothing -> continue
        }
        return false;
    }

    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int col[] = new int[graph.length];
        for(int i=0; i<col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<graph.length; i++) {
            if(col[i] == -1) {    //BFS 
                q.add(i);
                col[i] = 0;
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1) {               // neibhour has no color
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if(col[e.dest] == col[curr]) {     //NOT BIPARTITE 
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(graph, i, vis, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[] , boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) { //Cycle Exist
                return true;
            }
            else if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                    return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void topSort(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while(!s.isEmpty()) {
            System.out.print(s.pop()+" ");
        }
    }

    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void calcIndegree(ArrayList<Edge>[] graph, int indegree[]) {
        for(int i=0; i<graph.length; i++) {
            int v = i;
            for(int j=0; j<graph[v].size(); j++) {
                Edge e = graph[v].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void topSortbfs(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        calcIndegree(graph, indegree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegree[e.dest]--;
                if(indegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void allPath(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if(src == dest) {
            System.out.print(path+dest);
            return;
        }

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPath(graph, e.dest, dest, path+src);
        }
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }
        public static void dijkstras(ArrayList<Edge>[] graph, int src) {
            int dis[] = new int[graph.length];
            for(int i=0; i<graph.length; i++) {
                if(i != src) {
                    dis[i] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(src, 0));
            boolean vis[] = new boolean[graph.length];

            while(!pq.isEmpty()) {
                Pair curr = pq.remove();

                if(!vis[curr.n]) {
                    vis[curr.n] = true;

                    for(int i=0; i<graph[curr.n].size(); i++) {
                        Edge e = graph[curr.n].get(i);

                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;

                        if(dis[u] + wt < dis[v]) {
                            dis[v] = dis[u] + wt;
                            pq.add(new Pair(v, dis[v]));
                        }
                    }
                }
            }

            for(int i=0; i<dis.length; i++) {
                System.out.print(dis[i] + " ");
            }

        }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 0, 30));

    }

    static class Pair1 implements Comparable<Pair1>{
        int v;
        int cost;

        public Pair1(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair1 p2) {
            return this.cost - p2.cost;
        }
    }
    public static void prims(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair1> pq = new PriorityQueue<>();
        pq.add(new Pair1(0, 0));
        int finalCost = 0;

        while(!pq.isEmpty()) {
            Pair1 curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;

                for(int i=0; i<graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair1(e.dest, e.wt));
                }
            } 
        }

        System.out.print("The minimum cost of the MST is : " + finalCost);
    }
    
    public static void BellmanFord(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];

        //Initialization
        for(int i=0; i<graph.length; i++) {
            if(i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        //Algorithm
        int V = graph.length;

        for(int i=0; i<V-1; i++) {
            //for all the Edges
            for(int j=0; j<graph.length; j++) {
                for(int k=0; k<graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        for(int i=0; i<graph.length; i++) {
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String args[]) {
        int V = 6;
        
        ArrayList<Edge>[] graph = new ArrayList[V];
        // //neibhours of 2
        // for(int i=0; i<graph[2].size(); i++) {
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }
        createGraph(graph);
        bfs(graph);
        System.out.println();
        dfs(graph);
        System.out.println();
        // System.out.println(hasPath(graph, 0, 6, new boolean[V]));
        // System.out.println(detectCycle(graph));
        // System.out.println(isBiPartite(graph));
        System.out.println(isCycle(graph));
        topSort(graph);
        System.out.println();
        topSortbfs(graph);
        int src = 5;
        int dest = 1;
        allPath(graph, src, dest, "");
        dijkstras(graph, 0);
        BellmanFord(graph, src);
        prims(graph);    
    }
}
