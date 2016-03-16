public class TodoItem {

    //instance variables
    private int id;
    private static int nextId = 0;
    private String priority;
    private String category;
    private String task;
    private boolean done;

    //constructor
    public TodoItem(String p, String c, String t) {
        //initialize variables
        id = nextId;
        nextId++;
        priority = p;
        category = c;
        task = t;
        done = false;
    }

    //***********************
    //get methods
    //***********************
    public int getId() {
        return id;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public String getTask() {
        return task;
    }

    //**********************
    //set method
    //**********************
    public void markDone() {
        done = true;
    }

    //*********************
    //get methods
    //*********************
    public boolean isDone() {
        return done;
    }

    public String toString() {
        return new String(id + ", " + priority + ", " + category + ", " + task + ", done? " + done);
    }

}
