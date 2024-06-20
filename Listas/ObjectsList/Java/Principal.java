package Listas.ObjectsList.Java;

import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args){

        ArrayList<Student> StudentList = new ArrayList<Student>();

        String name, course;
        int age;

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            System.out.println("Student nr " + (i+1));
            System.out.println("Name: ");
            name = sc.nextLine().toUpperCase();
            System.out.println("Age: ");
            age = sc.nextInt();
            System.out.println("Course: ");
            course = sc.nextLine().toUpperCase();
            sc.nextLine();

            Student obj = new Student(name, age, course);

            if(!StudentList.contains(obj)){
                StudentList.add(obj);
                StudentList.sort((a1, a2) -> a1.getName().compareTo(a2.getName())); // lambda java
            } else {
                System.out.println("Aluno já cadastrado.");
            }
        }


        for(Student student : StudentList){
            System.out.println(student.toString());
        }


        sc.close();

    }
}
