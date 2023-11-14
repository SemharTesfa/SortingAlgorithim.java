import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int myArray [] = {50, 100, 128, 500, 1000, 10000, 100000, 1000000};

        System.out.printf("| %-12s | %-15s | %14s |%n", "_________", "______________", "______________");
        System.out.printf("| %-12s | %-15s | %14s |%n", "ArraySize", "Sorting method", "Duration Time(ms)");
        System.out.printf("| %-12s | %-15s | %14s |%n", "---------", "--------------", "--------------");

        // Loop through different array sizes
        for (int i = 0; i < myArray.length; i++){
            int inputSize = myArray[i];

            // Fill the array with random values
            Random randomNum = new Random();
            int [] arrayA = new int [inputSize];
            for (int j = 0; j < arrayA.length; j++) arrayA[j] = randomNum.nextInt(10000);
            insertionSortRunTime(arrayA);
            mergeSortRunTime(arrayA);
            System.out.printf("| %-12s | %-15s | %14s |%n", "---------", "--------------", "-------------");

        }
    }
    /* This method sorts an array inputA, using InsertionSort algorithm.
    *  It takes a parameter [] inputA
    */
    public static void insertionSort(int[] inputA){
        for (int j = 1; j < inputA.length; j++){
            int keyValue = inputA[j];

            int i = j - 1;
            while(i >= 0 && inputA[i] > keyValue){
                inputA[i+1] = inputA[i];
                i--;
            }
            inputA[i+1]= keyValue;
        }
    }

    /* This method uses Recursive function to sort an array using mergeSort algorithm.
    * It takes a parameter [] inputA
    * calls Merge the sorted halves
    */
    public static void mergeSort(int[] inputA){
        if(inputA.length < 2){
            return;
        }
        int midOfA = (inputA.length)/2;
        int[] leftA = new int[midOfA];
        int[] rightA = new int[inputA.length- midOfA];
        for (int i = 0; i < midOfA; i++){
            leftA[i] = inputA[i];
        }
        for (int j = midOfA; j < inputA.length; j++){
            rightA[j-midOfA] = inputA[j];
        }
        mergeSort(leftA);
        mergeSort(rightA);
        merge(inputA, leftA, rightA);

    }

    /* This method merge two sorted sub-arrays into array [] inputA
     * It takes a parameter [] inputA, int[] leftA, int[] rightA
     * It calls Merge the sorted halves
     */
    public static void merge(int[] inputA, int[] leftA, int[] rightA){
        int i = 0, j = 0, k= 0;
        while(i < leftA.length && j < rightA.length ){
            if (leftA[i] <= rightA[j]){
                inputA[k] = leftA[i];
                i++;
            }
            else{
                inputA[k] = rightA[j];
                j++;
            }
            k++;
        }
        while(i < leftA.length){
            inputA[k] = leftA[i];
            i++;
            k++;
        }
        while(j < rightA.length){
            inputA[k] = rightA[j];
            j++;
            k++;
        }
    }

    /* This method measures the runtime of InsertionSort
    * It takes a parameter [] inputArray
    * returns long durationTime in ms
    */
    public static long insertionSortRunTime(int[] inputArray){
        long startTime = System.nanoTime();
        insertionSort(inputArray);
        long endTime = System.nanoTime();
        long durationTime = (endTime - startTime)/1000;
        System.out.printf("| %-12s | %-15s | %14s |%n", inputArray.length, "InsertionSort", durationTime);
        return durationTime;
    }
    /* This method measures the runtime of mergeSort algorithm
     * It takes a parameter [] inputArray
     * returns long durationTime in ms
     */
    public static long mergeSortRunTime(int[] inputArray){
        long startTime = System.nanoTime();
        mergeSort(inputArray);
        long endTime = System.nanoTime();
        long durationTime = (endTime - startTime)/1000;
        System.out.printf("| %-12s | %-15s | %14s |%n", inputArray.length, "MergeSort", durationTime);
        return durationTime;
    }
}
