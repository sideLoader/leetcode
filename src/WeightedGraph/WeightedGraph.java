package WeightedGraph;

import java.util.*;

class Edge<T> {
    T start, end;
    int weight;

    public Edge(T start, T end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class WeightedGraph<T> {

    private Map<T, LinkedList<Edge>> adjList;
    public WeightedGraph() {
        adjList = new HashMap<>();
    }

   /* public void printBFS(T start) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        while(!queue.isEmpty()) {
            T temp = queue.poll();
            System.out.print(temp + " ");

            if(adjList.containsKey(start))
                adjList.get(start).stream().filter(vertex -> !visited.contains(vertex.end)).forEach(vertex -> {
                    visited.add(vertex.);
                    queue.add(vertex)
                })
        }

    } */

    public void addEdge(T start, T end, int weight) {
        Edge edge = new Edge(start, end, weight);
        LinkedList<Edge> list = (adjList.containsKey(start)) ? adjList.get(start) : new LinkedList<>();
        adjList.put(start, list);
    }




    public static void main(String[] args) {

    }
}
