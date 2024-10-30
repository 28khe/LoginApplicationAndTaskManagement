/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountapp_part2;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private static int taskCount = 0;

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    public Task(String taskName, String taskDescription, String developerDetails, int taskDuration, int taskDuration1, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();
        taskCount++;
    }

    // Check if task description is less than 50 characters
    public boolean checkTaskDescription() {
        return this.taskDescription.length() <= 50;
    }

    // Create TaskID
    public String createTaskID() {
        String taskNum = String.valueOf(taskCount);
        String taskInitials = taskName.substring(0, 2).toUpperCase();
        String developerInitials = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return taskInitials + ":" + taskNum + ":" + developerInitials;
    }

    // Print Task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + developerDetails +
                "\nTask Number: " + taskCount +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + taskID +
                "\nTask Duration: " + taskDuration + " hours";
    }

    // Return task duration
    public int getTaskDuration() {
        return taskDuration;
    }
}
