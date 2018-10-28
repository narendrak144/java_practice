package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ThisTest {
   int intVar ;
   
   ThisTest(int intVar){
	   this.intVar = intVar;
	   System.out.println("its pointing to current Object -> "+this);
   }
   
   
   public static void main(String... strings) throws Exception{
	   ThisTest t = new ThisTest(8);
	   System.out.println("just creating new one -> "+t);
	   System.out.println(processfile());
   }
   
   
   public static String processfile() throws IOException{
	   try(BufferedReader br = new BufferedReader(new FileReader("E:\\workspace_home_base\\JavaPractic\\src\\main\\java\\com\\data.txt"))){
		   return br.readLine(); 
	   }
   }
}
