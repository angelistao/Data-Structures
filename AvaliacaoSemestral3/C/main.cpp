#include <iostream>
#include <ctime>
#include <istream>

using namespace std;

#include "Arvore.h"

int main()
{
    srand(time(NULL));
    Arvore *arvore = NULL;
    int opt;
    string apelido;

    do {
        cout << "1 - Cadastrar atleta" << endl;
        cout << "2 - Listar atletas(s)" << endl;
        cout << "3 - Listar por altura decrescente" << endl;
        cout << "4 - Remover atleta" << endl;
        cout << "5 - Pesquisar atleta por apelido" << endl;
        cout << "6 - Sair" << endl;
        cout << "> ";
        cin >> opt;
        system("cls");

        switch(opt){
            case 1: /* Cadastrar atleta */
                {
                    cin.ignore(); // limpando buffer
                    Atleta atl;

                    string nome;
                    string apelido;
                    float altura;
                    string posicao;

                    cout << "Nome: ";
                    getline(cin, nome);

                    cout << "Apelido: ";
                    getline(cin, apelido);

                    cout << "Altura (Cm): ";
                    cin >> altura;
                    cin.ignore(); // Clear buffer
                    
                    cout << "Posicao: ";
                    getline(cin, posicao);

                    atl.nome = nome;
                    atl.apelido = apelido;
                    atl.altura = altura;
                    atl.posicao = posicao;

                    arvore = inserir(atl, arvore);

                    
                }
                cout << "Pressione ENTER para continuar..." << endl;
                
                break;

            case 2: /* Listar atletas */
                cin.ignore(); // limpando buffer
                cout << "------ LISTA DE ATLETAS -------" << endl;
                exibirEDR(arvore);
                cout << endl;
                cout << "Pressione ENTER para continuar..." << endl;
                
                break;

            case 3: /* Listar por altura (decresc.) */
                cin.ignore(); // limpando buffer
                cout << "------ LISTA DE ATLETAS POR ALTURA (DECRES.) -------" << endl;
                exibirPorAltura(arvore);
                cout << endl;

                cout << "Pressione ENTER para continuar..." << endl;
                
                break;

            case 4: /* Remover atleta (nome) */
                {
                    string nome;
                    cout << "Nome do atleta a ser removido: ";
                    cin.ignore();
                    getline(cin, nome);
                    arvore = remove(nome, arvore);
                }

                cout << "Pressione ENTER para continuar..." << endl;
                
                break;

            case 5: /* Pesquisar atleta por apelido */
                {
                cout << "Insira o apelido a ser buscado" << endl;
                cin >> apelido;
                cout << endl;
                estaContidoPorApelido(apelido, arvore);
                }
                cin.ignore();
                cout << "Pressione ENTER para continuar..." << endl;                
                break;

            case 6: /* Sair do programa */
                cout << "Programa encerrado!" << endl;
                break;

            default:
                cout << "Opcao invalida! Tente novamente" << endl;
        }

        cin.ignore();
        system("cls");
    } while(opt != 6);

    free(arvore);

    return 0;
}
