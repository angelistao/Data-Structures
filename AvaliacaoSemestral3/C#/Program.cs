using System;
using System.Collections.Generic;
using System.Linq;

public class Program
{
    static List<Atleta> listaAtletas = new List<Atleta>();

    public static void Main(string[] args)
    {
        int opcao;

        do
        {
            Console.WriteLine("\nMENU\n");
            Console.WriteLine("1 - Cadastrar");
            Console.WriteLine("2 - Listar");
            Console.WriteLine("3 - Listar por altura decrescente");
            Console.WriteLine("4 - Remover");
            Console.WriteLine("5 - Pesquisar por apelido");
            Console.WriteLine("6 - Sair\n");

            Console.Write("Opção: ");
            if (!int.TryParse(Console.ReadLine(), out opcao))
            {
                Console.WriteLine("Opção inválida. Informe um número de 1 a 6.");
                continue;
            }

            switch (opcao)
            {
                case 1:
                    CadastrarAtleta();
                    break;
                case 2:
                    ListarAtletas();
                    break;
                case 3:
                    ListarPorAlturaDecrescente();
                    break;
                case 4:
                    RemoverAtleta();
                    break;
                case 5:
                    PesquisarPorApelido();
                    break;
                case 6:
                    Console.WriteLine("Programa encerrado.");
                    break;
                default:
                    Console.WriteLine("Opção inválida. Informe um número de 1 a 6.");
                    break;
            }

        } while (opcao != 6);
    }

    private static void CadastrarAtleta()
    {
        Console.WriteLine("\nCADASTRAR ATLETA\n");

        Atleta novoAtleta = new Atleta();

        Console.Write("Nome: ");
        novoAtleta.Nome = Console.ReadLine();

        Console.Write("Apelido: ");
        novoAtleta.Apelido = Console.ReadLine();

        Console.Write("Altura (em metros): ");
        string alturaInput = Console.ReadLine();
        if (!double.TryParse(alturaInput, out double altura))
        {
            Console.WriteLine("Altura inválida. Informe um número válido.");
            return;
        }
        novoAtleta.Altura = altura;

        Console.Write("Posição (Entrada ou Saída): ");
        novoAtleta.Posicao = Console.ReadLine();

        listaAtletas.Add(novoAtleta);
        Console.WriteLine("Atleta cadastrado com sucesso!");
    }

    private static void ListarAtletas()
    {
        Console.WriteLine("\nLISTA DE ATLETAS\n");

        if (listaAtletas.Count == 0)
        {
            Console.WriteLine("Nenhum atleta cadastrado.");
        }
        else
        {
            foreach (var atleta in listaAtletas)
            {
                Console.WriteLine(atleta);
            }
        }
    }

    private static void ListarPorAlturaDecrescente()
    {
        Console.WriteLine("\nLISTA DE ATLETAS POR ALTURA DECRESCENTE\n");

        var listaOrdenada = listaAtletas.OrderByDescending(a => a.Altura);

        foreach (var atleta in listaOrdenada)
        {
            Console.WriteLine(atleta);
        }
    }

    private static void RemoverAtleta()
    {
        Console.WriteLine("\nREMOVER ATLETA\n");

        Console.Write("Informe o apelido do atleta que deseja remover: ");
        string apelido = Console.ReadLine();

        var atletaRemover = listaAtletas.FirstOrDefault(a => a.Apelido.Equals(apelido, StringComparison.OrdinalIgnoreCase));

        if (atletaRemover != null)
        {
            listaAtletas.Remove(atletaRemover);
            Console.WriteLine("Atleta removido com sucesso!");
        }
        else
        {
            Console.WriteLine("Atleta não encontrado.");
        }
    }

    private static void PesquisarPorApelido()
    {
        Console.WriteLine("\nPESQUISAR POR APELIDO\n");

        Console.Write("Informe o apelido do atleta que deseja pesquisar: ");
        string apelido = Console.ReadLine();

        var resultados = listaAtletas.Where(a => a.Apelido.Equals(apelido, StringComparison.OrdinalIgnoreCase)).ToList();

        if (resultados.Count == 0)
        {
            Console.WriteLine("Nenhum atleta encontrado com o apelido informado.");
        }
        else
        {
            foreach (var atleta in resultados)
            {
                Console.WriteLine(atleta);
            }
        }
    }
}
