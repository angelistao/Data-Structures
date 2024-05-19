using System.Collections.Generic;

class Celula {
    public int Linha {get; set;}
    public int Coluna {get; set;}
    public int Valor {get; set;}
    
    public Celula(int Linha, int Coluna, int Valor) {
        this.Linha = Linha;
        this.Coluna = Coluna;
        this.Valor = Valor;
    }

    
    public override int GetHashCode() {
        const int prime = 31;
        int result = 1;
        result = prime * result + Linha;
        result = prime * result + Coluna;
        return result;
    }

    
    public override string ToString() {
        return "Celula [Linha=" + Linha + ", Coluna=" + Coluna + ", Valor=" + Valor + "]";
    }

    public static void transformarMatrizEmHash(int[,] matriz, HashSet<Celula> tabelaHash){
        for(int i = 0; i < MatrizEspecial.TAML; i++){
            for(int j = 0; j < MatrizEspecial.TAMC; j++){
                if(matriz[i,j] != 0){
                    tabelaHash.Add(new Celula(i, j, matriz[i,j]));
                }
            }
        }

        int dimensaoLinha = MatrizEspecial.TAML;
        int dimensaoColuna = MatrizEspecial.TAMC;
    }   

    public static void exibirHash(HashSet<Celula> tabelaHash){
        foreach (var celula in tabelaHash)
        {
            Console.WriteLine(celula);
        }
    }


}

public class MatrizEspecial {
    public const int TAML = 10;
    public const int TAMC = 10;

    public static void zerarMatriz(int[,] matriz){
        for(int i = 0; i < TAML; i++){
            for(int j = 0; j < TAMC; j++){
                matriz[i, j] = 0;
            }
        }
    }

    public static void mostrarMatriz(int[,] matriz){
        for(int i = 0; i < TAML; i++){
            for(int j = 0; j < TAMC; j++){
                Console.Write(matriz[i,j] + "\t");
            }
            Console.WriteLine("\n");
        }
    }

    public static void Main(string[] args) {
        int[,] matriz = new int[TAML,TAMC];

        zerarMatriz(matriz);

        matriz[0,0] = 100;
        matriz[5,5] = 100;
        matriz[9,9] = 100;

        HashSet<Celula> tabelaHash = new HashSet<Celula>();

        MatrizEspecial.mostrarMatriz(matriz);
        Celula.transformarMatrizEmHash(matriz, tabelaHash);
        Celula.exibirHash(tabelaHash);

    }
}
