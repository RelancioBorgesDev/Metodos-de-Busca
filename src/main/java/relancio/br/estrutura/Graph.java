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

    public LinkedList<Node> BFS(Node inicio, Node fim){
        Queue<Node> queue= new LinkedList<>();
        HashSet<String> visiteds = new HashSet<>();
        queue.add(inicio);
        LinkedList<Node> ll = new LinkedList<>();
        while (!queue.isEmpty()){
            Node atual = queue.remove();
            if(atual.equals(fim)){
                System.out.println("BFS: " + ll.size());
                return ll;
            }else{
                for(Node adjacente: mapaAdjacente.get(atual)){
                    if(!visiteds.contains(adjacente.getNome())){
                        ll.add(adjacente);
                        visiteds.add(adjacente.getNome());
                        queue.add(adjacente);
                    }
                }
                visiteds.add(atual.getNome());
            }
        }

        return ll;
    }

    public LinkedList<Node> DFS(Node inicio, Node fim){
        LinkedList<Node> ll = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        HashSet<String> visiteds = new HashSet<>();
        stack.push(inicio);
        int count = 0;

        while (!stack.isEmpty()){
            Node atual = stack.pop();

            if(atual.equals(fim)){
                System.out.println("DFS: " + ll.size());
                return ll;
            }
            for(Node adjacente: mapaAdjacente.get(atual)){
                if(!visiteds.contains(adjacente.getNome())){
                    ll.add(adjacente);
                    visiteds.add(adjacente.getNome());
                    stack.add(adjacente);
                    count++;
                }
            }
            visiteds.add(atual.getNome());
        }

        return ll;
    }

    @Override
    public String toString() {
        return mapaAdjacente + "\n";
    }
}
