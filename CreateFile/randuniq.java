import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashSet;

public class randomeUniques {
    public static void main(String[] args) {
        HashSet<Integer> huniq = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        int n, count = 0, un;
        System.out.print("Enter the number of unique random numbers to generate: ");
        n = sc.nextInt();
        sc.close();

        String fileName = "uniquenum1.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            while (count < n) {  
                un = (int) Math.floor(Math.random() * 100000) + 1;
                if (!huniq.contains(un)) {
                    huniq.add(un);                     
                    writer.println(un);                
                    count++;                           
                }
            }
            System.out.println("Unique numbers written to " + fileName);
        } catch (IOException e) {
            System.err.println("An IOException occurred: " + e.getMessage());
        }
    }
}
