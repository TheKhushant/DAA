// program for random number in file handling
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class randomRepeted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("enter the size : ");
        n = sc.nextInt();
        sc.close();
        String fileName = "randomeRepeaetd.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 1; i <= n; i++) {
                writer.println((int) Math.floor(Math.random() * 100000) + 1);  //use for random numbers 
            }
            System.out.println("Numbers from 1 to 1,00,000 have been written to " + fileName);
        } catch (IOException e) {
            System.err.println("An IOException occurred : " + e.getMessage());
        }
    }
}
