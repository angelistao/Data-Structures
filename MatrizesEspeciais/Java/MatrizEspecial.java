package Java;
import java.util.HashSet;

class Celula {
    public int linha;
    public int coluna;
    public int valor;
    
    public Celula(int linha, int coluna, int valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + linha;
        result = prime * result + coluna;
        return result;
    }

    @Override
    public String toString() {
        return "Celula [linha=" + linha + ", coluna=" + coluna + ", valor=" + valor + "]";
    }

    public static void transformarMatrizEmHash(int matriz[][], HashSet<Celula> tabelaHash){
        for(int i = 0; i < MatrizEspecial.TAML; i++){
            for(int j = 0; j < MatrizEspecial.TAMC; j++){
                if(matriz[i][j] != 0){
                    tabelaHash.add(new Celula(i, j, matriz[i][j]));
                }
            }
        }

        int dimensaoLinha = MatrizEspecial.TAML;
        int dimensaoColuna = MatrizEspecial.TAMC;
    }   

    public static void exibirHash(HashSet<Celula> tabelaHash){
        for (Celula celula : tabelaHash) {
            System.out.println(celula);
        }
    }


}

public class MatrizEspecial {
    final static int TAML = 10;
    final static int TAMC = 10;

    public static void zerarMatriz(int matriz[][]){
        for(int i = 0; i < TAML; i++){
            for(int j = 0; j < TAMC; j++){
                matriz[i][j] = 0;
            }
        }
    }

    public static void mostrarMatriz(int matriz[][]){
        for(int i = 0; i < TAML; i++){
            for(int j = 0; j < TAMC; j++){
                System.out.println(matriz[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int matriz[][] = new int[TAML][TAMC];

        zerarMatriz(matriz);

        matriz[0][0] = 100;
        matriz[5][5] = 100;
        matriz[9][9] = 100;

        HashSet<Celula> tabelaHash = new HashSet<Celula>();

        MatrizEspecial.mostrarMatriz(matriz);
        Celula.transformarMatrizEmHash(matriz, tabelaHash);
        Celula.exibirHash(tabelaHash);

    }
}
