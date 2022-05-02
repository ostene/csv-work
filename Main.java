import java.io.*;
import java.util.*;
import java.nio.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception{
        Main obj = new Main();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Reg Number: ");
        String regNumber = sc.nextLine();

        Map<String, String> sts = obj.getData("Names.csv");
        Map<String, String> mks = obj.getData("Marks.csv");

        System.out.println("Names: " + sts.get(regNumber) + ", Marks: " + mks.get(regNumber) + " marks!");

    }

    public Map<String, String> getData(String fileName){
        Map<String, String> datas = new HashMap<>();

        String line = "";
        String splitBy = ",";

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null){
                String[] data = line.split(splitBy);
                datas.put(data[0], data[1]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return datas;
    }
}