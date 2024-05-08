package AvaliacaoSemestral2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/* imports da gravação pro arquivo csv */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ListaAtleta {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<Atleta> listaAtletas = new ArrayList<>();

        int opt;

        String arquivo = "atletas.csv";

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
                    Collections.sort(listaAtletas, (a1, a2) -> Integer.compare(a2.getPontuacaoAcumulada(), a1.getPontuacaoAcumulada()));

                    for (Atleta atleta : listaAtletas) {
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

                    if(listaAtletas.contains(new Atleta(fone, nome.toUpperCase(), apelido, dataNascimento, pontAcumulada))){
                        System.out.println("Atleta já cadastrado(a)!");
                    } else {
                        listaAtletas.add(new Atleta(fone, nome.toUpperCase(), apelido, dataNascimento, pontAcumulada));
                        System.out.println("Atleta cadastrado(a) com sucesso.");

                                            /* Gravação no 'atletas.csv' */
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
                            // Escreve o cabeçalho do CSV
                            writer.write("Nome;Apelido;Fone;Data_de_Nascimento;Pontuacao;");
                            writer.newLine();
                
                            // Escreve os dados dos atletas
                            for (Atleta atleta : listaAtletas) {
                                writer.write(atleta.getNome() + ";" + atleta.getApelido() + ";" + atleta.getFone() + ";" + atleta.getDataNascimento() + ";" + atleta.getPontuacaoAcumulada() + ";");
                                writer.newLine();
                            }
                
                            System.out.println("Dados escritos com sucesso no arquivo CSV.");
                
                        } catch (IOException e) {
                            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
                        }
                        /* -------------------------- */
                    }
        
                    System.out.println();
                    break;

                
                /* Procurar atleta (nome/apelido) */
                case 3:
                    System.out.print("> ");
                    String s = teclado.nextLine();

                    boolean flag = false;
                    for (Atleta atleta : listaAtletas) {
                        
                        if(s.equals(atleta.getNome()) || s.equals(atleta.getApelido())){
                            System.out.println("Atleta encontrado(a)!");
                            System.out.println(atleta.toString());
                            flag = true;
                        } 
                    } 
                    
                    if(!flag) System.out.println("Atleta nao encontrado(a)");


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
