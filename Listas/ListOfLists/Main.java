/* Na linguagem C++ ou nas linguagens estudadas fazer o seguintes PROGRAMA:

    Gerar N listas de tamanho M com números aleatórios.
    Mostrar seus conteúdos.
    Mostrar os números que aparecem nas N listas.
    Mostrar os números que aparecem somente em uma das listas.
    List listaGenerica = new List();

    for (int i = 0; i < 10; i++) listaGenerica.add( new List() ); 

    listaGenerica[0].add(6); 

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    int n, m;
    
    ArrayList<ArrayList<Integer>> listaGenerica = new ArrayList<ArrayList<Integer>>();

    System.out.println("Insira o nr. de listas a gerar: ");
    n = sc.nextInt();

    System.out.println("Insira o nr. de elementos da(s) lista(s) ");
    m = sc.nextInt();


    for(int i = 0; i < n; i++){
      ArrayList<Integer> lista = new ArrayList<Integer>();
      
      for(int j = 0; j < m; j++){
        lista.add(rand.nextInt(200));
      }
      listaGenerica.add(lista);
    }


    int index = 1;
    for (ArrayList<Integer> lista : listaGenerica) {
      System.out.println("Lista " + index + ": " + lista);
      index += 1;
    }
    sc.close();
  }
}


