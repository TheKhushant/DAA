import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LINEARSEARCH {
    public static void main(String[] agrs){
        String sortedNumFile = "sortedNumber.txt";
        int target = 150;
        long startTime = System.currentTimeMillis();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(sortedNumFile));
            String line;
            boolean found  = false;
            
            while((line = reader.readLine())!=null){
                String[] numbers = line.split("\\s+");

                //for linear search
                for(String numStr: numbers)
                {
                    if(!numStr.isEmpty()){
                        int num = Integer.parseInt(numStr);
                        if(num == target){
                            found = true;
                            break;
                        }
                    }
                }
                if(found){
                    break;
                }
            }
            reader.close();
        
        if(found){
            System.out.println("Number '"+ target + "' found in the file.");
        }
        else{
            System.out.println("number no found in the file"+ target);
        }
        }catch(IOException e){
            System.out.println("An error ocured while reading the file.");
            e.printStackTrace();
        }
        catch(NumberFormatException e){
            System.out.println("Error parsing number form file");
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("start time : " + startTime);
        System.out.println("end time : "+endTime);
        System.out.println("your total time : "+totalTime+" MiliSeconds");
    }
}
