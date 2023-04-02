package relancio.br.estrutura.grafo;

import relancio.br.estrutura.Node;

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
                    stack.add(adjacente);
                }
            }

        }

        return null;
    }
    //DLS
    public Set<Node> DLS(Node atual, Node objetivo, int limiteProfundidade){
        Set<Node> visiteds = new LinkedHashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.add(atual);

        while (!stack.isEmpty() && limiteProfundidade >= 0){
            atual = stack.pop();
            visiteds.add(atual);

            if (atual.equals(objetivo)){
                System.out.println("Objetivo encontrado: " + atual.getNome());
                return visiteds;
            }
            LinkedList<Node> adjacentes = mapaAdjacente.get(atual);
            if(adjacentes != null){
                for(Node adjacente : adjacentes){
                    if(!visiteds.contains(adjacente)){
                        stack.add(adjacente);
                    }
                }
            }
            --limiteProfundidade;
        }
        return visiteds;
    }

    @Override
    public String toString() {
        return mapaAdjacente + "\n";
    }

    public boolean isEmpty() {
        return mapaAdjacente.isEmpty();
    }

    public LinkedList<Node> getNodes(Node key) {
        return mapaAdjacente.get(key);
    }

    public HashMap<Node, LinkedList<Node>> mapaAdjacente(){
        return mapaAdjacente;
    }



}
