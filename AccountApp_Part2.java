/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accountapp_part2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class AccountApp_Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       Login login = new Login();
        System.out.println("===Registration===");

        // Registration process
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter a username : ");
        String username = scanner.nextLine();

        System.out.print("Enter a password : ");
        String password = scanner.nextLine();

        // Register the user
        String registrationMessage = login.registerUser(firstName, lastName, username, password);
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User registered successfully")) {
            // Get login details
            System.out.println("===Login===");
            System.out.print("Enter your username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String loginPassword = scanner.nextLine();

            // Display login status
            String loginStatus = login.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginStatus);
        }


     // After successful login, show Kanban menu
// JOptionPane EasyKanban Menu
        boolean exit = false;
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!!");

        while (!exit) {
            String[] options = {"Add tasks", "Show report", "Quit"};
            int option = JOptionPane.showOptionDialog(null, "Select an option:", "EasyKanban Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (option == JOptionPane.CLOSED_OPTION || option == 2) {
                // User chooses to quit or closes the window
                exit = true;
            } else if (option == 0) {
                // Add tasks functionality
                String taskNumInput = JOptionPane.showInputDialog(null, "How many tasks would you like to add?");
                if (taskNumInput == null) {
                    // User cancels
                    
                }
                int numTasks;
                try {
                    numTasks = Integer.parseInt(taskNumInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    continue;
                }

                int totalHours = 0;
                for (int i = 0; i < numTasks; i++) {
                    String taskName = JOptionPane.showInputDialog(null, "Enter task name:");
                    if (taskName == null) break;  // User cancels task entry

                    String taskDescription = JOptionPane.showInputDialog(null, "Enter task description (max 50 characters):");
                    if (taskDescription == null || taskDescription.length() > 50) {
                        JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
                        i--; // Retry this task if description fails
                        continue;
                    }

                    String developerDetails = JOptionPane.showInputDialog(null, "Enter developer details:");
                    if (developerDetails == null) break;  // User cancels task entry

                    String taskDurationInput = JOptionPane.showInputDialog(null, "Enter task duration (in hours):");
                    int taskDuration;
                    try {
                        taskDuration = Integer.parseInt(taskDurationInput);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        i--; // Retry this task if the duration is not valid
                        continue;
                    }

                    String[] statusOptions = {"To Do", "Doing", "Done"};
                    String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:",
                            "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

                    // Assuming Task class exists
                          Task task = new Task(taskName, taskDescription, developerDetails, i, taskDuration, taskStatus);
                    JOptionPane.showMessageDialog(null, task.printTaskDetails());

                    totalHours += taskDuration;
                }
                JOptionPane.showMessageDialog(null, "Total task hours: " + totalHours);
            } else if (option == 1) {
                // Show report functionality (currently in development)
                JOptionPane.showMessageDialog(null, "Coming Soon");
            }
        }
    }

    }
    

