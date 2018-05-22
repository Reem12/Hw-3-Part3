/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;

/**
 *
 * @author reem
 */
import java.util.*;
import java.io.*;
import java.io.PrintStream;
import java.io.FileNotFoundException;

public class HW3 {

      public static String [] s2;
      private Scanner x;
      private Scanner y;

public void open(String file){
     try{
         x = new Scanner(new File(file));
     }
     catch(Exception e){
     System.out.println("Could not find file");
     }

}



// read file into String array
public String[] read(String file) {
String s = "";
while(x.hasNextLine()){
s = s + x.nextLine() +"~";
}
s2 = s.split("~");  // split by ~
       return s2;
}
public static String[] compareUs(String[] file1,String[] file2)
{
   // String[] diff = {};
   String[] diff = new String[file1.length];
for(int i =0;i<file1.length;i++)
{
 if(!file1[i].equals(file2[i]))
 {
    // System.out.println(file2[i]);
     diff[i] = ("Diffrence in Line " + (i+1) +": File1: [" + file1[i] + "] , File2: [" + file2[i] + "]");
 } 
}

return diff;
}

public static void main(String[] args) {
        
     HW3 r = new HW3();
     HW3 a = new HW3();
     r.open("1.txt");
     a.open("2.txt");
     String[] file1 = r.read("1.txt");
     String[] file2 = a.read("2.txt");
     
     String[] diff = compareUs(file1, file2);
     
     try{
     PrintStream myconsole=new PrintStream(new File("diff.txt"));
     System.setOut(myconsole);
     
     for (int i =0; i<diff.length;i++)
         if(diff[i]!=null)
            myconsole.println(diff[i]);
      }
     catch(FileNotFoundException fx){
     System.out.println(fx);
     }
     
    }}
    
    
    
    

