import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    private ArrayList<String> tasks;//initializing array list
    // array list is a data structure which has no pre define limit and can use .add(),.remove() and .isEmpty() pre difined methods to minipulate data
    // why choose array list over nomal string array,becouse array list have no predefied limit like nomal array and array list have build in methods to minipulate data.

    public ToDo() {
        tasks = new ArrayList<>();//this is a instance of above arraylist called tasks
    }

    public void addTask(String task) {
        tasks.add(task);//this method use build in .add function to add tasks to the array list
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);//logic says if index of a task bigger than or equal to 0(not negative) AND size of the arraylist bond with index.
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");//this check if input empty or not by .isEmpty built in method 
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {// .size condition iterate through all the objects inside the array list
                System.out.println((i + 1) + ". " + tasks.get(i));//this built-in .get method use to display the previously added task
            }
        }
    }

    public static void main(String[] args) {// this is where program start to execute
        ToDo ToDo = new ToDo();// instance of todo class to get access to above methods
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTodo List Program");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (Num): ");
            int choice;

        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
            scanner.nextLine();
            continue; 
        }

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    ToDo.addTask(newTask);// uses the addtask method
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt() - 1;
                    ToDo.removeTask(indexToRemove);// uses the removetask method
                    System.out.println("Task removed.");
                    break;
                case 3:
                    ToDo.displayTasks();
                    break;// uses the displaytask method
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
