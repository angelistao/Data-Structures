import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Grafo {
    ArrayList<String> vertices;
    int matriz[][];
    int qtdVertices;
    int qtdArestas;

    public Grafo(ArrayList<String> vertices){
        this.vertices = new ArrayList<>();
        this.vertices.addAll(vertices);
        this.qtdVertices = vertices.size();
        this.matriz = new int[qtdVertices][qtdVertices];
        this.qtdArestas = 0;

        for(int i = 0; i < this.qtdVertices; i++){
            for(int j = 0; j < this.qtdVertices; j++){
                this.matriz[i][j] = 0;
            }
        }
    }

    public void montarConexoesSimetricas(ArrayList<String> linhas){
        String[] campos;
        String nomeOrigem, nomeDestino;
        int indiceOrigem, indiceDestino;
        int custo;
        for (String linha : linhas) {
            campos = linha.split("@");
            nomeOrigem = campos[0];
            nomeDestino = campos[1];
            custo = Integer.parseInt(campos[2]);

            indiceOrigem = this.vertices.indexOf(nomeOrigem);
            indiceDestino = this.vertices.indexOf(nomeDestino);

            if ((this.matriz[indiceOrigem][indiceDestino] == 0) && (this.matriz[indiceDestino][indiceOrigem] == 0)){
                this.matriz[indiceOrigem][indiceDestino] = custo;
                this.matriz[indiceDestino][indiceOrigem] = custo;
                this.qtdArestas += 2;
            }

         
        
        }
    }

    public static void lerArquivo_montarGrafo(String nomeArquivo, ArrayList<String> vertices, ArrayList<String> linhas){

        try {
            FileReader arqr = new FileReader(nomeArquivo + ".txt");
            BufferedReader leitor = new BufferedReader(arqr);
            String linha;
            String[] campos;

            while((linha = leitor.readLine()) != null){
                linha = linha.toUpperCase();
                campos = linha.split("@");
                linhas.add(linha);
                

                if(!vertices.contains(campos[0])){
                    vertices.add(campos[0]);
                }

                if(!vertices.contains(campos[1])){
                    vertices.add(campos[1]);
                }
                
            }

            vertices.sort(null);

            leitor.close();
            arqr.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarMatriz(){
        for(int i = 0; i < this.qtdVertices; i ++){
            System.out.print("\t" + i + ":");
        }
        
        System.out.println();

        for(int i = 0; i < this.qtdVertices; i++){
            System.out.print(i + ":\t");
            for(int j = 0; j < this.qtdVertices; j++){
                System.out.print(this.matriz[i][j] + "\t");
            }
            System.out.println();
        }

        for(int i = 0; i < this.qtdVertices; i++){
            System.out.println(i + ": " + vertices.get(i));
        }
    }

    public void mostrarGrafo(){
    
        
        for(int i = 0; i < this.qtdVertices; i++){
            System.out.print(this.vertices.get(i) + ":\t");
            for(int j = 0; j < this.qtdVertices; j++){
                if(this.matriz[i][j] != 0){
                    System.out.print(this.vertices.get(j) + "\t");
                }
            }
            System.out.println("");
        }

        
    }

    public boolean temCaminhoProfundidade(String origem, String destino){
        int indiceOrigem = this.vertices.indexOf(origem);
        int indiceDestino = this.vertices.indexOf(destino);

        ArrayList<String> visitados = new ArrayList<>();
        visitados.add(origem);

        return testaCaminhoProfundidade(indiceOrigem, indiceDestino, visitados);
    }

    private boolean testaCaminhoProfundidade(int no, int destino, ArrayList<String> visitados) {
        for(int col = 0; col < this.qtdVertices; col++){
            if(this.matriz[no][col] != 0 & !visitados.contains(this.vertices.get(col))) {
                if(col == destino) return true;
                System.out.println(this.vertices.get(col));
                visitados.add(this.vertices.get(col));
                return testaCaminhoProfundidade(col, destino, visitados);
            }
        }
        return false;
    }
}