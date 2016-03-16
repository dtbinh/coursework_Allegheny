import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class TodoList {

    //instance variables
    //calls information from the todo.txt file into an ArrayList
    private ArrayList<TodoItem> todoItems;
    private static final String TODOFILE = "todo.txt";

    //*************************
    //methods (use methods from TodoItem) on information gathered from Array List
    //*************************
    public TodoList() {
        todoItems = new ArrayList<TodoItem>();
    }

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    public Iterator getTodoItems() {
        return todoItems.iterator();
    }

    public void readTodoItemsFromFile() throws IOException {
        Scanner fileScanner = new Scanner(new File(TODOFILE));
        while(fileScanner.hasNext()) {
            //variable dictionary
            String todoItemLine = fileScanner.nextLine();
            Scanner todoScanner = new Scanner(todoItemLine);
            todoScanner.useDelimiter(",");
            String priority, category, task;
            priority = todoScanner.next();
            category = todoScanner.next();
            task = todoScanner.next();
            TodoItem todoItem = new TodoItem(priority, category, task);
            todoItems.add(todoItem);
        }
    }
    //set method to mark task as done
    public void markTaskAsDone(int toMarkId) {
        Iterator iterator = todoItems.iterator();
        while(iterator.hasNext()) {
            TodoItem todoItem = (TodoItem)iterator.next();
            if(todoItem.getId() == toMarkId) {
                todoItem.markDone();
            }
        }
    }
    //set method to find tasks of priority
    public Iterator findTasksOfPriority(String requestedPriority) {
        ArrayList<TodoItem> priorityList = new ArrayList<TodoItem>();

        // TODO: Add source code that will find and return all tasks of the requestedPriority
        Iterator iterator = todoItems.iterator();
        while(iterator.hasNext())
        {
            TodoItem todoItem = (TodoItem)iterator.next();
            String priority  = todoItem.getPriority();
            if(priority.equals(requestedPriority))
            {
                priorityList.add(todoItem);
            }
        }
            return priorityList.iterator();
    }
    //set method to find tasks of category
    public Iterator findTasksOfCategory(String requestedCategory) {
        ArrayList<TodoItem> categoryList = new ArrayList<TodoItem>();
        // TODO: Add source code that will find and return all tasks for the requestedCategory
        Iterator iterator = todoItems.iterator();
        while (iterator.hasNext())
        {
            TodoItem todoItem = (TodoItem)iterator.next();
            String category = todoItem.getCategory();
            if(category.equals(requestedCategory))
            {
                categoryList.add(todoItem);
            }
        }
           return categoryList.iterator();
    }
    //class for converting to a String
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        Iterator iterator = todoItems.iterator();
        while(iterator.hasNext()) {
            buffer.append(iterator.next().toString());
            if(iterator.hasNext()) {
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }

}
