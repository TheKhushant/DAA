//program for randam with unique number in file handling
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashSet;
public class sortedno {
    public static void main(String[] args) {
        HashSet<Integer> huniq = new HashSet<Integer>();

        Scanner sc = new Scanner(System.in);
        int n,count=0,un;
        System.out.println("enter the size : ");
        n = sc.nextInt();
        sc.close();
        String fileName = "uniquenum1.txt";
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            for(int i=1;i<=n || count<=n;i++){
                un = (int) Math.floor(Math.random() * 100000) + 1;
                if(!(huniq.contains(un)))
                {
                    huniq.add(un);                      // to add random number in hashset 
                    writer.println(un + "\n");          //to print random number in file
                    count++;                            // increase file number
                }
            }
            System.out.println("Numbers from 1 to "+ n +" have been written to " + fileName);
        }
        catch(IOException e){
            System.err.println("An IOException occurred : " + e.getMessage());
        }
    }
}