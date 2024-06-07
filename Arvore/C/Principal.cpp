#include <iostream>
#include <ctime>

using namespace std;

#include "Arvore.h"

int main(){
    srand(time(NULL));
    Arvore *arvore = NULL;

    arvore = inserir(7, arvore);
    arvore = inserir(6, arvore);
    arvore = inserir(5, arvore);
    arvore = inserir(15, arvore);

    // exibir RED
    
    // exibir ERD

    // exibir EDR
    

    // exibir arvore
    exibirArvore(arvore, 0);

    return 1;
}