package relancio.br.estrutura;

import java.util.HashMap;
import java.util.LinkedList;

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




    @Override
    public String toString() {
        return mapaAdjacente + "\n";
    }
}
