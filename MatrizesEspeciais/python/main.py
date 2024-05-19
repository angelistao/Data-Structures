
TAML = 10
TAMC = 10


class Celula: 

    def __init__(self, linha, coluna, valor): 
        self.linha = linha
        self.coluna = coluna
        self.valor = valor
    
    def __eq__(self, other):
        return (self.linha, self.coluna, self.valor) == (other.linha, other.coluna, other.valor)

    
    def __hash__(self): 
        return (hash(self.linha) + hash(self.coluna) + hash(self.valor))

    def __str__(self): 
        return f'Coluna [linha={self.linha} coluna={self.coluna} valor={self.valor}]'
    

    def transformar_matriz_em_hash(matriz, tabelaHash):
        for i in range(TAML):
            for j in range(TAMC):
                if (matriz[i][j] != 0):
                    tabelaHash.add(Celula(i, j, matriz[i][j]))


    def exibir_hash(set):
        for celula in set:
            print(celula)
        

class MatrizEspecial: 

    def zerar_matriz(matriz):
        for i in range(TAML):
            for j in range(TAMC):
                matriz[i][j] = 0
            
        

    def mostrar_matriz(matriz):
        for i in range(TAML):
            for j in range(TAMC):
                print(f"{matriz[i][j]}", end= "\t")
            
            print("\n")
        
    

    def main():

        matriz = []
        for i in range(TAML):
            linha = []
            for j in range(TAMC):
                linha.append(0)
            matriz.append(linha)


        MatrizEspecial.zerar_matriz(matriz)

        matriz[0][0] = 100
        matriz[5][5] = 100
        matriz[9][9] = 100

        tabelaHash = set()

        MatrizEspecial.mostrar_matriz(matriz)
        Celula.transformar_matriz_em_hash(matriz, tabelaHash)
        Celula.exibir_hash(tabelaHash)

if __name__ == "__main__":
    MatrizEspecial.main()

    

