//observação: considerou grafo não direcionado
package grafos;

/**
 *
 * @author Fabiana Barreto Pereira
 */
public class Grafos {

    public static void main(String[] args) {

        MatrizAdjacencia ma = new MatrizAdjacencia("grafo.dat");
        ListaAdjacencia da = new ListaAdjacencia("grafo.dat");
        MatrizIncidencia mi = new MatrizIncidencia("grafo.dat");

        ma.preencherMatrizAd();
        da.preencherListaAdj();
        mi.preencherMatrizIncidencia();

        //imprimir matriz de adjacencia
        System.out.println("Matriz de adjacência");

        for (int[] p : ma.getMatriz()) {
            for (int u : p) {
                System.out.printf("%d  ", u);
            }
            System.out.println();
        }
        System.out.println();

        //imprimir matriz de incidencia
        System.out.println("Matriz de incidência");

        for (String[] w : mi.getMatriz()) {
            for (String y : w) {
                System.out.printf("%s     ", y);
            }
            System.out.println();
        }

        System.out.println();

        //imprimir lista de adjacencia
        System.out.println("Lista de adjacência");

        System.out.println(da);
    }

}
