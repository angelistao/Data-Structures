using System;
using System.IO;
using System.Collections.Generic;

class Grafo {
    public int[,] MatrizAdjacencia;
    public List<string> vertices;
    public int qtdVertices;
    public int qtdArestas;

    public Grafo(List<string> vertices) {
        this.vertices = new List<string>(vertices);
        this.qtdVertices = vertices.Count;
        this.qtdArestas = 0;
        this.MatrizAdjacencia = new int[this.qtdVertices, this.qtdVertices];

        for (int i = 0; i < this.qtdVertices; i++) {
            for (int j = 0; j < this.qtdVertices; j++) {
                this.MatrizAdjacencia[i, j] = 0;
            }
        }
    }

    public static void LeArquivoMontaGrafo(string nomeArquivo, List<string> vertices, List<string> linhas){
        try {
            using (StreamReader arqr = new StreamReader(nomeArquivo)) {
                string linha;
                while((linha = arqr.ReadLine()) != null) {
                    // Verifica se a linha tem o formato esperado
                    string[] campos = linha.Split('@');
                    if (campos.Length != 2) {
                        Console.WriteLine($"Erro: Formato inválido na linha '{linha}'. Pulando esta linha.");
                        continue; // Pula para a próxima linha
                    }

                    string cidadeOrigem = campos[0].ToUpper();
                    string cidadeDestino = campos[1].ToUpper();

                    // Adiciona as cidades à lista de vértices, se ainda não estiverem presentes
                    if (!vertices.Contains(cidadeOrigem)) {
                        vertices.Add(cidadeOrigem);
                    }
                    if (!vertices.Contains(cidadeDestino)) {
                        vertices.Add(cidadeDestino);
                    }

                    linhas.Add(linha); 
                }

                vertices.Sort(); 
            }
        } catch (IOException e) {
            Console.WriteLine(e.Message);
        }
    }




    public void InserirArestaSimetrica(string origem, string destino) {        
        int indiceOrigem = this.vertices.IndexOf(origem);
        int indiceDestino = this.vertices.IndexOf(destino);

        if (this.MatrizAdjacencia[indiceOrigem, indiceDestino] == 0) {
            this.MatrizAdjacencia[indiceOrigem, indiceDestino] = 1;
            this.qtdArestas++;
        } if (this.MatrizAdjacencia[indiceDestino, indiceOrigem] == 0) {
            this.MatrizAdjacencia[indiceDestino, indiceOrigem] = 1;
            this.qtdArestas++;
        }
    }

    public void MostrarGrafo(){
        for(int i = 0; i < this.qtdVertices; i++){
            Console.Write("(" + this.vertices[i] + ") tem conexao(oes) com" + ": \t\t");
            for(int j = 0; j < this.qtdVertices; j++){
                if(this.MatrizAdjacencia[i, j] != 0){
                    Console.Write(this.vertices[j] + " \t");
                }
            }
            Console.WriteLine("");
        }
    }

    public int MostrarGrau(string cidade) {
        int indice = this.vertices.IndexOf(cidade);
        if (indice == -1) return -27;
        int qtd = 0;
        for (int i = 0; i < this.qtdVertices; i++) {
            if (this.MatrizAdjacencia[indice, i] != 0) {
                qtd++;
            }
            if (this.MatrizAdjacencia[i, indice] != 0) {
                qtd++;
            }
        }
        return qtd;
    }

    public void MontarConexoesSimetricas(List<string> linhas){
        foreach (string linha in linhas) {
            string[] campos = linha.Split('@');
            if (campos.Length != 2) {
                Console.WriteLine($"Erro: Formato inválido na linha '{linha}'. Pulando esta linha.");
                continue; // Pula para a próxima linha
            }

            string nomeOrigem = campos[0].Trim().ToUpper();
            string nomeDestino = campos[1].Trim().ToUpper();

            int indiceOrigem = this.vertices.IndexOf(nomeOrigem);
            int indiceDestino = this.vertices.IndexOf(nomeDestino);

            // Verifica se encontrou os índices válidos para os vértices
            if (indiceOrigem != -1 && indiceDestino != -1) {
                // Adiciona conexão de indiceOrigem para indiceDestino
                if (this.MatrizAdjacencia[indiceOrigem, indiceDestino] == 0) {
                    this.MatrizAdjacencia[indiceOrigem, indiceDestino] = 1;
                    this.qtdArestas++;
                }

                // Adiciona conexão de indiceDestino para indiceOrigem
                if (this.MatrizAdjacencia[indiceDestino, indiceOrigem] == 0) {
                    this.MatrizAdjacencia[indiceDestino, indiceOrigem] = 1;
                    this.qtdArestas++;
                }
            } else {
                Console.WriteLine($"Erro: Vértices não encontrados para a linha '{linha}'. Pulando esta linha.");
            }
        }
    }


}
