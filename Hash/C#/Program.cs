
HashSet<Aluno> hashAluno = new HashSet<Aluno>();

int matricula;
string nome;

for(int i = 0; i < 4; i++){
    Console.Write("Matricula: ");
    matricula = Int32.Parse(Console.ReadLine());
    Console.Write("Nome: ");
    nome = Console.ReadLine().ToUpper();

    if(!hashAluno.Add(new Aluno(matricula, nome))){
        Console.WriteLine("Aluno ja cadastrado!!!");
    }
}

foreach (var item in hashAluno)
{
    Console.WriteLine(item);
}