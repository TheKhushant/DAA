
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuickSortOneL { 

    public static void main(String[] args) {
        String inputFileName = "uniquenum1.txt"; // Input file
        String outputFileName = "sorted_output.txt"; // Output file
        List<Integer> numbers = new ArrayList<>(); // List to store numbers

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

            // Sort the numbers using QuickSort
            quickSort(numbers, 0, numbers.size() - 1);

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
    }

    // QuickSort implementation
    private static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
