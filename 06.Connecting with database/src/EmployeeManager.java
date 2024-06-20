import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeManager {

  // JDBC URL, username, and password of MySQL server
  private static final String JDBC_URL =
    "jdbc:mysql://host.docker.internal/dockerMySql";
  private static final String JDBC_USER = "root";
  private static final String JDBC_PASSWORD = "root";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Connection conn = null;
    Statement stmt = null;

    try {
      // Connect to the MySQL database
      conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
      stmt = conn.createStatement();

      // Create employee table if not exists
      createEmployeeTable(stmt);

      // Main program loop
      boolean exit = false;
      while (!exit) {
        System.out.println("\n1. Add employee");
        System.out.println("2. Show all employees");
        System.out.println("3. Quit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
          case 1:
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();
            addEmployee(stmt, name);
            break;
          case 2:
            showEmployees(stmt);
            break;
          case 3:
            exit = true;
            break;
          default:
            System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            break;
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // Close resources
      try {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      scanner.close();
    }
  }

  private static void createEmployeeTable(Statement stmt) throws SQLException {
    String sql =
      "CREATE TABLE IF NOT EXISTS employee (" +
      "eid INT AUTO_INCREMENT PRIMARY KEY," +
      "name VARCHAR(100)" +
      ")";
    stmt.executeUpdate(sql);
  }

  private static void addEmployee(Statement stmt, String name)
    throws SQLException {
    String sql = "INSERT INTO employee (name) VALUES ('" + name + "')";
    stmt.executeUpdate(sql);
    System.out.println("Employee added successfully.");
  }

  private static void showEmployees(Statement stmt) throws SQLException {
    String sql = "SELECT * FROM employee";
    ResultSet rs = stmt.executeQuery(sql);
    System.out.println("\nEmployee List:");
    while (rs.next()) {
      int eid = rs.getInt("eid");
      String name = rs.getString("name");
      System.out.println("ID: " + eid + ", Name: " + name);
    }
    rs.close();
  }
}
