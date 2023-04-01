package relancio.br;

import relancio.br.estrutura.Graph;
import relancio.br.estrutura.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        /*
        * path(1) faculdade
        * path(2) casa
        * */
        //String path = "E://Unitau//7 sem//Inteligencia Artificial I//cidade.txt";
        String path = "/media/relanciobg/RELANCIO TR/Unitau/7 sem/Inteligencia Artificial I/cidade.txt";

        Graph gr = new Graph();
        String name;
       try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((name = reader.readLine()) != null) {
                gr.addKey(new Node(name));
            }
        }catch (IOException fn){
            System.out.println(fn.getMessage());
        }

        gr.addVertice(new Node("Oradea"), new Node("Zerind"));
        gr.addVertice(new Node("Oradea"), new Node("Sibiu"));
        gr.addVertice(new Node("Zerind"), new Node("Oradea"));
        gr.addVertice(new Node("Zerind"), new Node("Arad"));
        gr.addVertice(new Node("Arad"), new Node("Zerind"));
        gr.addVertice(new Node("Arad"), new Node("Sibiu"));
        gr.addVertice(new Node("Arad"), new Node("Timisoara"));
        gr.addVertice(new Node("Sibiu"), new Node("Oradea"));
        gr.addVertice(new Node("Sibiu"), new Node("Arad"));
        gr.addVertice(new Node("Sibiu"), new Node("Fagaras"));
        gr.addVertice(new Node("Sibiu"), new Node("Rimnicu Vilcea"));
        gr.addVertice(new Node("Timisoara"), new Node("Lugoj"));
        gr.addVertice(new Node("Timisoara"), new Node("Arad"));
        gr.addVertice(new Node("Lugoj"), new Node("Mehadia"));
        gr.addVertice(new Node("Lugoj"), new Node("Timisoara"));
        gr.addVertice(new Node("Mehadia"), new Node("Lugoj"));
        gr.addVertice(new Node("Mehadia"), new Node("Dobreta"));
        gr.addVertice(new Node("Dobreta"), new Node("Craiova"));
        gr.addVertice(new Node("Craiova"), new Node("Dobreta"));
        gr.addVertice(new Node("Craiova"), new Node("Rimnicu Vilcea"));
        gr.addVertice(new Node("Craiova"), new Node("Pitesti"));
        gr.addVertice(new Node("Rimnicu Vilcea"), new Node("Craiova"));
        gr.addVertice(new Node("Rimnicu Vilcea"), new Node("Pitesti"));
        gr.addVertice(new Node("Rimnicu Vilcea"), new Node("Sibiu"));
        gr.addVertice(new Node("Fagaras"), new Node("Sibiu"));
        gr.addVertice(new Node("Fagaras"), new Node("Bucuresti"));
        gr.addVertice(new Node("Pitesti"), new Node("Rimnicu Vilcea"));
        gr.addVertice(new Node("Pitesti"), new Node("Craiova"));
        gr.addVertice(new Node("Pitesti"), new Node("Bucuresti"));

        System.out.println(gr);
        System.out.println(gr.BFS(new Node("Lugoj"), new Node("Bucuresti")));


    }
}
