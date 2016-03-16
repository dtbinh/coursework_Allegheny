import java.io.IOException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.*;

public class TodoListMain {

    //main method
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Todo List Manager!");
        System.out.println("What operation would you like to perform?");
        System.out.println("Available options: read, priority-search, category-search, done, list, quit");

        Scanner scanner = new Scanner(System.in);
        //instance of TodoList
        TodoList todoList = new TodoList();

        //calls methods from TodoList
        while(scanner.hasNext()) {
            String command = scanner.nextLine();
            if(command.equals("read")) {
                todoList.readTodoItemsFromFile();
            }
            else if(command.equals("list")) {
                System.out.println(todoList.toString());
            }
            else if(command.equals("done")) {
                System.out.println("What is the id of the task?");
                int chosenId = scanner.nextInt();
                todoList.markTaskAsDone(chosenId);
            }
            else if(command.equals("priority-search"))
            {
                System.out.println("What is the priority of the task?");
                String priorityletter = scanner.next();
                System.out.println("priority "+priorityletter);
                Iterator piterator = todoList.findTasksOfPriority(priorityletter);
                while (piterator.hasNext())
                {
                    TodoItem todoItem = (TodoItem)piterator.next();
                    System.out.println(todoItem.toString());
                }

            }


            else if (command.equals("category-search"))
            {
                System.out.println("What is the category of the task?");
                String category = scanner.nextLine();
                System.out.println("Category " +category);
                Iterator citerator = todoList.findTasksOfCategory(category);
                while (citerator.hasNext())
                {
                    TodoItem todoItem = (TodoItem)citerator.next();
                    System.out.println(todoItem.toString());
                }
            }
            else if(command.equals("quit")) {
                break;
            }


        }

    }

}
