import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {
        String inputFileName = "uniquenum1.txt"; // Input file
        String outputFileName = "Selection_sort_output.txt"; // Output file
        List<Integer> numbers = new ArrayList<>(); // List to store numbers
        long startTime = System.currentTimeMillis();

        try {
            // Read the file
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            String line;

            while ((line = reader.readLine()) != null) {
                // Split the line into numbers and add to the list
                for (String numStr : line.split("\\s+")) {
                    if (!numStr.isEmpty()) {
                        numbers.add(Integer.parseInt(numStr));
                    }
                }
            }
            reader.close();

            // Sort the numbers using Selection Sort
            selectionSort(numbers);

            // Write the sorted numbers to output file
            try (FileWriter writer = new FileWriter(outputFileName)) {
                for (int num : numbers) {
                    writer.write(num + " ");
                }
            }

            System.out.println("Numbers sorted and written to " + outputFileName);

        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing the file.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number from file.");
            e.printStackTrace();
        }

        long stopTime = System.currentTimeMillis();
        long totalTime = stopTime - startTime;
        System.out.println("Start Time: " + startTime + "\nStop Time: " + stopTime + "\nTotal Time: " + totalTime);
    }

    // Selection Sort implementation
    private static void selectionSort(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            int minIndex = i;
            // Find the index of the smallest element in the remaining unsorted array
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            if (minIndex != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIndex));
                arr.set(minIndex, temp);
            }
        }
    }
}
