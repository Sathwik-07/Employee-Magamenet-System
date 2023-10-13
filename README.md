
# Source code :

This is a  console based stand alone  application and  it is not a  web application.I developed this  application using  Core Java with Java Database Connectivity(JDBC).

# Features

(1) Inserting the employee details 

(2) Updating the employee details 

(3) Deleting the employee details 

(4) Displaying the employee details 


# Important packages used in this Project

(1) java.sql.Connection;

(2) java.sql.DriverManager;

(3) java.sql.PreparedStatement;

(4) java.sql.ResultSet;

(5) java.sql.SQLException;

(6) java.util.Scanner;

#   Output Screen Shots

# (1) Inserting the Employee details


 This options selecting prompt appears  to the user.Based  on the user's wish  he will select his choice.In this case i selected the insert operation.
 Like this we can enter many employees's  details.


![Screenshot (193)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/1f925a22-5771-49f8-90fb-bd7e1892c7ba)


### Checking the Employees details inside the database


![Screenshot (194)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/a8fc19be-075a-4dcd-a0b4-de003013153e)


![Screenshot (196)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/71b76350-fe4a-4c47-a474-84815f2f0019)

Here you can see that employee details are inserted successfully



# (2) Updating the Employee details

In this project I upadted the name and salary of the employee having id 200.

Like this we can update the other employee details also

![Screenshot (197)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/ff32ec69-3288-4975-b6ba-047c8a57e586)

### Checking the Updated Employees details inside the database


![Screenshot (198)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/4f7f232d-60b8-4581-bc8c-3e6256fd8497)

Here you can see that employee details has been updated successfully



# (3) Deleting the Employee details from the databse

In this project we can delete the employees's details from the database based on their employee id.In this case i deleted the details of the employee having id as 300


![Screenshot (199)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/f7878173-a197-4d38-9c35-fa26dadd854b)

Here you can see that employee details has been deleted successfully


## Checking the deleted Employees details inside the database


![Screenshot (200)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/8a9a1087-1927-4b3c-99f1-0545e8144656)


# (4) Deleting the Employee details from the databse


![Screenshot (201)](https://github.com/Sathwik-07/Employee-Management-System/assets/130444732/6fafba5e-1aae-4067-82a1-8b01eb7388c9)


# How I Connected this Java application to database

Before connecting to the database we need to have the following details 

### In this project Database configuration details are as follows

### (1) Port number : 3306

### (2) Driver software url : jdbc:mysql://localhost:3306/employees 

### (3) Database user name  : "root"

### (4) Data base password  : sathwikdb7@@*

### (5) Database name : empployees


Inside the employees database i   have  a table named employee


Here are the following  Steps  to be followed

### (1) Loading the driver software

### (2) Creating the connection object

### (3)  Creating the Statement object

### (4) Executing the Query Statement

### (5) Process the result

### (6) Close the connection


# Rub time Environment

I used Eclipse IDE


# Jar files

I used Mysql Connector Jar file in this project




























