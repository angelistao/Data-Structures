using System.Collections.Generic;

public class Principal {
    static void Main(string[] args) {
        HashSet<Atomo> tabelaHash = new HashSet<Atomo>();

        string nomeArquivo = "atomos.csv";

        Util.PopularArquivoNoHash(tabelaHash, nomeArquivo);
        Util.MostrarHash(tabelaHash);
        
    }
}
