/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the t44mplate in the editor.
 */
package polynomial;

/**
 *
 * @author Usama Sheikh
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
 static int arr[][] = new int[0][0];
  static int[] lenArr=new int[0];
    static int[] Arr=new int[0];
      static int[] Arr1=new int[0];
       static Polynomial poly;
        static Polynomial poly1;
       
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
     openfile();   
    }
        
        
        public static void openfile(){
         File file = new File("file11.txt");
         Scanner reader = null;

    try {
         reader = new Scanner(file);
         String str=reader.nextLine();
         int NumOfArrays=Integer.parseInt(str);
        
        //Array to Store Length of Each Array
     lenArr=new int[NumOfArrays];
        
        //2D Array to store Data
         int arr[][] = new int[NumOfArrays][];
        
        
        for (int i=0;reader.hasNextLine() && i<NumOfArrays;i++){
            str=reader.nextLine();
         
            String[] str1 = str.split(",|\\ "); //Space Delimator to delimate the last char of first array
            if(i==0){
            lenArr[i]=str1.length;
            int size=Integer.parseInt(str1[0])+1;
           
            arr[i]=new int[size];
            Arr=new int[size];
            
            for(int j=0;j<size;j++){
              
                Arr[j]=Integer.parseInt(str1[j+1]);
                
            }
          
           for(int j=0;j<size;j++){
               
               System.out.println(Arr[j]);

            }
             int [] Arr3=new int[Arr.length];
             
             
             for(int s=Arr.length-1,j=0;s>=0;s--){
              Arr3[j]=Arr[s];  
              j++;
             }
           int n=size-1;
            Polynomial poly11 = new Polynomial(n,Arr3 );
            poly=poly11;
           System.out.println(poly);
           
            }
           else if(i==1)
            { int size2=Integer.parseInt(str1[0])+1;
              System.out.println(size2);
                  
                Arr1=new int[size2];
             for(int j=0;j<size2;j++){
              //  arr[i][j]=Integer.parseInt(str1[j]);
                Arr1[j]=Integer.parseInt(str1[j+1]);
                
            }
              
             for(int j=0;j<size2;j++){
               
               System.out.println(Arr1[j]);
                
            }
              int n1=Arr1.length-1;
              
              int [] Arr2=new int[Arr1.length];
             
             
             for(int s=Arr1.length-1,j=0;s>=0;s--){
              Arr2[j]=Arr1[s];  
              j++;
             }
            Polynomial poly12 = new Polynomial(n1,Arr2 );
            poly1=poly12;
          
            System.out.println(poly12);
          
        }
           
        }
        
        
        reader.close();
        
  
 
  
        }
        catch(FileNotFoundException f){
            System.out.print("ERROR!!"+ f +"File Could Not be Found in Current Directory.");
        }
        
         
         

            
                
                  System.out.println("choose 1 option");
        Polynomial poly2=poly.plus(poly1);
        System.out.println(poly2);
    }
    
}

