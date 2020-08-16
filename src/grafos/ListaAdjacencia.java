//observação: considerou grafo não direcionado
package grafos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A classe <b>ListaAdjacencia</b> é uma classe pública para gerar uma Lista de
 * Adjacencia a partir dos dados de um arquivo de texto com os dados do grafo
 *
 * @author Fabiana Barreto Pereira
 * @since abril/2018
 * @version 1.0
 */
public class ListaAdjacencia extends LeituraArquivo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    /**
     * Construtor que recebe o nome do arquivo que contém as informações do
     * grafo
     *
     * @param nomeArquivo String com o nome do arquivo que contém as informações
     * do grafo
     */
    public ListaAdjacencia(String nomeArquivo) {
        vertices = new ArrayList<>();
        arestas = new ArrayList<>();
        super.lerArquivo(nomeArquivo); //ler o arquivo

    }

    /**
     * O método <b>preencherListaAdj</b> preenche a matriz
     */
    public void preencherListaAdj() {
        int i;

        //adicionar vertices
        for (i = 1; i <= super.getV(); i++) {
            vertices.add(addVertice(i));
        }

        //adicionar arestas 
        i = 0;
        while (i < super.getA()) { //para percorrer as linhas da matrizValores
            for (Vertice o : vertices) { //para percorrer os vértices adicionados
                if (super.matrizValores()[i][0] == o.vert) { //comparação com a origem
                    for (Vertice d : vertices) { //para percorrer os vértices adicionados
                        if (d.vert == super.matrizValores()[i][1]) { //comparação com o destino
                            
                            //aqui considerou ida e volta
                            
                            addAresta(o, d, super.matrizValores()[i][2]);
                            addAresta(d, o, super.matrizValores()[i][2]);
                        }
                    }
                }
            }
            i++;
        }
    }

    //método para adicionar os vértices
    private Vertice addVertice(int vert) {
        Vertice v = new Vertice(vert);
        return v;
    }

    //método para adicionar aresta
    private Aresta addAresta(Vertice origem, Vertice destino, int peso) {
        Aresta e = new Aresta(origem, destino, peso);
        origem.addAdjacentes(e); //a aresta adicionada será adjacente ao vertice de origem dela.
        arestas.add(e);
        return e;
    }

    @Override
    public String toString() {
        String r = "";
        for (Vertice u : vertices) {
            r += u.vert + " -> ";
            for (Aresta e : u.adjacentes) {
                Vertice v = e.destino;
                r += "|" + v.vert + "- peso: " + e.peso + "|" + ", ";
            }
            r += "\n";
        }
        return r;
    }

    //classe Aresta com origem, destino e peso
    private class Aresta {

        private Vertice origem;
        private Vertice destino;
        private int peso;

        //construtor da classe Aresta
        private Aresta(Vertice origem, Vertice destino, int peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }

    }

    //Classe Vertice com o vértice e seus adjacentes
    private class Vertice {

        private int vert;
        private LinkedList<Aresta> adjacentes;

        //construtor da classe vertice
        private Vertice(int vert) {
            this.vert = vert;
            this.adjacentes = new LinkedList<>();
        }

        //método para adicionar arestas adjacentes do vértice
        private void addAdjacentes(Aresta e) {
            adjacentes.addLast(e);
        }

        @Override
        public String toString() {
            return vert + "";
        }

    }

}
