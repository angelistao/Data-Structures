using System;
using System.Collections;

class Program {
  
  public static void Main (string[] args) {
    Stack pilha = new Stack();

    pilha.Push(10);
    pilha.Push(5);
    pilha.Push(15);

    Console.WriteLine(pilha);

    foreach(var item in pilha){
      Console.WriteLine(item);
    }

    Console.WriteLine(pilha.Peek());
    Console.WriteLine(pilha.Contains(6));

    pilha.Pop();
    
  }
}