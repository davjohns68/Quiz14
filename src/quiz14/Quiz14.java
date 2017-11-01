/*
 * Chapter 14 quiz
 * Created by David Johnson, November 1, 2017
 * for CS211 course, Bellevue College
 */
package quiz14;
import java.util.*;

public class Quiz14 {

    public static void main(String[] args) {
        Stack<Integer> testS = new Stack<>();
        Stack<Integer> testSEmpty = new Stack<>();
        Queue<Integer> testQ = new LinkedList<>();
        Queue<Integer> testQEmpty = new LinkedList<>();
        
        Random rand = new Random();
        
        // Build the test stack and queue
        for (int i = 1; i <= 6; i++) {
            testS.push(rand.nextInt(100));
            testQ.add(rand.nextInt(100));
        }
        
        System.out.println("Original stack: " + testS);
        System.out.println("Mirrored stack: " + mirror(testS));
        System.out.println("Original stack after: " + testS);
        System.out.println("Mirrored empty stack: " + testSEmpty);
        
        System.out.println("Original queue: " + testQ);
        System.out.println("Mirrored queue: " + mirror(testQ));
        System.out.println("Original stack after: " + testQ);
        System.out.println("Mirrored empty stack: " + testQEmpty);
    }
    
    // Write a method mirror that accepts a Stack of integers as a parameter and 
    // returns the Stack contents with itself plus a mirrored version of itself 
    // (the same elements in the opposite order).
    public static Stack<Integer> mirror(Stack<Integer> numbers) {
        // Auxiliary Storage
        Stack<Integer> tempS = new Stack<>();
        Queue<Integer> tempQ = new LinkedList<>();
        // To hold the results
        Stack<Integer> results = new Stack<>();
        
        //  After this loop, numbers is empty and tempS has the stack in reverse order
        while (!numbers.isEmpty()) {
            tempS.push(numbers.pop());
        }
        
        // After this loop, tempS is empty and tempQ has list in proper order
        while (!tempS.isEmpty()) {
            tempQ.add(tempS.pop());            
        }
        
        // This loop fills the beginning of results and puts numbers back the way
        // we found it.  Also fills tempS so we can pop the numbers off in 
        // reverse order for the mirror effect
        while (!tempQ.isEmpty()) {
            int n = tempQ.remove();
            results.push(n);
            tempS.push(n);
            numbers.push(n);
        }
        
        // Now we finish building the results
        while (!tempS.isEmpty()) {
            results.push(tempS.pop());
        }
        
        return results;
    }
    
    // Write a method mirror that accepts a Queue of integers as a parameter and 
    // returns the Queue contents with itself plus a mirrored version of itself 
    // (the same elements in the opposite order).
    // Essentially a modified version of the Stack version
    public static Queue<Integer> mirror(Queue<Integer> numbers) {
        // Auxiliary Storage
        Stack<Integer> tempS1 = new Stack<>();
        Stack<Integer> tempS2 = new Stack<>();
        // To hold the results
        Queue<Integer> results = new LinkedList<>();
        
        //  After this loop, numbers is empty and tempS1 has the queue in reverse order
        while (!numbers.isEmpty()) {
            tempS1.push(numbers.remove());
        }
        
        // After this loop, tempQ is empty and tempS has list in proper order
        while (!tempS1.isEmpty()) {
            tempS2.push(tempS1.pop());            
        }
        
        // This loop fills the beginning of results and puts numbers back the way
        // we found it.  Also fills tempS so we can pop the numbers off in 
        // reverse order for the mirror effect
        while (!tempS2.isEmpty()) {
            int n = tempS2.pop();
            results.add(n);
            tempS1.push(n);
            numbers.add(n);
        }
        
        // Now we finish building the results
        while (!tempS1.isEmpty()) {
            results.add(tempS1.pop());
        }
        
        return results;
        
    }
}
