using System;
using System.Collections.Generic;

class Program {
    public static void Main(string[] args){
      
        // ler o arquivo e montar o grafo
        List<string> vertices = new List<string>();
        List<string> linhasArquivo = new List<string>();
        string nomeArquivo = "cidades.csv";

        Grafo.LeArquivoMontaGrafo(nomeArquivo, vertices, linhasArquivo);

        Grafo grafo_rs = new Grafo(vertices);


        // ler o arquivo e montar as conexoes do arquivo SIMETRICO
        grafo_rs.MontarConexoesSimetricas(linhasArquivo);
        grafo_rs.Show();

        string cidade = "Itaara";
        Console.WriteLine("Grau da cidade de " + cidade + ": " + grafo_rs.MostrarGrau(cidade));
    }
}