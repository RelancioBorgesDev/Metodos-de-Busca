package relancio.br;

import relancio.br.estrutura.Graph;
import relancio.br.estrutura.Node;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
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

        String pathConexoes = "/media/relanciobg/RELANCIO TR/Unitau/7 sem/Inteligencia Artificial I/conexoes.txt";
        String cidade1;
        String cidade2;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathConexoes))) {
            while ((line = reader.readLine()) != null) {
                String[] cidades = line.split(",");
                cidade1 = cidades[0];
                cidade2 = cidades[1];
                gr.addVertice(new Node(cidade1), new Node(cidade2));

            }
        }catch (IOException fn){
            System.out.println(fn.getMessage());
        }

        System.out.println(gr);
        System.out.println(gr.BFS(new Node("Lugoj"), new Node("Bucuresti")));
        System.out.println(gr.DFS(new Node("Lugoj"), new Node("Bucuresti")) );
        System.out.println(gr.DLS(new Node("Lugoj"), new Node("Bucuresti"),3, new LinkedHashSet<>()));

    }
}
