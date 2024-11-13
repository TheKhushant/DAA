import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertionSortTC {

    public static void main(String[] args) {
        String inputFileName = "uniquenum1.txt"; 
        String outputFileName = "Insertion_sort_output.txt"; 
        List<Integer> numbers = new ArrayList<>(); 
        long startTime = System.currentTimeMillis();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;

            
            while ((line = reader.readLine()) != null) {
                for (String numStr : line.split("\\s+")) {
                    if (!numStr.isEmpty()) {
                        numbers.add(Integer.parseInt(numStr));
                    }
                }
            }

            
            insertionSort(numbers);

            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
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
        System.out.println("Start Time : " + startTime + "\nStop Time : " + stopTime + "\nTotal Time (ms): " + totalTime);
    }

    
    private static void insertionSort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }
}

// previous program of insertion sort
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertionSortTC {

    public static void main(String[] args) {
        String inputFileName = "uniquenum1.txt"; // Input file
        String outputFileName = "Insertion_sort_output.txt"; // Output file
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

            // Sort the numbers using Insertion Sort
            insertionSort(numbers);

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
        long totalTime =  stopTime - startTime;
        System.out.println("Start Time : "+ startTime +"\nstop Time : " + stopTime + "\ntotal time : " + totalTime);
    }

    // Insertion Sort implementation
    private static void insertionSort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }
            arr.set(j + 1, key);
        }
    }
}
