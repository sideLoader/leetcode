package Graph;

import java.util.*;

public class Graph<T> {

    HashMap<T, LinkedList<T>> adjList;
    public Graph() {
        adjList = new HashMap<>();
    }

    public void addEdge(T s, T e) {
        LinkedList<T> nodes = (adjList.containsKey(s)) ? adjList.get(s) : new LinkedList<>();
        nodes.add(e);
        adjList.put(s, nodes);
    }

    public void printAdjList() {
        adjList.forEach((k,v) -> {
            System.out.print("\n" + k + " -> ");
            v.forEach(x -> System.out.print(x + " "));
        });
    }

    public void printBFS(T s) {
        HashSet<T> visted = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(s);
        visted.add(s);

        while(!queue.isEmpty()) {
            T temp = queue.poll();
            System.out.print(temp + " ");

            if(adjList.containsKey(temp))
                adjList.get(temp).stream().filter(x -> !visted.contains(x)).forEach(x -> {
                    queue.add(x);
                    visted.add(x);
                });
        }
    }

    public void printDFS(T s) {
        HashSet<T> visted = new HashSet<>();
        Stack<T> queue = new Stack<>();
        queue.add(s);
        visted.add(s);

        while(!queue.isEmpty()) {
            T temp = queue.pop();
            System.out.print(temp + " ");

            if(adjList.containsKey(temp))
                adjList.get(temp).stream().filter(x -> !visted.contains(x)).forEach(x -> {
                    queue.add(x);
                    visted.add(x);
                });
        }
    }


    public void printPaths(T s, T e) {
        printPaths(s, e, new ArrayList<T>(Arrays.asList(s)), new HashSet<>());
    }

    private void printPaths(T s, T e, List<T> paths, Set<T> isVisited) {
        isVisited.add(s);

        if(s == e) {
            paths.forEach(x -> System.out.print(x + " "));
            System.out.println();
        } else {
            if(adjList.containsKey(s))
                for(T i : adjList.get(s)) {
                    if(!isVisited.contains(i)) {
                        paths.add(i);
                        printPaths(i, e, paths, isVisited);
                        paths.remove(i);
                    }
                }
        }

        isVisited.remove(s);
    }

    private Set<T> getAllVertices() {
        Set<T> vertices = new HashSet<>();
        for(T key : adjList.keySet()) {
            vertices.add(key);
            adjList.get(key).forEach(vertex -> vertices.add(vertex));
        }
        return vertices;
    }

    public Map<T, Integer> getConnectedComponents() {
        List<T> vertices = new LinkedList<>(getAllVertices());
        Map<T, Integer> components = new HashMap<>();

        int counter = 0;
        while(!vertices.isEmpty()) {
            T startingVertex = vertices.remove(0);
            List<T> dfsComponent = connectedComponentDFSHelper(startingVertex);
            for(T vertex : dfsComponent) {
                components.put(vertex, counter);
                vertices.remove(vertex);
            }
            counter++;
        }
        return components;
    }

    private List<T> connectedComponentDFSHelper(T start) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack();
        List<T> result = new LinkedList<>();
        visited.add(start);
        stack.push(start);

        while(!stack.isEmpty()) {
            T temp = stack.pop();
            result.add(temp);
            if(adjList.containsKey(temp))
                adjList.get(temp).stream().filter(vertex -> !visited.contains(vertex))
                        .forEach(vertex -> {
                            visited.add(vertex);
                            stack.push(vertex);
                        });
        }
        return result;
    }

    private static void driver() {
        Graph<Integer> graph = new Graph<Integer>();

        graph.addEdge(0,5);
        graph.addEdge(0,3);
        //graph.addEdge(0,4);
        //graph.addEdge(5,1);
        graph.addEdge(4,2);
        //graph.addEdge(3,6);
        graph.addEdge(6,10);
        graph.addEdge(2,1);

        //graph.printBFS(0);
        //System.out.println();
        //graph.printDFS(0);

        Map<?, Integer> components = graph.getConnectedComponents();
        components.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });

    }

    public static void main(String[] args) { driver(); }
}
