import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NameToFile {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String filename = "names.txt";

    // Prompt the user to enter a name
    System.out.print("Enter a name to write to the file: ");
    String name = scanner.nextLine();

    // Write the name to the file
    try (FileWriter fw = new FileWriter(filename, true)) {
      fw.write(name + "\n");
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }

    // Prompt user to display the file contents
    System.out.print(
      "Enter 'y' to display the name or any other key to exit : "
    );
    String response = scanner.nextLine();

    if (response.equalsIgnoreCase("y")) {
      // Read and display the file contents
      try (
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr)
      ) {
        String line;
        System.out.println("Contents of the file:");
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
