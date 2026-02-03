// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
class CountNoOccurance {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        int a[]={4,5,5,5,4,6,6,9,4};
        ArrayList<Integer> al=new ArrayList<Integer>();
       
        for(int i=0;i<a.length;i++)
        {
             int k=0;
           if(!al.contains(a[i]))
           {
               al.add(a[i]);
               k++;
               for(int j=i+1;j< a.length;j++)
               {
                   if(a[i]== a[j])
                   {
                       k++;
                   }
               }
                System.out.println(a[i]+"is found"+ k+"multiple times");
            
           }
          
        }
    }
}
