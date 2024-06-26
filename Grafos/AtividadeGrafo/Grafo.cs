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
            StreamReader arqr = new(nomeArquivo);
         
            string linha;
            

            while((linha = arqr.ReadLine()) != null) {
                string[] campos = linha.Split("@");;

                linha = linha.ToUpper();
                
                linhas.Add(linha);
                

                if(!vertices.Contains(campos[0])){
                    vertices.Add(campos[0].Trim());
                }

                if(!vertices.Contains(campos[1])){
                    vertices.Add(campos[1].Trim());
                }
                
            }

            vertices.Sort();

            arqr.Close();
            
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

    public void Show() {
        for (int i = 0; i < this.qtdVertices; i++) {
            Console.Write(this.vertices[i] + "\t\t\t");
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.MatrizAdjacencia[i, j] != 0) {
                    Console.Write(this.vertices[j] + "\t\t\t");
                }
            }
            Console.WriteLine();
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
        string[] campos;
        string nomeOrigem, nomeDestino;
        int indiceOrigem, indiceDestino;

        foreach (string linha in linhas) {
            campos = linha.Split('@');
            nomeOrigem = campos[0].Trim();
            nomeDestino = campos[1].Trim();

            indiceOrigem = this.vertices.IndexOf(nomeOrigem);
            indiceDestino = this.vertices.IndexOf(nomeDestino);

            if (indiceOrigem != -1 && indiceDestino != -1)
            {
                if (this.MatrizAdjacencia[indiceOrigem, indiceDestino] == 0)
                {
                    this.MatrizAdjacencia[indiceOrigem, indiceDestino] = 1;
                    this.MatrizAdjacencia[indiceDestino, indiceOrigem] = 1;
                    this.qtdArestas += 2;
                }
            }
        }
    
    }

    
}