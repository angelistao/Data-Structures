import java.util.ArrayList;

// codigo depois da chamada de recursao, crescente
// codigo antes da chamada de recursao, decrescente

public class Recursao {
    public static void exibirRecursao(int i){
        if(i>0){
            System.out.println("empilhando");
            exibirRecursao(i-1);
        }
        System.out.println("desempilhando");
    }


    public static void imprimirRecursao(int i) {
        if(i > 0){
            imprimirRecursao(i-1);
            System.out.println(i);
        }
    }

    public static void exibirVetorRecursao(int[] v, int n) {
      
        if (n > 0){
            exibirVetorRecursao(v, n-1);
            System.out.println(v[n-1]);
        }
        
        
    }


    public static void exibirDecrescenteRecursao(ArrayList<String> l, int n) {
        if(n > 0){
            System.out.println(l.get(n-1));
            exibirDecrescenteRecursao(l, n-1);
            
        }
    }

    public static void exibirNomesGrandesRecursao(ArrayList<String> l, int n) {
        if(n > 0){
            exibirNomesGrandesRecursao(l, n-1);
            if(l.get(n - 1).length() > 5) 
                System.out.println(l.get(n-1));
            
        }
    }

    public static void main(String[] args) {
        
        // int[] vetor = {1, 2, 3, 4};

        // exibirRecursao(3);

        //imprimirRecursao(4);

        // exibirVetorRecursao(vetor, vetor.length);


        ArrayList<String> listaNomes = new ArrayList<String>();

        listaNomes.add("nome1");
        listaNomes.add("nome grandeeeeee");
        listaNomes.add("nome3");
        listaNomes.add("nome gagadsfasdfdsaf");


        // exibirDecrescenteRecursao(listaNomes, listaNomes.size());
        exibirNomesGrandesRecursao(listaNomes, listaNomes.size());
    }
}