import java.sql.*;
import java.util.Scanner;

public class EmployeeManagementSystem {

    static final String URL = "jdbc:mysql://localhost:3306/ems";
    static final String USER = "root";
    static final String PASS = "T#9758@qlph";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            int choice;

            do {
                System.out.println("\n===== Employee Management System =====");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    // INSERT
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        String insertQuery = "INSERT INTO employee VALUES (?, ?, ?, ?)";
                        PreparedStatement ps1 = con.prepareStatement(insertQuery);

                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setDouble(3, salary);
                        ps1.setString(4, dept);

                        ps1.executeUpdate();
                        System.out.println("Employee Inserted Successfully");
                        break;

                    // READ
                    case 2:
                        String selectQuery = "SELECT * FROM employee";
                        PreparedStatement ps2 = con.prepareStatement(selectQuery);

                        ResultSet rs = ps2.executeQuery();

                        System.out.println("\n--- Employee Records ---");
                        while (rs.next()) {
                            System.out.println(
                                rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getDouble("salary") + " | " +
                                rs.getString("department")
                            );
                        }
                        break;

                    // UPDATE
                    case 3:
                        System.out.print("Enter Employee ID to Update: ");
                        int uid = sc.nextInt();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        String updateQuery = "UPDATE employee SET salary=? WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(updateQuery);

                        ps3.setDouble(1, newSalary);
                        ps3.setInt(2, uid);

                        int rowsUpdated = ps3.executeUpdate();
                        if (rowsUpdated > 0)
                            System.out.println("Employee Updated Successfully");
                        else
                            System.out.println("Employee Not Found");
                        break;

                    // DELETE
                    case 4:
                        System.out.print("Enter Employee ID to Delete: ");
                        int did = sc.nextInt();

                        String deleteQuery = "DELETE FROM employee WHERE id=?";
                        PreparedStatement ps4 = con.prepareStatement(deleteQuery);

                        ps4.setInt(1, did);

                        int rowsDeleted = ps4.executeUpdate();
                        if (rowsDeleted > 0)
                            System.out.println("Employee Deleted Successfully");
                        else
                            System.out.println("Employee Not Found");
                        break;

                    case 5:
                        System.out.println(" Exiting...");
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }

            } while (choice != 5);

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}

