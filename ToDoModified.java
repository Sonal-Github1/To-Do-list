import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToDoModified {
    private ArrayList<String> tasks;
    private ArrayList<LocalDateTime> taskDateTime;
    private static final String FILENAME = "C://Users//USER//Desktop//Bsc in IT//COU3304 - Fundamentals of Programming//COU3304-todolist//ToDo.txt";

    public ToDoModified() {
        tasks = new ArrayList<>();
        taskDateTime = new ArrayList<>();
        loadTasksFromFile(); // Load tasks from file when the program starts
    }

    public void add(String task) {
        tasks.add(task);
        taskDateTime.add(LocalDateTime.now());
        saveTasksToFile(); // Save tasks to file after adding a new task
    }

    public void remove(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            taskDateTime.remove(index);
            saveTasksToFile(); // Save tasks to file after removing a task
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void display() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm a");
            for (int i = 0; i < tasks.size(); i++) {
                LocalDateTime dateTime = taskDateTime.get(i);
                String formattedDateTime = dateTime.format(formatter);
                System.out.println((i + 1) + ". " + tasks.get(i) + " - " + formattedDateTime);
            }
        }
    }

    private void saveTasksToFile() {
        try (FileWriter writer = new FileWriter(FILENAME)) {
            for (int i = 0; i < tasks.size(); i++) {
                String task = tasks.get(i);
                LocalDateTime dateTime = taskDateTime.get(i);
                writer.write(task + "|" + dateTime.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadTasksFromFile() {
        File file = new File(FILENAME);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split("\\|");
                    if (parts.length == 2) {
                        tasks.add(parts[0]);
                        taskDateTime.add(LocalDateTime.parse(parts[1]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ToDoModified ToDoModified = new ToDoModified();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\nToDoModified List Program");
            System.out.println("[1] Add Task");
            System.out.println("[2] Display Tasks");
            System.out.println("[3] Delete Task");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice [Num]: ");
            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                continue; 
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    ToDoModified.add(newTask);
                    System.out.println("Task added.");
                    break;
                case 2:
                    ToDoModified.display();
                    break;
                case 3:
                    System.out.print("Enter index of task to remove: ");
                    int indexToRemove = scanner.nextInt() - 1;
                    ToDoModified.remove(indexToRemove);
                    System.out.println("Task removed.");
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using me!");
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

