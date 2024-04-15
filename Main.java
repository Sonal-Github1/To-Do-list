import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<String> tasks;

    public Main() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void Main(String[] args) {
        Main Main = new Main();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTodo List Mainlication");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (Num): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    Main.addTask(newTask);
                    System.out.println("Task added.");
                    break;
                case 2:
                    System.out.print("Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt() - 1;
                    Main.removeTask(indexToRemove);
                    System.out.println("Task removed.");
                    break;
                case 3:
                    Main.displayTasks();
                    break;
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
