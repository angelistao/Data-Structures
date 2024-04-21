import aluno

hash_alunos = set()

for i in range(3):
    print('Aluno ' + str((i+1)))
    matricula = int(input("Matricula: "))
    nome = str(input('Nome: '))
    obj = aluno.aluno(matricula, nome)
    hash_alunos.add(obj)

print(hash_alunos)





    