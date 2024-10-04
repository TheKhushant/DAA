import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.*;

public class binary {
    public static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) - 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            if (arr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String agrs[]) {
        String sortedNumFile = "lakhLine.txt";
        int target = 69;
        try {
            List<Integer> noList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(sortedNumFile));

            String line;

            while ((line = reader.readLine()) != null) {
                noList.add(Integer.parseInt(line.trim()));
            }            reader.close();
            int result = binarySearch(noList, target);
            if (result == -1) {
                System.out.println("Number " + target + " not found in the file.");
            } else {
                System.out.println("Number " + target + "found at index " + result + " int the file.");
            }
        } catch (IOException e) {
            System.out.println("An error ocured while reading the file.");
            e.printStackTrace();
        }
    }
}
