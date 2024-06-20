using System;

// Fila - FIFO - First In, First Out

public class StudentQueue {
    public static void Main(string[] args){
        Queue<Student> StQueue = new Queue<Student>();

        
        string Name;
        string Registration;

        for(int i = 0; i < 3; i ++){
            Console.WriteLine("Registration: ");
            Registration = Console.ReadLine();
            Console.WriteLine("Name: ");
            Name = Console.ReadLine();
            Console.WriteLine();
            StQueue.Enqueue(new Student(Int32.Parse(Registration), Name));
            
        }

        Console.WriteLine();
        Console.WriteLine();
        Console.WriteLine();
        Console.WriteLine("------------------------------------------------------------------------------");

        Console.WriteLine("Queue: ");
        foreach (var student in StQueue) {
            Console.WriteLine(student.ToString());
        }

        Console.WriteLine("Showing head: ");
        Console.WriteLine(StQueue.Peek());
        Console.WriteLine();

        Console.WriteLine("Is Queue empty?");
        Console.WriteLine(StQueue.Count() == 0);
        Console.WriteLine();

        Student a = new Student(5555, "Angela");
        Console.WriteLine("Checking if 'Angela' is in the Queue: " + StQueue.Contains(a));
        Console.WriteLine();
        
        Console.WriteLine("Queue size: " + StQueue.Count());
        Console.WriteLine();

        while(StQueue.Count() != 0)
            Console.WriteLine("Removing " + StQueue.Dequeue()); /*poll */

    
    }
}