
//observação: considerou grafo não direcionado

package grafos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A classe <b>LeituraArquivo</b> é uma classe pública para ler o arquivo com os
 * dados do grafo
 *
 * @author Fabiana Barreto Pereira
 * @since abril/2018
 * @version 1.0
 */
public class LeituraArquivo {

    private ArrayList<String> arquivo = new ArrayList<>(); //ArrayList com as linhas do arquivo, desconsiderando a primeira linha(número de vértices e de aestas)
    private int v, a;//v=número de vertices    a= número de arestas

    /**
     * O método <b>lerArquivo</b> lê o arquivo especificado no parâmetro e
     * retorna um ArrayList, onde cada índice da lista é uma linha do arquivo
     *
     * @param arq String com o nome do arquivo onde contém os dados do grafo
     * @return ArrayList com as linhas com as informaçoes das arestas do arquivo
     */
    public ArrayList lerArquivo(String arq) {
        try {
            FileReader fr = new FileReader(arq);
            BufferedReader leitor = new BufferedReader(fr);
            String linha = "";

            linha = leitor.readLine();
            String[] cabecalho = linha.split(" "); //informação do número de vértices e do número de arestas

            v = Integer.parseInt(cabecalho[0]);
            a = Integer.parseInt(cabecalho[1]);

            while (linha != null) {
                arquivo.add(linha);
                linha = leitor.readLine();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return arquivo;
    }

    /**
     * O método <b>matrizValores</b> retorna uma matriz de inteiros com as
     * informações do grafo desconsiderando a primeira linha do arquivo (número
     * de vértices e número de aresta)
     *
     * @return matriz de inteiro representando as informações das arestas
     */
    public int[][] matrizValores() {
        int[][] mat = new int[getA()][3]; //a coluna vai ser 3 (vertice origem, vertice destino, peso) e a linha a quantidade de arestas
        String[][] valores = new String[getA()][3];//para transformar o ArrayList em matriz de String primeiro
        int i, k = 0;

        //para transformar o ArrayList em matriz de String primeiro
        for (i = 0; i < arquivo.size(); i++) {
            if (i != 0) {
                valores[k] = arquivo.get(i).split(" ");
                k++;
            }
        }

        //para transformar a matriz de String em matriz de inteiros
        for (i = 0; i < getA(); i++) {
            for (k = 0; k < 3; k++) {
                if (valores[i][k] != null) {
                    mat[i][k] = Integer.parseInt(valores[i][k]);
                }
            }
        }
        return mat;
    }

    /**
     * O método <b>getV</b> retorna o número de vértices
     *
     * @return o numero de vértice
     */
    public int getV() {
        return v;
    }

    /**
     * O método <b>getA</b> retorna o número de arestas
     *
     * @return o número de arestas
     */
    public int getA() {
        return a;
    }

}
