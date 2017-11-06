package chapter1;

import java.util.Scanner;

public class TaskB {

    static int[] array;


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Input number of elements");
        int number = s.nextInt();
        array = new int[number];
        for(int i=0; i<number;i++){
            array[i] = s.nextInt();
        }

        printThreedigitNumbersWhereDigitsAreDifferent(array);
        printArray(array);




    }

    static void sortArray(int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length-1; j++){
                if(Math.abs(array[j])<Math.abs(array[j+1])){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    public static void printArray( int[] array){
        for(int i=0; i<array.length; i++){
            if(i==array.length-1){
                System.out.print(array[i]+"; ");
            } else
            System.out.print(array[i]+", ");
        }
    }

    static void printThreedigitNumbersWhereDigitsAreDifferent(int[] array){
        int[] digits = new int[3];
        boolean isDifferent=true;
        for(int i=0; i<array.length; i++){
            if(array[i]>=100 && array[i]<=999){
                int temp=array[i];
                for(int j=0; j<digits.length;j++){
                    digits[j]=temp%10;
                    temp/=10;
                }
                for(int j=0; j<digits.length;j++){
                    for(int k=j+1; k<digits.length; k++){
                        if(digits[j]==digits[k]) isDifferent=false;
                    }
                }
                if(isDifferent) System.out.println(array[i]);
                isDifferent=true;
            }
        }
    }


}