import java.util.HashSet;

public class Principal {
    public static void main(String[] args) {
        HashSet<Atomo> tabelaHash = new HashSet<Atomo>();

        String nomeArquivo = "./Java/atomos.csv";

        Util.popularArquivoNoHash(tabelaHash, nomeArquivo);
        Util.mostrarHash(tabelaHash);
        
    }
}
