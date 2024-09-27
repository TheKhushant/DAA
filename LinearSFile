//linear search in file ,i use buffered reader 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinearSearchInFile {

    public static void main(String[] args) {
        String fileName = "oneLakh.txt"; // data wali file
        int target = 50255; //  search this

        
        try {   
            // Read the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                // Split the line into numbers
                String[] numbers = line.split("\\s+");

                // Perform linear search
                for (String numStr : numbers) {
                    if (!numStr.isEmpty()) { // Check if the string is not empty
                    int num = Integer.parseInt(numStr);
                    if (num == target) {
                        found = true;
                        break;
                    }
                }
                }

                if (found) {
                    break;
                }
            }

            reader.close();

            if (found) {
                System.out.println("Number " + target + " found in the file.");
            } else {
                System.out.println("Number " + target + " not found in the file.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file.");
            e.printStackTrace();
        }
    }
}
