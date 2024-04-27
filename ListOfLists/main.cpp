// Nomes: Angela Mahlke Ranoff & Yuri Alexander da Costa Machado

#include <cctype>
#include <iostream>
#include <ctime>

#include "Lista.hpp"

/* Na linguagem C++ ou nas linguagens estudadas fazer o seguintes PROGRAMA:
 Gerar N listas de tamanho M com números aleatórios.
 Mostrar seus conteúdos.
 Mostrar os números que aparecem nas N listas.
 Mostrar os números que aparecem somente em uma das listas.
 List listaGenerica = new List();
*/

int main() {
  srand(time(NULL));
  /* n - var. do nr de listas, m - var. do tam. das listas */
  int n, m;

  std::cout << "Digite o nr de listas: ";
  std::cin >> n;

  std::cout << "Digite o tam. das listas: ";
  std::cin >> m;

  /* É necessário criar uma matriz de dados */
  /* Alocar a memória necessária para alocar as 'n' listas */
  Lista **listaGenerica = (Lista **)malloc(n * sizeof(Lista));

  /* Colocando os valores nas listas */
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      listaGenerica[i] = inserir(rand() % 200, listaGenerica[i]);
    }
  }

  /* Mostrar conteúdo das listas */
  for (int i = 0; i < n; i++) {
    std::cout << "Lista " << i + 1 << ": ";
    exibir(listaGenerica[i]);
    std::cout << std::endl;
  }

  Lista* auxiliar = NULL;
  
  std::cout << "\n\nNúmeros que aparecem nas n listas: ";
  for (int i=0; i < n; i++) {
    /* Verificação dos valores */
    
    for (Lista *p = listaGenerica[i]; p != NULL; p = p->prox) {
      if (contains(p->dado, listaGenerica[i]))
        auxiliar = inserir(p->dado, auxiliar);
    }
  }

  exibir(auxiliar);
  free(auxiliar);

  for(int i = 0; i < n; i++){
    
    Lista* listaExibicao = NULL;
    
    for (Lista *p = listaGenerica[i]; p != NULL; p = p->prox) {
      bool flag = false; /* flag usada para controle de comparação */
      
      for(int j = 0; j < n; j++){
        if(i != j && contains(p->dado, listaGenerica[j])){ /* i!=j para não considerar lista atual */
          flag = true;
          break;
        }
      }

      if (!flag) listaExibicao = inserir(p->dado, listaExibicao);

    }

    std::cout << "\n\nNúmeros que aparecem somente na lista " << i + 1 << std::endl;
    exibir(listaExibicao);
    
    delete(listaExibicao); /* libera memória */
  }

  delete(listaGenerica);
}
