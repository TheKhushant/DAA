//program for sorted in file handling
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class sortedno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("enter the size : ");
        n = sc.nextInt();
        sc.close();
        String fileName = "sortedNumber.txt";
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            for(int i=1;i<=n;i++){
                writer.println(i + "\n");                            // to print sequential number in file
            }
            System.out.println("Numbers from 1 to "+ n +" have been written to " + fileName);
        }
        catch(IOException e){
            System.err.println("An IOException occurred : " + e.getMessage());
        }
    }
}
