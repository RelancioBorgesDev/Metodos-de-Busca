package relancio.br.estrutura;

import java.util.Objects;

public class Node  {
    private String nome;
    private Integer valor;


    public Node(Integer valor) {
        this.valor = valor;

    }
    public Node(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getValor() {
        return valor;
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
