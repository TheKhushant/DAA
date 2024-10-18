//use sorted elements list
//following program has runed properly
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
public class binary {
   
    public static int binarySearch(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (right - left) / 2;  // Corrected calculation
            System.out.print(" mid : " + mid + " ");

            if (arr.get(mid) == target) {
                System.out.println(" mid found = " + mid);
                return mid;
            }
            if (arr.get(mid) < target) {
                left = mid + 1;
                System.out.println(" left : " + left);
            } else {
                right = mid - 1;
                System.out.println(" right : " + right);
            }
        }
        return -55;
    }

    public static void main(String[] args) {  // Corrected parameter name
        
        String sortedNumFile = "randomeRepeaetd.txt";  // Ensure this file exists
        
        try {
            ArrayList<Integer> noList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(sortedNumFile));
            Scanner sc = new Scanner(System.in);
            System.out.println("enter value to search : ");
            int target = sc.nextInt();
            // int target = 90445;
            String line;

            while ((line = reader.readLine()) != null) {
                noList.add(Integer.parseInt(line.trim()));
            }
            reader.close();
            int result = binarySearch(noList, target);
            if (result == -55) {
                System.out.println("Number " + target + " not found in the file.");
            } else {
                System.out.println("Number " + target + " found at index " + result + " in the file.");  // Fixed output message
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");  // Fixed typo
            e.printStackTrace();
        }
    }
}

//with time  comp
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class binary {
   
    public static int binarySearch(ArrayList<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = (right + left) / 2;  // Corrected calculation
            // System.out.print(" mid : " + mid + " ");

            if (arr.get(mid) == target) {
                // System.out.println(" mid found = " + mid);
                return mid;
            }
            if (arr.get(mid) < target) {
                left = mid + 1;
                // System.out.println(" left : " + left);
            } else {
                right = mid - 1;
                // System.out.println(" right : " + right);
            }
        }
        return -55;
    }

    public static void main(String[] args) {  // Corrected parameter name
        long startTime = System.currentTimeMillis();
        String sortedNumFile = "sortedNumber.txt";  // Ensure this file exists
        
        try {
            ArrayList<Integer> noList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(sortedNumFile));
            Scanner sc = new Scanner(System.in);
            System.out.println("enter value to search : ");
            int target = sc.nextInt();
            // int target = 90445;
            String line;

            while ((line = reader.readLine()) != null) {
                noList.add(Integer.parseInt(line.trim()));
            }
            reader.close();
            int result = binarySearch(noList, target);
            if (result == -55) {
                System.out.println("Number " + target + " not found in the file.");
            } else {
                System.out.println("Number " + target + " found at index " + result + " in the file.");  // Fixed output message
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");  // Fixed typo
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long TotalTime = endTime - startTime;
        System.out.println("Start time : " + startTime + "\nEnd Time : " + endTime + "\nTOTAL TIME : " + TotalTime);
    }
}




