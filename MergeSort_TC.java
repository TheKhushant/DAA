import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        String inputFileName = "uniquenum1.txt"; // Input file
        String outputFileName = "Merge_sort_output.txt"; // Output file
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

            // Sort the numbers using Merge Sort
            List<Integer> sortedNumbers = mergeSort(numbers);

            // Write the sorted numbers to output file
            try (FileWriter writer = new FileWriter(outputFileName)) {
                for (int num : sortedNumbers) {
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
        long totalTime =  stopTime - startTime;
        System.out.println("Start Time : "+ startTime +"\nstop Time : " + stopTime + "\ntotal time : " + totalTime);
    }

    // Merge Sort implementation
    private static List<Integer> mergeSort(List<Integer> arr) { 
        if (arr.size() <= 1) {
            return arr; // Base case
        }

        // Split the array into two halves
        int mid = arr.size() / 2;
        List<Integer> left = mergeSort(arr.subList(0, mid));
        List<Integer> right = mergeSort(arr.subList(mid, arr.size()));

        // Merge the sorted halves
        return merge(left, right);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge until one half is exhausted
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Add remaining elements (if any)
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }
}
