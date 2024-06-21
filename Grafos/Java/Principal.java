package Java;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        
        // ler o arquivo e montar o grafo
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<String> linhasArquivo = new ArrayList<>();
        String nomeArquivo = "C:\\Users\\laboratorio\\Desktop\\Grafos\\mapaCentral";

        Grafo.lerArquivo_montarGrafo(nomeArquivo, vertices, linhasArquivo);

        Grafo g = new Grafo(vertices);


        // ler o arquivo e montar as conexoes do arquivo SIMETRICO
        g.montarConexoesSimetricas(linhasArquivo);

        
    
        // g.mostrarGrafo();
        // g.mostrarMatriz();

        
        System.out.println("Tem caminho entre agudo e Julio de Castilhos? " + g.temCaminhoProfundidade("AGUDO", "JULIO DE CASTILHOS"));
    }
}
