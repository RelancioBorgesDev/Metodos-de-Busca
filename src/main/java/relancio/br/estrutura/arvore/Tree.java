package relancio.br.estrutura.arvore;

import relancio.br.estrutura.Node;
import relancio.br.estrutura.grafo.Graph;

import java.util.*;

public class Tree {
    private final Node raiz;
    private List<Node> children;

    public Tree() {
        this.raiz = null;
    }
    public Tree(Node raiz) {
        this.raiz = raiz;
        this.children = new ArrayList<>();
    }
    public void addChild(Node child) {
        this.children.add(child);
    }

    public Node getRaiz() {
        return raiz;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "raiz=" + raiz +
                ", children=" + children +
                '}';
    }
}
