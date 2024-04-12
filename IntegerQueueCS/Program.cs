using System;
using System.Collections.Generic;
// Fila - FIFO - First In, First Out

public class IntegerQueue {
    public static void Main(string[] args){
        Queue<int> IntQueue = new Queue<int>();

        IntQueue.Enqueue(50);
        IntQueue.Enqueue(5);
        IntQueue.Enqueue(12);

        Console.WriteLine("Queue:");
        foreach (var item in IntQueue)
        {
            Console.WriteLine(item);
        }
        Console.WriteLine();

        Console.WriteLine("Showing head: ");
        Console.WriteLine(IntQueue.Peek());
        Console.WriteLine();

        Console.WriteLine("Is Queue empty?");
        Console.WriteLine(IntQueue.Count() == 0);
        Console.WriteLine();

        Console.WriteLine("Size: " + IntQueue.Count());
        Console.WriteLine();

        Console.WriteLine("Checking if 5 is in the queue: " + IntQueue.Contains(5));
    }
}