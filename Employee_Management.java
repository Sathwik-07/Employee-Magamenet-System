package com.project.EmployeeCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee_Management
{
    private static final String DB_URL = "jdbc:mysql://localhost:3306/employees";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "sathwikdb7@@*";

    private static Connection connection;

    static 
    {
        try 
        {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        Employee_Management e = new Employee_Management();
        Scanner s = new Scanner(System.in);

        while (true) 
        {
            System.out.println("Employee Management System\n");
            System.out.println("1. Insert Employee details");
            System.out.println("2. Update Employee by ID");
            System.out.println("3. Delete Employee by ID");
            System.out.println("4. Display Employee details");
            System.out.println("0. Exit\n");
            System.out.print("Enter your choice: ");

            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    e.insert(s);
                    break;
                case 2:
                    e.update(s);
                    break;
                case 3:
                    e.delete(s);
                    break;
                case 4:
                    System.out.print("Enter employee ID to display: ");
                    int idToDisplay = s.nextInt();
                    s.nextLine();
                    e.display(idToDisplay);
                    break;
                    
                case 0:
                    System.out.println("Exiting the Program!");
                    s.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void insert(Scanner s)
    {
        System.out.print("Enter the Employee ID: ");
        int id = s.nextInt();
        s.nextLine();

        System.out.print("Enter the Employee name: ");
        String name = s.nextLine();

        System.out.print("Enter the Employee salary: ");
        double salary = s.nextDouble();
        s.nextLine();

        System.out.print("Enter the  Employee address: ");
        String address = s.nextLine();

        try 
        {
            String sql = "INSERT INTO Employee (id, name, salary, address) VALUES (?, ?, ?, ?)";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            p.setString(2, name);
            p.setDouble(3, salary);
            p.setString(4, address);

            int rowsInserted = p.executeUpdate();
            if (rowsInserted > 0) 
            {
                System.out.println("\nEmployee details inserted into the data base successfully\n.");
            } else {
                System.out.println("\nFailed to insert employee details into the database.");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    public void update(Scanner s) 
    {
        try {
            System.out.print("\nEnter the Employee ID to update: ");
            int idToUpdate = s.nextInt();
            s.nextLine();

            System.out.println("\n Select the data field that is to be  updated:");
            System.out.println("1. Update name");
            System.out.println("2. Update salary");
            System.out.println("3. Update address");
            System.out.print("\n Enter your choice among these 3 options: ");

            int fieldChoice = s.nextInt();
            s.nextLine();

            String columnName = "";
            String prompt = "";

            switch (fieldChoice) 
            {
                case 1:
                    columnName = "name";
                    prompt = "\nEnter the updated Employee name: ";
                    break;
                case 2:
                    columnName = "salary";
                    prompt = "\nEnter updated Employee salary: ";
                    break;
                case 3:
                    columnName = "address";
                    prompt = "\nEnter updated Employee address: ";
                    break;
                default:
                    System.out.println("\nInvalid choice. No updates were made.");
                    return;
            }

            System.out.print(prompt);
            String updatedValue = s.nextLine();

            String sql = "UPDATE Employee SET " + columnName + " = ? WHERE id = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, updatedValue);
            p.setInt(2, idToUpdate);

            int rowsUpdated = p.executeUpdate();
            if (rowsUpdated > 0)
            {
                System.out.println("Employee " + columnName + " updated successfully\n.");
            } 
            else 
            {
                System.out.println("No Employee found with the given ID.");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    
    
    public void delete(Scanner s)
    {
        System.out.print("\n Enter the Employee ID to delete: ");
        int idToDelete = s.nextInt();
        s.nextLine();

        try {
            String sql = "DELETE FROM Employee WHERE id = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idToDelete);

            int rowsDeleted = p.executeUpdate();
            if (rowsDeleted > 0) 
            {
                System.out.println("\nEmployee details deleted successfully\n.");
            } 
            else {
                System.out.println("\nNo Employee found with the given ID.");
            }
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void display(int employeeId) 
    {
        try 
        {
            String sql = "SELECT * FROM Employee WHERE id = ?";
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, employeeId);
            ResultSet r = p.executeQuery();

            if (r.next()) 
            {
                int id = r.getInt("id");
                String name = r.getString("name");
                double salary = r.getDouble("salary");
                String address = r.getString("address");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: " + salary);
                System.out.println("Address: " + address);
            } 
            else
            {
                System.out.println("\nNo Employee found with the given ID.");
            }
        } catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
}
