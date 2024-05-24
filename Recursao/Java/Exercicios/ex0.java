package Recursao.Java.Exercicios;

public class ex0 {
    public static void exibirSequenciaRecursao(int qtd_iteracoes) {
        if (qtd_iteracoes >= 0) {
            exibirSequenciaRecursao(qtd_iteracoes - 1);
            System.out.println(qtd_iteracoes);
        }
    }

    public static void exibirSequenciaInvertidaRecursao(int qtd_iteracoes) {
        if (qtd_iteracoes >= 0) {
            System.out.println(qtd_iteracoes);
            exibirSequenciaInvertidaRecursao(qtd_iteracoes - 1);
        }
    }

    public static void exibirIntervaloRecursao(int inicio, int fim) {
        if(inicio <= fim){
            System.out.println(inicio);
            exibirIntervaloRecursao(inicio + 1, fim); // chama-se a funcao somando no inicio, para chegar até o fim
        }
    }




    public static void main(String[] args) {
        /*Todas as funções foram testadas */
    }


}
