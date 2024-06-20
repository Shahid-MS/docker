import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Servers {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String filename = "servers.txt";

    // Prompt user to display the file contents
    System.out.print(
      "Enter 'y' to display the Servers or any other key to exit : "
    );
    String response = scanner.nextLine();

    if (response.equalsIgnoreCase("y")) {
      // Read and display the file contents
      try (
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr)
      ) {
        String line;
        System.out.println("Servers:");
        while ((line = br.readLine()) != null) {
          System.out.println(line);
        }
      } catch (IOException e) {
        System.out.println("An error occurred while reading the file.");
        e.printStackTrace();
      }
    }

    scanner.close();
  }
}
