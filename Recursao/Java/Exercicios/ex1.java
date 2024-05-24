package Recursao.Java.Exercicios;

public class ex1 {
    public static void mostraNumerosRecursao(int valor_chegada) {
        if(valor_chegada > 0){
            mostraNumerosRecursao(valor_chegada - 1);
            System.out.println(valor_chegada);
        }
    }

    public static void main(String[] args) {
        mostraNumerosRecursao(5);
    }
}
