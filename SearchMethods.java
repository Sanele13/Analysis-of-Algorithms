/*
   Name: Mpangalala Sanele
   Assignment 1
   10/03/214
*/
import java.util.*;


public class SearchMethods{
public static int comp=0;  //number of comparisons for sequential search
public static int comp1=0; //number of comparisons for binary search
public static int compare=0;
public static int compare1=0;

//binary search
public static int binSearch(String[] a, String key) {
    int low = 0;
    int high = a.length -1;
    int mid;
    comp1=0;
    while (low <= high) {
      comp1++;
		mid = (low + high) / 2;   //finding the middle
      if (a[mid].compareTo(key)>0) {   //if key is less than mid key, only look at the right portion of the array
          high = mid - 1;
			comp1++;
      } else if (a[mid].compareTo(key)<0) { //if key is greater than mid key, only look at the left portion of the array
          low = mid + 1;
			 comp1++;
          
      } else {
    		 comp1++;      
			 compare = comp1;
          return mid+1;
      }
}    return -1;
}

//sequential search
public static int seqSearch(String name, String [] data){
   comp=0;
	for (int i=0; i<data.length; i++){
		comp++;
		if(data[i].equals(name)){
			comp++;
         compare=comp;
         return i;}
      if (data[i].compareTo(name)>0){ //need to stop looking if key is greater than word found
         comp++;
         compare=comp;
         return -1;}
	}
   return -1;  //not found
}

}
			