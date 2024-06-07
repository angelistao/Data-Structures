#include <ctime>
#include <stdio.h>
#include <stdlib.h>


typedef struct no {
    int dado;
    struct no *esq;
    struct no *dir;
} Arvore;

/*Percorrer a árvore*/
/* RED, ERD, EDR */

Arvore* inserir(int valor, Arvore* raiz){
    if(raiz){
        if(valor == raiz->dado)
            return raiz; // voltando pq o dado já existe
        
        /*  */
        if(valor < raiz->dado) { // ir para a esquerda
            raiz->esq = inserir(valor, raiz->esq);
        } else { // ir para a direita
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;

    } else {
        Arvore* novo = (Arvore*)malloc(sizeof(Arvore));
        novo->dado = valor;
        novo->dir = NULL;
        novo->esq = NULL;
        return novo;
    }
}

void exibirERD(Arvore *raiz){
    if(raiz){
        exibirERD(raiz->esq);
        cout << raiz->dado << endl;
        exibirERD(raiz->dir);
    }
    
}

void exibirRED(Arvore *raiz){
    if(raiz){
        cout << raiz->dado << endl;
        exibirRED(raiz->esq);
        exibirRED(raiz->dir);
    }
    
}

void exibirEDR(Arvore *raiz){
    if(raiz){
        exibirEDR(raiz->esq);
        exibirEDR(raiz->dir);
        cout << raiz->dado << endl;
    }
    
}

void exibirArvore(Arvore* raiz, int nivel){
    if(raiz) {
        // ir tudo para a direita
        exibirArvore(raiz->dir, nivel + 1);

        // visitar raiz
        for(int i = 0; i < nivel; i++){
            cout << "   ";
        }
        cout << raiz->dado << "(" << nivel << ")\n";

        // ir tudo para a esquerda
        exibirArvore(raiz->esq, nivel + 1);
    }
}

int contarNodos(Arvore* raiz){
    if(raiz){
        1 + contarNodos(raiz->esq) + contarNodos(raiz->dir);
    } else {
        return 0;
    }
}

int somarNodos(Arvore* raiz){
    if(raiz){
        raiz->dado + somarNodos(raiz->esq) + somarNodos(raiz->dir);
    } else {
        return 0;
    }
}

bool estaContido(int valor, Arvore* raiz){
    if(raiz){
        if(valor == raiz->dado){
            return true;
        }

        if(valor < raiz->dado){ // ir p esquerda
            return estaContido(valor, raiz->esq);
        } else { // ir pra direita
            return estaContido(valor, raiz->dir);
        }

        
    } else {
        return false;
    }
}

int contarNodosFolha(Arvore* raiz){
    if(raiz){

    } else {

    }
}

