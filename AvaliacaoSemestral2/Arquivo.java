package AvaliacaoSemestral2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Arquivo {
    private FileWriter arqw;
    private BufferedWriter escritor;
    private FileReader arqr;
    private BufferedReader leitor;
    public String nomeArquivo;
    private ArrayList<Atleta> listaAtletas;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        listaAtletas = new ArrayList<>();
    }

    public void gravaAtleta(Atleta o) {
        // Escrevendo os Atletas em um arquivo de texto
        listaAtletas.clear();
        try {
            arqw = new FileWriter(nomeArquivo, true);
            escritor = new BufferedWriter(arqw);

            escritor.write(o.getFone() + ";" + o.getNome() + ";" + o.getApelido() + ";" + o.getDataNascimento() + ";" + o.getPontuacaoAcumulada());
            escritor.newLine();

            escritor.close();
            arqw.close();

            System.out.println("Atletas escritos no arquivo com exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Atleta> leArquivo(){
        // Lendo os Atletas do arquivo
        listaAtletas.clear();
        try {
            arqr = new FileReader(nomeArquivo);
            leitor = new BufferedReader(arqr);
            String linha;

            while((linha = leitor.readLine()) != null){
                String[] campos = linha.split(";");

                String fone = campos[0];
                String nome = campos[1];
                String apelido = campos[2];
                String dataNascimento = campos[3];
                int pontuacaoAcumulada = Integer.parseInt(campos[4]);
                

                Atleta o = new Atleta(fone, nome, apelido, dataNascimento, pontuacaoAcumulada);

                listaAtletas.add(o);
            }

            leitor.close();
            arqr.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaAtletas;
    }
    
}