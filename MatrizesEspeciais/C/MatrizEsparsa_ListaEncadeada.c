#include <stdio.h>
#include <stdlib.h>

#define TAM_L 500
#define TAM_C 300

typedef struct matTab {
  int linha;
  int coluna;
  float valor;
  // float valorR; //0-255
  // float valorG;
  // float valorB;
  struct matTab *prox;
} Celula;

Celula *inserir(int lin, int col, float val, Celula *matriz){
  Celula *novo, *p;

  novo = (Celula*) malloc (sizeof (Celula));
  novo->linha = lin;
  novo->coluna = col;
  novo->valor = val;
  novo->prox = NULL;
  if (!matriz) return novo;

  for (p = matriz; p->prox; p = p->prox){
    if (p->linha == lin && p->coluna == col) {
      printf("Coordenada jah informada\n");
      free(novo);
      return matriz;
    }
  }
  p->prox = novo;
  return matriz;
}

void exibir (Celula *matriz){
  printf("\n\nImprimindo a lista da matriz esparsa\n\n");
  if (matriz){
    while (matriz){
      printf ("Linha: %d  Coluna: %d   Valor: %.2f\n", matriz->linha, matriz->coluna, matriz->valor);
      matriz = matriz->prox;
    }
  } else printf("Matriz Esparsa vazia!!\n");
}

int main (){
  float matrizOriginal[TAM_L][TAM_C]; //pode representar uma imagem, um vídeo, planilha excel

  int i,j, cont;
  float val;

  /*fazer uma rotina que popule a matriz origem com alguns elementos
    não nullos e o restante com nulos.*/

  //inicializando a matriz com zeros
  for (i = 0; i < TAM_L; i++) {
    for (j = 0; j < TAM_C; j++) {
      matrizOriginal[i][j] = 0.0;
    }
  }

  for (cont = 0; cont < 5; cont++) {
    do {
      printf("Digite coordenada linha: ");
      scanf("%d",&i);
    } while (i < 0 || i >= TAM_L);

    do {
      printf("Digite coordenada coluna: ");
      scanf("%d",&j);
    } while (j < 0 || j >= TAM_C);

    do {
      printf("Digite um valor nao nulo: ");
      scanf("%f", &val);
    } while(val == 0.0);

    matrizOriginal[i][j] = val;
  }

  Celula *matrizEmLista = NULL;
  // fazer rotina que popule a matriz esparsa (lista) com elementos
  // nao nulos da matriz original.
  for (i = 0; i < TAM_L; i++) {
    for (j = 0; j < TAM_C; j++) {
      if (matrizOriginal[i][j] != 0.0) {
        matrizEmLista = inserir(i, j, matrizOriginal[i][j], matrizEmLista); //representando uma lista encadeada
      }
    }
  }

  //free(matrizOriginal);

  printf("DIGITANDO MAIS UM ELEMENTO PARA VERIFICAR DUPLICIDADE\nDigite coordenada linha: ");
  scanf("%d",&i);
  printf("Digite coordenada coluna: ");
  scanf("%d",&j);
  printf("Digite um valor nao nulo: ");
  scanf("%f", &val);
  matrizEmLista = inserir(i, j, val, matrizEmLista);

  // exibir a matriz esparsa.
  exibir(matrizEmLista);
  system("pause");
  return 0;
}