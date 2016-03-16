import java.util.Stack;
import java.util.Scanner;
import java.util.Random;

public class StackMachine{
    public static void main (String [] args){
        Stack<String> stackIt = new Stack();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter inputs to the Stack one at a time.");
        boolean test = true;
        while(scan.hasNext()&& test == true){
           String i = scan.nextLine();
            //if the user inputs x, exit the program
            if (i.equals("x")){
               test = false;
               break;
            }
            //if the user inputs e, go into the nested if/else statements for next move
            else if(i.equals("e")){
              //if the object on top is an s, switch the next two ints
                if (stackIt.peek().equals("s")){
                    stackIt.pop();
                    String b = stackIt.pop();
                    String c = stackIt.pop();
                    stackIt.push(b);
                    stackIt.push(c);
                }
                //if the object on the top of the Stack is a +, add the next two values
                else if (stackIt.peek().equals("+")){
                    stackIt.pop();
                    int x = Integer.parseInt(stackIt.pop());
                    int y = Integer.parseInt(stackIt.pop());
                    int d = x + y;
                    String e = Integer.toString(d);
                    stackIt.push(e);
                }
                //if this is just an int or the stack is empty, leave it
                else {}
            }
            //display the contents of the stack, from top to bottom
            else if (i.equals("d")){
                while (stackIt.empty() != true){
                    System.out.println(stackIt.pop());
                }
            }
            //any other value should be pushed onto the stack
            else {
                stackIt.push(i);

            }
        }
    }
}
