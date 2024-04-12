package ObjectQueue;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Fila - FIFO - First In, First Out

public class StudentQueue {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Queue<Student> StQueue = new LinkedList<Student>();

        int Registration;
        String Name;

        for(int i = 0; i < 3; i ++){
            System.out.println("Registration: ");
            Registration = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Name: ");
            Name = keyboard.nextLine();
            System.out.println();
            StQueue.add(new Student(Registration, Name));
            
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------------------------------------");

        System.out.println("Queue: ");
        for (Student aluno : StQueue) {
            System.out.println(aluno.toString());
        }

        System.out.println("Showing head: ");
        System.out.println(StQueue.peek());
        System.out.println();

        System.out.println("Is Queue empty?");
        System.out.println(StQueue.isEmpty());
        System.out.println();

        Student a = new Student(5555, "Angela");
        System.out.println("Checking if 'Angela' is in the Queue: " + StQueue.contains(a));
        System.out.println();
        
        System.out.println("Queue size: " + StQueue.size());
        System.out.println();

        while(!StQueue.isEmpty())
            System.out.println("Removing " + StQueue.poll()); /*poll */

        keyboard.close();
    }
}