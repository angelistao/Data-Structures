package Hash.Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Hash {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> listaNomes = new ArrayList<>();

        HashSet<String> hashNomes = new HashSet<String>();
        
        
        String nome;


        for(int i = 0; i < 3; i++){
            nome = sc.nextLine();

            if(!hashNomes.add(nome)){
                System.out.println("Nome ja foi cadastrado!!!");
            }

        }

        listaNomes.addAll(hashNomes);
        

        StringBuilder resultado = new StringBuilder();

        for(String itemString : listaNomes){
            resultado.append(itemString).append(". ").append("Armazenado na posicao ").append(resultado.hashCode()).append("\n");
        }


  

        sc.close();
    }
}
