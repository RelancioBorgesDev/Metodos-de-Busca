package relancio.br.estrutura;

import java.util.Objects;

public class Node  {
    private String nome;
    private boolean visited;

    public Node(String nome) {
        this.nome = nome;
        this.visited = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return nome.equals(node.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Cidade: " + nome;
    }


}
