package Hash.Java;


import java.util.HashSet;


public class HashAluno {
    public static void main(String[] args){
        HashSet<Aluno> hashAluno = new HashSet<>();

        hashAluno.add(new Aluno(1, "Angela"));

        for(Aluno item : hashAluno){
            System.out.println(item);
        }

        Aluno obj = new Aluno(1, "Angela");

        if(hashAluno.contains(obj)){
            System.out.println("Encontrado.");
        } else {
            System.out.println("Não encontrado.");
        }


    }
}


