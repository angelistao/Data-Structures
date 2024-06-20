package Pilha.Java;

import java.util.Stack;


public class StackTest {
    public static void main(String[] args){
        Stack<Integer> pilha = new Stack<>();


        pilha.push(10);

        pilha.push(5);

        pilha.push(15);
    
        System.out.println(pilha);
    
        for(int item : pilha){
          System.out.println(item);
        }
    
        System.out.println(pilha.peek());
        System.out.println(pilha.contains(6));
    
        pilha.pop();
        

    }
}
