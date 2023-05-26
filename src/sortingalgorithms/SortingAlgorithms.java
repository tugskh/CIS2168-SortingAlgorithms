/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingalgorithms;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tugsbilegkhaliunbat
 */
public class SortingAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static File output = new File("output.csv");
    
    public static void insertionSort(int[] A) throws IOException{
        FileWriter fw = new FileWriter(output);
        int comparisons = 0;
        int exchanges = 0;
        long startTime = System.nanoTime();
        for (int n = 0; n < A.length; n++) {
            //System.out.print(A[n]+", ");
        }
        //System.out.println("");
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                for (int n = 0; n < A.length; n++) {
                    //System.out.print(A[n]+", ");
                }
                //System.out.println("");
                j = j - 1;
                comparisons++;
                exchanges++;
            }
            A[j + 1] = value;
            exchanges++;
            for (int n = 0; n < A.length; n++) {
                //System.out.print(A[n]+", ");
            }
            //System.out.println("");
            
        }
        long estimatedTime = System.nanoTime() - startTime;
        
        StringBuilder sb = new StringBuilder();
        sb.append("Insertion Sort\n, Number of comparisons performed:,").append(comparisons).append("\n, Number of exchanges performed:,").append(exchanges).append("\n, Estimated time in nanoseconds:,").append(estimatedTime);
        
        fw.write(sb.toString());
        fw.close();
    }
    
    public static <Integer extends Comparable<? super Integer>> List<Integer> quickSort(List<Integer> arr) {
        int comparisons = 0;
        int exchanges = 0;
        long startTime = System.nanoTime();
        if (arr.isEmpty())
            return arr;
        else {
            Integer pivot = arr.get(0);

            List<Integer> less = new LinkedList<>();
            List<Integer> pivotList = new LinkedList<>();
            List<Integer> more = new LinkedList<>();

            // Partition
            for (Integer i: arr) {
                if (i.compareTo(pivot) < 0){
                    less.add(i);
                }
                else if (i.compareTo(pivot) > 0){
                    more.add(i);
                }
                else{
                    pivotList.add(i);
                }
                comparisons++;
                exchanges++;
                
            }
            System.out.println(pivotList.toString());
            System.out.println(less.toString());
            System.out.println(more.toString());

            // Recursively sort sublists
            less = quickSort(less);
            more = quickSort(more);

            // Concatenate results
            less.addAll(pivotList);
            less.addAll(more);
            return less;
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        
        int[] list = {7,6,9,24,3,47,98,13,55,73,64,58,29,40,52,37,77,43,97,62,26,81,19,23,51,21,78,45,17,25,67,49};
        //insertionSort(list);
        List<Integer> l = new LinkedList<>();
        for(int i : list){
            l.add(i);
        }
        //quickSort(l);
        System.out.println(l.toString());
        System.out.println(quickSort(l));
        for (int n = 0; n < list.length; n++) {
            //System.out.print(list[n]+", ");
        }
        System.out.println("");
    }
    
}
