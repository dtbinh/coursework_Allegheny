public class Weeee {                        //class declaration

    public static void weeee() {            //method creation
        System.out.println("Weeee!");
        weeee();                            //output in terminal indicates an error at this line,
                                            //method is calling itself
    }

    public static void main(String[] args) { //main method
        weeee();                            //method call within class (does not require dot operator)
    }

}
