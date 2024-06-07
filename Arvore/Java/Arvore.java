package Java;
import java.util.TreeSet;

import javax.swing.JOptionPane;

/*Percorrer a árvore*/
/* RED, ERD, EDR */

class Aluno implements Comparable<Aluno> {
    int matricula;
    String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula != other.matricula)
            return false;
        return true;
    }

    @Override
    public int compareTo(Aluno o) {
        if (this.matricula < o.matricula){
            return -1;
        } else if (this.matricula > o.matricula){
            return 1;
        } 

        return 0;
    }

    
    
}

public class Arvore {
    public static void main(String[] args) {
        TreeSet<Aluno> arvore = new TreeSet<>();
    
        // arvore.add(new Aluno(20, "Yuri"));
        // arvore.add(new Aluno(10, "Angela"));
        // arvore.add(new Aluno(1, "Alex"));
        // arvore.add(new Aluno(5, "Anthony"));
        // arvore.add(new Aluno(4, "Pinheiro"));

        int matricula;
        String nome;

        for(int i = 0; i < 5; i++){
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Matricula"));
            nome = JOptionPane.showInputDialog(null, "Nome").toUpperCase();
            Aluno a = new Aluno(matricula, nome);
            if(!arvore.contains(a)){
                arvore.add(a);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno ja cadastrado!!");
                System.gc();
            }
        }

        for (Aluno aluno : arvore) {
            System.out.println(aluno);
        }
    }
}