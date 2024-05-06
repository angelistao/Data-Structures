package AvaliacaoSemestral2;

import java.util.Scanner;
import java.util.ArrayList;

public class ListaAtleta {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<Atleta> listaAtletas = new ArrayList<>();
        
        int opt;
        do {
            System.out.println("1 - Listar atletas (nome ou por pontuação decrescente)");
            System.out.println("2 - Cadastrar atleta\n3 - Procurar por atleta (nome ou apelido)\n4 - Remover atleta (nome ou apelido)");
            System.out.println("0 - Sair do programa");
            System.out.print("> ");
            opt = teclado.nextInt();
            teclado.nextLine();
        

            System.out.println();
            System.out.println();

            switch (opt) {
                /* Lista atleta(s) */
                case 1: 
                    for (Atleta atleta : listaAtletas) {
                        System.out.println(atleta.toString());
                    }
                    break;
                
                /* Adicionar atleta */
                case 2:
                    String nome, apelido, fone, dataNascimento;
                    int pontAcumulada;

                    System.out.println("Nome: ");
                    nome = teclado.nextLine();
                    System.out.println("Apelido: ");
                    apelido = teclado.nextLine();
                    System.out.println("Fone: ");
                    fone = teclado.nextLine();
                    System.out.println("Data de nascimento: ");
                    dataNascimento = teclado.nextLine();
                    System.out.println("Pontuacao: ");
                    pontAcumulada = teclado.nextInt();
                    teclado.nextLine();

                    

                    if(listaAtletas.contains(new Atleta(fone, nome.toUpperCase(), apelido, dataNascimento, pontAcumulada))){
                        System.out.println("Atleta já cadastrado(a)!");
                    } else {
                        listaAtletas.add(new Atleta(fone, nome.toUpperCase(), apelido, dataNascimento, pontAcumulada));
                        listaAtletas.sort(null);
                        System.out.println("Atleta cadastrado(a) com sucesso.");
                    }

                    System.out.println();
                    break;

                
                /* Procurar atleta (nome/apelido) */
                case 3:
                    System.out.print("> ");
                    String s = teclado.nextLine();

                    for (Atleta atleta : listaAtletas) {
                        
                        if(s.equals(atleta.getNome()) || s.equals(atleta.getApelido())){
                            System.out.println("Atleta encontrado(a)!");
                            System.out.println(atleta.toString());
                        }
                    } 

                    System.out.println();
                    break;

                
                /* Remover atleta */
                case 4:

                    System.out.print("> ");
                    String x = teclado.nextLine(); 
                    
                    for (Atleta atleta : listaAtletas) {
                        
                        if(x.equals(atleta.getNome()) || x.equals(atleta.getApelido())){
                            System.out.println("Atleta encontrado!");
                            listaAtletas.remove(atleta);
                            System.out.println("Atleta removido(a) com sucesso.");
                            break;
                        }
                    } 

    
                    System.out.println();
                    break;

                
                /* Sair do programa */
                case 0:
                    
                    System.out.println();
                    break;            
                default:
                    System.out.println("Opção inválida. Tente novamente");

                    System.out.println();
                    break;
            }

        } while (opt != 0);


        System.out.println("Programa encerrado.");


        teclado.close();
    }
}
