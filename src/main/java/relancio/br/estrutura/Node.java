package relancio.br.estrutura;

import java.util.Objects;

public class Node {
    private String nome;
    private Integer valorInteiro;
    private Node esquerda;
    private Node direita;

    public Node(String nome) {
        this.nome = nome;
    }

    public Node(Integer valorInteiro, Node esquerda, Node direita) {
        this.valorInteiro = valorInteiro;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Node(String nome, Node esquerda, Node direita) {
        this.nome = nome;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Integer getValorInteiro() {
        return valorInteiro;
    }

    public void setValorInteiro(Integer valorInteiro) {
        this.valorInteiro = valorInteiro;
    }

    public Node getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Node esquerda) {
        this.esquerda = esquerda;
    }

    public Node getDireita() {
        return direita;
    }

    public void setDireita(Node direita) {
        this.direita = direita;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; Node node = (Node) o;
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
