
typedef struct Nodo {
  int dado;
  struct Nodo *prox;
} Lista;

void exibir(Lista* lista) /* Exibe conteúdo da lista */
{
  std::cout << "[ ";
  for (Lista *p = lista; p != NULL; p = p->prox) 
  {
    std::cout << p->dado << " ";
  }
  std::cout << "]";

}

int count(Lista* lista)
{
  int total = 0;
  for (Lista *p = lista; p != NULL; p = p->prox) 
  {
    total++;
  }
  return total;
}

bool contains(int valor, Lista* lista)
{
  for (Lista *p = lista; p != NULL; p = p->prox) 
  {
    if(valor == p->dado) return true;
  }

  return false;

}

Lista* inserir(int valor, Lista* lista)
{
  /* Alocar memória */
  Lista *novo = (Lista*)malloc(sizeof(Lista));

  /* Depositar valores no nodo a ser incluído na lista */
  novo->dado = valor;
  novo->prox = NULL;

  /* Achar posição na lista e controlar duplicados */
    /* Se lista for NULL, retorna o próprio nodo com o valor embutido */
  if(!lista) return novo;

  /* Técnica de p e p-retaguarda */
  Lista *p, *pR; 

  /* p retaguarda sempre "atrás" do p */
  for(pR = NULL, p = lista; p; pR = p, p = p->prox)
  {
    /* Se houver duplicado, retorna a própria lista */
    if(valor == p->dado) 
    { 
      free(novo); /* libera a memória ocupada por aquele duplicado */
      return lista;
    }

    /* Se o valor inserido for menor que o dado do p atual, foi achada a posição para ordenação da lista */
    if(valor < p->dado) {
      break; /* encontrada a posição para o novo */
    }

  }

  if (p == lista) /* Se o valor a ser inserido for menor que o valor do primeiro nó da lista,  significa que o valor a ser inserido é menor que o valor do primeiro nó da lista */
  {
    novo->prox = lista; /* o novo nodo se torna o novo primeiro nodo da lista */
    return novo;
  }

  /* Se p for nulo, valor da retaguarda será o nodo com o valor inserido */
  if(p == NULL) pR->prox = novo;


  /* O endereço de novo estará no meio da lista */
  pR->prox = novo;
  novo->prox = p;
  return lista;
}

