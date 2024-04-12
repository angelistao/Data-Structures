import java.util.LinkedList;
import java.util.Queue;

// Fila - FIFO - First In, First Out

public class IntegerQueue {
    public static void main(String[] args){
        Queue<Integer> IntQueue = new LinkedList<Integer>();

        IntQueue.add(50);
        IntQueue.add(5);
        IntQueue.add(12);

        System.out.println("Showing head: ");
        System.out.println(IntQueue.peek());

        System.out.println("Is Queue empty?");
        System.out.println(IntQueue.isEmpty());
        System.out.println();

        System.out.println("Size: " + IntQueue.size());

        System.out.println("Checking if 5 is in the queue: " + IntQueue.contains(5));
    }
}