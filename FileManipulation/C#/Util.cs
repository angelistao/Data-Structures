using System;
using System.Collections.Generic;
using System.IO;

class Util {
    public static void PopularArquivoNoHash(HashSet<Atomo> tabelaHash, string nomeArquivo){
        try 
        {

            /* Ler todo o arquivo de uma vez */
            if(File.Exists(nomeArquivo)) // O método de classe Exists() é invocado pela classe File
            {
                /* Le o conteudo do arquivo linha por linha e armazena em alguma coleção (lista, hash) */
                string[] linhas = File.ReadAllLines(nomeArquivo);
                string[] dados;

                for(int i = 0; i < linhas.Length; i++)
                {
                    dados = linhas[i].Split(";");
                    Atomo atomo = new Atomo(dados[0], dados[1], dados[2], dados[3]);
                    tabelaHash.Add(atomo);
                }                
            }

        } catch(Exception e) {
            Console.WriteLine(e);
        }
    }

    public static void MostrarHash(HashSet<Atomo> tabelaHash){
        foreach (var atomo in tabelaHash)
        {
            Console.WriteLine(atomo);
        } 
    }

}

