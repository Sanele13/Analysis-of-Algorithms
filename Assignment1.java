/*
   Name: Mpangalala Sanele
   Assignment 1
   10/03/214
*/

import java.util.*;
import java.io.*;

public class Assignment1{
	    public static void main(String []args) {
		 
		 //reading the contents of the .txt files
       LinkedList<String> SearchFor = new LinkedList<String>(); //linked list to store the toSearchFor list
		 LinkedList<String> SearchIn = new LinkedList<String>();  //linked list to store the toSearchIn list
		 
       //lengths of the two linked lists
       int lengthSearchFor=0;
		 int lengthSearchIn=0;                                    
		 
       Scanner file1=null;
		 Scanner file2=null;
  		 try{
           	file1=new Scanner (new File("toSearchFor.txt"));
      			          
					 while(file1.hasNext())
					 {
					 	
						String wordInSearchFor=file1.nextLine(); 
						SearchFor.add(wordInSearchFor); //add content to linked list
						lengthSearchFor++;		        //keeping track of the length of the list
					 }

                }
                catch(IOException o){}
		 try{
           	file2=new Scanner (new File("toSearchIn.txt"));
      			          
					 while(file2.hasNext())
					 {
					 	
						String wordInSearchIn=file2.nextLine();
						SearchIn.add(wordInSearchIn);
						lengthSearchIn++;		
					 }

                }
                catch(IOException o){}



		 String[] arrayA= new String[lengthSearchFor]; //initializing arrays
		 String[] arrayB= new String[lengthSearchIn];
		 SearchFor.toArray(arrayA); //changing the linked lists to arrays
		 SearchIn.toArray(arrayB);
		
		 SearchMethods searchMethod = new SearchMethods();
		 
		 //sequential search
       System.out.printf("Sequential search\n%-30s %10s %-5s %-5s %n", "Name", "Position", "Comparison", "Time (ms)" );
       
       int numComp=0;  //total number of comparisons
       long totalTime=0; //total time
       for(int i=0; i<lengthSearchFor; i++){	
		 	int comp1=0;
         
         long startTime = System.nanoTime();	  //start of the execution
			int pos = searchMethod.seqSearch(arrayA[i], arrayB);   //position of the name
			long endTime = System.nanoTime();     //end of the execution
			long duration = endTime-startTime;
         totalTime+=duration;  //updating total time
        
         comp1= searchMethod.compare-1;   //number of comparisons
         numComp+=comp1;               //updating total number of comparisons
			
         if (pos<0){
            System.out.printf("%-30s %-10d %-10d %10.2f %n", arrayA[i],(pos),comp1,duration/(double)1000000);}
         else{
            System.out.printf("%-30s %-10d %-10d %10.2f %n",arrayA[i],(pos+1),comp1,duration/(double)1000000);
         }

			}
         System.out.println("Total Comparisons to find mutual friends: "+numComp);
         System.out.printf("Total Time to find mutual friends:%.2f%n",totalTime/(double)1000000);
		
     
		//Binary search
      //code similar to the one above
       System.out.printf("\nBinary search\n%-30s %10s %-5s %-5s %n", "Name", "Position", "Comparison", "Time (ms)" ); 
       int numComp1=0;
       long totalTime1=0;
       for(int i=0; i<lengthSearchFor; i++){	
		 	int comp1=0;
         
         long startTime = System.nanoTime();	
			int pos = searchMethod.binSearch(arrayB, arrayA[i]);  //position of the name
			long endTime = System.nanoTime();
			long duration = endTime-startTime;
         totalTime1+=duration;
         comp1= searchMethod.compare-1;
         numComp1+=comp1;
           
         System.out.printf("%-30s %-10d %-10d %10.3f %n", arrayA[i],(pos),comp1,duration/(double)1000000);
         


			}
         System.out.println("Total Comparisons to find mutual friends: "+numComp1);
         System.out.printf("Total Time to find mutual friends:%.3f%n",totalTime1/(double)1000000);


}
}