package AvaliacaoSemestral2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    private String caminho;

    public Arquivo(String caminho) {
        this.caminho = caminho;
    }

    public ArrayList<Atleta> leArquivo() {
        ArrayList<Atleta> atletas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    Atleta atleta = new Atleta(dados[0], dados[1], dados[2], dados[3], Integer.parseInt(dados[4]));
                    atletas.add(atleta);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
        return atletas;
    }

    public void gravaAtleta(Atleta atleta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho, true))) {
            writer.write(atleta.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }

    public void gravaArquivo(ArrayList<Atleta> atletas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            for (Atleta atleta : atletas) {
                writer.write(atleta.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
