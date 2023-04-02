package relancio.br.estrutura;

import java.util.*;

public class Graph {
    private final HashMap<Node, LinkedList<Node>> mapaAdjacente;

    public Graph() {
        mapaAdjacente = new HashMap<>();
    }

    public void addKey(Node cidade){
        if(!mapaAdjacente.containsKey(cidade)){
            mapaAdjacente.put(cidade, new LinkedList<>());
        }
    }
    public void addVertice(Node cidade, Node destino){
        LinkedList<Node> l;
        if(!mapaAdjacente.containsKey(cidade)){
            l = new LinkedList<>();
        }else{
            l = mapaAdjacente.get(cidade);
        }
        l.add(destino);
        mapaAdjacente.put(cidade,l);

    }

    public LinkedList<Node> BFS(Node inicio, Node fim) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();
        LinkedList<Node> path = new LinkedList<>();

        queue.add(inicio);
        visited.add(inicio.getNome());

        while (!queue.isEmpty()) {
            Node atual = queue.remove();
            visited.add(atual.getNome());
            if (atual.equals(fim)) {
                System.out.println("BFS: " + path.size());
                return path;
            } else {
                LinkedList<Node> adjacentes = mapaAdjacente.get(atual);
                for (Node adjacente : adjacentes) {
                    if (!visited.contains(adjacente.getNome())) {
                        path.add(adjacente);
                        visited.add(adjacente.getNome());
                        queue.add(adjacente);
                    }
                }
                visited.add(atual.getNome());
            }
        }

        return path;
    }


    public LinkedList<Node> DFS(Node inicio, Node fim){
        LinkedList<Node> path = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        Set<String> visited = new LinkedHashSet<>();
        stack.push(inicio);
        int count = 0;

        while (!stack.isEmpty()){
            Node atual = stack.pop();
            visited.add(atual.getNome());
            path.add(atual);

            if(atual.equals(fim)){
                System.out.println("DFS: " + path.size());
                return path;
            }

            LinkedList<Node> adjacentes = mapaAdjacente.get(atual);
            for(Node adjacente: adjacentes){
                if(!visited.contains(adjacente.getNome())){
                    visited.add(adjacente.getNome());
                    stack.add(adjacente);
                    count++;
                }
            }
        }

        return null;
    }

    public boolean DLS(Node atual, Node objetivo, int limiteProfundidade, Set<Node> path) {
        //Ponto de parada
        if (atual.equals(objetivo)) {
            System.out.println("Objetivo encontrado: " + atual.getNome());
            return true;
        } else if (limiteProfundidade == 0) {
            System.out.println(path);
            return false;
        } else {
            for (Node adjacente : mapaAdjacente.get(atual)) {
                path.add(adjacente);
                if (DLS(adjacente, objetivo, limiteProfundidade - 1, path)) {
                    System.out.println(atual.getNome() + " -> " + adjacente.getNome());
                    return true;
                }
            }
            return false;
        }
    }


    @Override
    public String toString() {
        return mapaAdjacente + "\n";
    }
}
