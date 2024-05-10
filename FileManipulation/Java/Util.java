import java.io.BufferedReader;
import java.io.FileReader;

import java.util.HashSet;

public class Util {
    public static void popularArquivoNoHash(HashSet<Atomo> tabelaHash, String nomeArquivo){
        try {
            /* coloca o arquivo na variável filereader e abre o arquivo através do nome do arquivo (nomeArquivo) */ 
            FileReader arquivo = new FileReader(nomeArquivo); 

            /* Através da var. FileReader, tem acesso ao conteúdo de cada linha do arquivo */
            BufferedReader leitor = new BufferedReader(arquivo); //

            String linha; /* recebe o conteúdo da linha como um todo */
            String[] dadosLinha; /* array da linha */

            while ((linha = leitor.readLine()) != null){
                dadosLinha = linha.split(";"); /* cada elemento deste array vai receber o conteúdo separado por ';' */

                /* adiciona cada elemento dos dados da linha nos atributos do atomo */
                Atomo atomo = new Atomo(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]); 
                
                tabelaHash.add(atomo);
            
            }

            arquivo.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void mostrarHash(HashSet<Atomo> tabelaHash){
        for (Atomo atomo : tabelaHash) {
            System.out.println(atomo);
        }
    }
}
