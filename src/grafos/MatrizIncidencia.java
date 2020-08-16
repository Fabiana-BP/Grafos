
//observação: considerou grafo não direcionado

package grafos;

import java.util.ArrayList;

/**
 * A classe <b>MatrizIncidencia</b> é uma classe pública para gerar uma Matriz
 * de Incidência a partir dos dados de um arquivo de texto com os dados do grafo
 *
 * @author Fabiana Barreto Pereira
 * @since abril/2018
 * @version 1.0
 */
public class MatrizIncidencia extends LeituraArquivo {

    private ArrayList<Arestah> arestas;
    private String[][] matriz;

    /**
     * Construtor que recebe o nome do arquivo que contém as informações do
     * grafo
     *
     * @param nomeArquivo String com o nome do arquivo que contém as informações
     * do grafo
     */
    public MatrizIncidencia(String nomeArquivo) {
        arestas = new ArrayList<>();
        super.lerArquivo(nomeArquivo);//ler o arquivo
        matriz = new String[super.getV() + 1][super.getA() + 1]; //matriz de incidência : vertices x arestas , neste caso +1 para cabeçalho da matriz
    }

    /**
     * O método <b>preencherMatrizIncidencia</b> preenche a matriz
     */
    public void preencherMatrizIncidencia() {
        int i = 0, j = 0, k = 1, r = 0;

        // definir arestas
        for (i = 0; i < super.getA(); i++) {
            arestas.add(adicionaAresta(super.matrizValores()[i][0], super.matrizValores()[i][1], "a" + super.matrizValores()[i][0] + super.matrizValores()[i][1]));
        }

        //inicializar
        for (i = 0; i < getMatriz().length; i++) {
            for (j = 0; j < getMatriz()[i].length; j++) {
                if (i == 0 && j == 0) {
                    matriz[i][j] = "";
                } else {
                    if (i == 0) {
                        matriz[i][j] = arestas.get(r).nome;
                    } else if (j == 0) {
                        matriz[i][j] = k + "";
                        k++;
                    } else {
                        matriz[i][j] = 0 + "";
                    }
                    r++;
                }
            }
        }

        //preencher
        for (i = 0; i < super.getA(); i++) {//vai percorrer as linhas da matrizValores, por isso limita ao numero de arestas
            if (arestas.get(i).origem == super.matrizValores()[i][0] || arestas.get(i).destino == super.matrizValores()[i][0]) { //na coluna da matriz é i+1, pois considera primeira coluna para identificação
                matriz[super.matrizValores()[i][0]][i + 1] = "" + super.matrizValores()[i][2];
            }
            if (arestas.get(i).origem == super.matrizValores()[i][1] || arestas.get(i).destino == super.matrizValores()[i][1]) {
                matriz[super.matrizValores()[i][1]][i + 1] = "" + super.matrizValores()[i][2];
            }
        }
    }

//método para adicionar as informaçoes da aresta
    private Arestah adicionaAresta(int origem, int destino, String nome) {
        Arestah a = new Arestah(origem, destino, nome);
        return a;
    }

    //classe Aresta com vertice de origem e destino e nome da aresta
    private class Arestah {

        private int origem;
        private int destino;
        private String nome;//aresta

        //método toString da classe aresta
        public String toString() {
            return nome;
        }

        //construtor
        private Arestah(int origem, int destino, String nome) {
            this.origem = origem;
            this.destino = destino;
            this.nome = nome;
        }
    }

    /**
     * O método <b>getMatriz</b> retorna a matriz de incidência
     * @return a matriz de incidência
     */
    public String[][] getMatriz() {
        return matriz;
    }

}
