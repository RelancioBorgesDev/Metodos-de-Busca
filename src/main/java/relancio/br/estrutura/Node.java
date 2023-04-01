package relancio.br.estrutura;

import java.util.Objects;

public class Node {
    private String nome;

    public Node(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
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
