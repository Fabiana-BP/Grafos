
//observação: considerou grafo não direcionado

package grafos;

/**
 * A classe <b>MatrizAdjacencia</b> é uma classe pública para gerar uma Matriz
 * de Adjacencia a partir dos dados de um arquivo de texto com os dados do grafo
 *
 * @author Fabiana Barreto Pereira
 * @since abril/2018
 * @version 1.0
 */
public class MatrizAdjacencia extends LeituraArquivo {

    private int[][] matriz;

    /**
     * Construtor que recebe o nome do arquivo que contém as informações do
     * grafo
     *
     * @param nomeArquivo String com o nome do arquivo que contém as informações
     * do grafo
     */
    public MatrizAdjacencia(String nomeArquivo) {
        super.lerArquivo(nomeArquivo); //ler o arquivo
        matriz = new int[super.getV() + 1][super.getV() + 1]; //matriz de adjacência : vertices x vertices , neste caso +1 para cabeçalho da matriz

    }

    /**
     * O método <b>preencherMatrizAd</b> preenche a matriz
     */
    public void preencherMatrizAd() {
        int m = 0, n = 0, r = 0, p = 1, q = 1;

        //colocar os vertices na primeira linha e primeira coluna
        for (int j = 0; j < super.getV() + 1; j++) {
            for (int k = 0; k < super.getV() + 1; k++) {
                if (j == 0 && k == 0) {
                    matriz[j][k] = 0;
                } else {
                    if (j == 0) {
                        matriz[j][k] = p;
                        p++;
                    }
                    if (k == 0) {
                        matriz[j][k] = q;
                        q++;
                    }
                }
            }
        }

        //preencher a matriz
        for (int i = 0; i < super.getA(); i++) { //o limitante é getA pois vai percorrer as linhas da matrizValores
            m = super.matrizValores()[i][0];
            n = super.matrizValores()[i][1];
            r = super.matrizValores()[i][2];

            matriz[m][n] = r;
            matriz[n][m] = r;
        }

    }

    /**
     * O método <b>getMatriz</b> retorna a matriz de incidência
     *
     * @return a matriz de incidência
     */
    public int[][] getMatriz() {
        return matriz;
    }

}
