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



    private static void driver() {
        Graph<Integer> graph = new Graph<Integer>();

        graph.addEdge(0,5);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(5,1);
        graph.addEdge(4,2);
        graph.addEdge(3,6);
        graph.addEdge(6,10);
        graph.addEdge(2,1);

        //graph.printBFS(0);
        //System.out.println();
        //graph.printDFS(0);

        graph.printPaths(0,1);

    }

    public static void main(String[] args) { driver(); }
}
