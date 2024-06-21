package AvaliacaoSemestral2;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;


public class ListaAtleta {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opt;

        Arquivo arquivo = new Arquivo("AvaliacaoSemestral2/atletas.csv");
        ArrayList<Atleta> atletas = arquivo.leArquivo(); // Carrega a lista de atletas uma vez

        do {
            System.out.println("1 - Listar atletas (por pontuacao)");
            System.out.println("2 - Cadastrar atleta\n3 - Procurar por atleta (nome ou apelido)\n4 - Remover atleta (nome ou apelido)");
            System.out.println("0 - Sair do programa");
            System.out.print("> ");
            opt = teclado.nextInt();
            teclado.nextLine();
        

            System.out.println();
            System.out.println();

            switch (opt) {
                
                /* Listar atleta(s) */
                case 1: 

                    // ordenando por pontuação com lambda java
                    Collections.sort(atletas, (a1, a2) -> Integer.compare(a2.getPontuacaoAcumulada(), a1.getPontuacaoAcumulada()));

                    for (Atleta atleta : atletas) {
                        System.out.println(atleta.toString());
                    }

                    System.out.println();
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

                    Atleta novoAtleta = new Atleta(fone, nome, apelido, dataNascimento, pontAcumulada);
                    if (atletas.contains(novoAtleta)) {
                        System.out.println("Atleta já cadastrado(a)!");
                    } else {
                        atletas.add(novoAtleta);
                        try { // gravar no arquivo
                            arquivo.gravaAtleta(novoAtleta);
                        } catch (Exception e) {
                            System.err.println(e.getMessage());
                        }
                    }
        
                    System.out.println();
                    break;

                
                /* Procurar atleta (nome/apelido) */
                case 3:
                    System.out.print("> ");
                    String s = teclado.nextLine();

                    boolean flag = false;
                    for (Atleta atleta : atletas) {
                        
                        if(s.equals(atleta.getNome()) || s.equals(atleta.getApelido())){
                            System.out.println("Atleta encontrado(a)!");
                            System.out.println(atleta.toString());
                            flag = true;
                            break;
                        } 
                    } 
                    
                    if(!flag) System.out.println("Atleta nao encontrado(a)");


                    System.out.println();
                    break;

                
                /* Remover atleta */
                case 4:

                    System.out.print("> ");
                    String x = teclado.nextLine();
                    boolean atletaRemovido = false;

                    for (Atleta atleta : atletas) {
                        if (x.equals(atleta.getNome()) || x.equals(atleta.getApelido())) {
                            atletas.remove(atleta);
                            System.out.println("Atleta removido(a) com sucesso.");
                            arquivo.gravaArquivo(atletas);
                            atletaRemovido = true;
                            break;
                        }
                    }

                    if (!atletaRemovido) {
                        System.out.println("Atleta nao encontrado(a).");
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
