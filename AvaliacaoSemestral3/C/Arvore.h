#include <iostream>
#include <string>
#include "Atleta.h"

using namespace std;

typedef struct no {
    Atleta a;
    struct no* esq;
    struct no* dir;
} Arvore;

/* Inserir na árvore */
Arvore* inserir(Atleta a, Arvore* raiz)
{
    if (raiz) { // se já existir dados
        if (a.nome == raiz->a.nome)
            return raiz; // voltando pq o dado já existe

        if (a.nome < raiz->a.nome) { // ir para a esquerda
            raiz->esq = inserir(a, raiz->esq);
        } else { // ir para a direita
            raiz->dir = inserir(a, raiz->dir);
        }
        return raiz;

    } else { // se árvore estiver vazia
        Arvore* novo = new Arvore();
        novo->a = a;
        novo->dir = NULL;
        novo->esq = NULL;
        return novo;
    }


}

Arvore* remove(string nome, Arvore* raiz) 
{
    if (raiz) {
        if (nome == raiz->a.nome) { // deleção nodo folha

            if (!raiz->esq && !raiz->dir) {
                delete raiz;
                return NULL;
            }

            // não é folha
            Arvore* novoPai;
            Arvore* temp;
            Arvore* p;

            // o filho da esquerda será novo pai
            if (raiz->esq) {
                novoPai = raiz->esq;
                temp = novoPai->dir;
                novoPai->dir = raiz->dir;
                for (p = novoPai->dir; p && p->esq; p = p->esq);

                if (p) {
                    p->esq = temp;
                }
                delete raiz;
                return novoPai;
            } else {
                novoPai = raiz->dir;
                delete raiz;
                return novoPai;
            }

        } else if (nome < raiz->a.nome) { // ir para esquerda
            raiz->esq = remove(nome, raiz->esq);

        } else { // ir para direita
            raiz->dir = remove(nome, raiz->dir);
        }
        return raiz;
    } else {
        return NULL;
    }
}

void exibirERD(Arvore* raiz)
{
    if (raiz) {
        exibirERD(raiz->esq);

        cout << "Nome: " << raiz->a.nome << endl;
        cout << "Apelido: " << raiz->a.apelido << endl;
        cout << "Altura: " << raiz->a.altura << endl;
        cout << "Posicao: " << raiz->a.posicao << endl;

        exibirERD(raiz->dir);
    }
}

void exibirRED(Arvore* raiz) 
{
    if (raiz) {
        cout << "Nome: " << raiz->a.nome << endl;
        cout << "Apelido: " << raiz->a.apelido << endl;
        cout << "Altura: " << raiz->a.altura << endl;
        cout << "Posicao: " << raiz->a.posicao << endl;
        exibirRED(raiz->esq);
        exibirRED(raiz->dir);
    }
}

void exibirEDR(Arvore* raiz) 
{
    if (raiz) {
        exibirEDR(raiz->esq); 
        exibirEDR(raiz->dir);
        cout << endl;
        cout << "Nome: " << raiz->a.nome << endl;
        cout << "Apelido: " << raiz->a.apelido << endl;
        cout << "Altura: " << raiz->a.altura << endl;
        cout << "Posicao: " << raiz->a.posicao << endl;
    }
}

void exibirArvore(Arvore* raiz, int nivel) 
{
    if (raiz) {
        // ir tudo para a direita
        exibirArvore(raiz->dir, nivel + 1);

        // visitar raiz
        for (int i = 0; i < nivel; i++) {
            cout << "   ";
        }
        cout << raiz->a.nome << "(" << nivel << ")\n";

        // ir tudo para a esquerda
        exibirArvore(raiz->esq, nivel + 1);
    }
}


int contarNodos(Arvore* raiz) 
{
    if (raiz) {
        return 1 + contarNodos(raiz->esq) + contarNodos(raiz->dir);
    } else {
        return 0;
    }
}

// copiar dados para o array
void copiarDados(Arvore* raiz, Atleta atletas[] , int& i) 
{
    if (raiz) {
        copiarDados(raiz->esq, atletas, i);
        atletas[i++] = raiz->a;
        copiarDados(raiz->dir, atletas,  i);
    }
}

void exibirPorAltura(Arvore* raiz) 
{
    Atleta atletas[contarNodos(raiz)];
    int i = 0;

    copiarDados(raiz, atletas, i);

    // ordenar por altura
    for (int i = 0; i < contarNodos(raiz); i++) {
        for (int j = i + 1; j < contarNodos(raiz); j++) {
            if (atletas[i].altura < atletas[j].altura) {
                Atleta temp = atletas[i];
                atletas[i] = atletas[j];
                atletas[j] = temp;
            }
        }
    }


    // exibir o array
    for (int i = 0; i < contarNodos(raiz); i++) {
        cout << "Nome: " << atletas[i].nome << endl;
        cout << "Apelido: " << atletas[i].apelido << endl;
        cout << "Altura: " << atletas[i].altura << endl;
        cout << "Posicao: " << atletas[i].posicao << endl;
        cout << endl;
    }

    

}

bool estaContidoPorApelido(string apelido, Arvore* raiz){
    if(raiz){
        if(apelido == raiz->a.apelido){
            cout << "Atleta encontrado!" << endl;
            cout << "Nome: " << raiz->a.nome << endl;
            cout << "Apelido: " << raiz->a.apelido << endl;
            cout << "Altura: " << raiz->a.altura << endl;
            cout << "Posicao: " << raiz->a.posicao << endl;
            cout << endl;            
            return true;
        }

        if(apelido < raiz->a.apelido){
            return estaContidoPorApelido(apelido, raiz->esq);
        } else {
            return estaContidoPorApelido(apelido, raiz->dir);
        }

        

    } else {
        return false;
    }
}


bool estaContido(string nome, Arvore* raiz) 
{
    if (raiz) {
        if (nome == raiz->a.nome) {
            return true;
        }

        if (nome < raiz->a.nome) { // ir para esquerda
            return estaContido(nome, raiz->esq);
        } else { // ir para direita
            return estaContido(nome, raiz->dir);
        }

    } else {
        return false;
    }
}
