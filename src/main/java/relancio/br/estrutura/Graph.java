package relancio.br.estrutura;

import java.util.*;

public class Graph {
    private HashMap<Node, LinkedList<Node>> mapaAdjacente;


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


    @Override
    public String toString() {
        return mapaAdjacente + "\n";
    }
}
