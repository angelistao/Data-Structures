using System;
using System.Collections.Generic;

class Program {
    public static void Main(string[] args) {
        // Ler o arquivo e montar o grafo
        List<string> vertices = new List<string>();
        List<string> linhasArquivo = new List<string>();
        string nomeArquivo = "cidades.csv";

        Grafo.LeArquivoMontaGrafo(nomeArquivo, vertices, linhasArquivo);

        Grafo grafo_rs = new Grafo(vertices);

        // Montar as conexões simétricas do arquivo
        grafo_rs.MontarConexoesSimetricas(linhasArquivo);

        // Mostrar o grafo
        Console.WriteLine("Grafo montado:");
        grafo_rs.MostrarGrafo();
    }

}