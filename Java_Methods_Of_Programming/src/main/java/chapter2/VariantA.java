package chapter2;

import java.util.Arrays;
import java.util.Scanner;
import chapter1.TaskB;

/**
 * Class {@code VariantA} contains methods which solve
 * tasks on arrays, loops, data types and so on
 *
 * @author Ann Kondratieva
 */

public class VariantA {

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many numbers do you want to input? ");
        n = scanner.nextInt();
        int mas[] = new int[n];
        System.out.println("Input numbers, please(not a number - to end): ");
        int i=0;
        while(scanner.hasNextInt()){
            mas[i]=scanner.nextInt();
            i++;
        }
        findTheShortestAndTheLongest(mas);
        System.out.println("Sorted array: ");
        TaskB.printArray(sortArrayByLength(mas));
        System.out.println();

        System.out.println("The number with min of diverse decimals is: "+mas[findIndexOfMin(
                fillDiverseArray(mas))]);

        System.out.println("A number of elements with only even decimals: "+numberOfElementsWithOnlyEvenDecimals(mas));
        System.out.println("A number of elements with the same number of even and odd decimals: "
                +numberOfElementsWithTheSameEvenAndOddDecimals(mas));

        int num = numberWithSortedDecimals(mas);

        if(num!=-1)System.out.println("The number with sorted decimals: "+numberWithSortedDecimals(mas));
        else System.out.println("There is not the number with sorted decimals");

        int m = polyndromNumber(mas);
        if(m!=0) System.out.println("Polyndrom: "+ polyndromNumber(mas));
        else System.out.println("There is not a polyndrom");





        TaskB.printArray(mas);
    }


    /**
     * Task: Среди чисел найти число-палиндром. Если таких чисел больше одного,
     * найти второе.
     * @param mas the reference object for array.
     * @return the second polyndrome if there is it; the first otherwise.
     */
    public static int polyndromNumber(int[] mas){
        int temp,n=0;
        int [] polynums =new int [2];
        boolean isItSecond=false;
        for (int i=0; i<mas.length; i++){
            int[] arr=new int [50], polyarr=new int [50];
            temp=mas[i];
            while(temp!=0){
                arr[n]=temp%10;
                temp/=10;
                n++;
            }

            int m=0;
            temp=mas[i];
            while(temp!=0){
                polyarr[m]=temp/(int)Math.pow(10,n-1);
                m++;
                if (temp/10==0)break;
                temp=temp%(int)Math.pow(10,n-1);
                n--;
            }
            n=0;
            if(Arrays.equals(arr,polyarr) && !isItSecond){
                polynums[0]=mas[i];
                isItSecond=true;
            } else if(Arrays.equals(arr,polyarr) && isItSecond){
                polynums[1]=mas[i];
                break;
            }


        }

        if(polynums[1]==0)return polynums[0];
        else return polynums[1];
    }

    /**
     * Task: Найти число, цифры в котором идут в строгом порядке возрастания. Если
     * таких чисел несколько, найти первое из них.
     * @param mas the reference object for array.
     * @return the number with sorted decimals if there is it; -1 otherwise.
     */
    public static int numberWithSortedDecimals(int[] mas){
        int num=-1;
        int prev,temp,cur;
        boolean isSorted=true;
        for(int i=0; i<mas.length; i++){
            temp=mas[i];
            while(temp!=0){
                cur=temp%10;
                temp/=10;
                prev=temp%10;
                if(prev>=cur){
                    isSorted=false;
                    break;
                }
            }
            if (isSorted){
                num=mas[i];
                break;
            }

            isSorted=true;

        }


        return num;
    }

    /**
     * Task: Найти количество чисел, содержащих только четные цифры.
     * @param mas the reference object for array.
     * @return the number of elements with only even decimals.
     */
    public static int numberOfElementsWithOnlyEvenDecimals(int[] mas){
        int num=0,temp;
        boolean allIsEden=true;
        for(int i=0;i<mas.length; i++){
            temp=mas[i];
            while(temp!=0){
                if((temp%10)%2!=0){
                    allIsEden=false;
                    break;
                }
                temp/=10;
            }
            if(allIsEden)num++;
            allIsEden=true;
        }

        return num;
    }

    /**
     * Task: Найти количество чисел с равным числом четных и нечетных цифр.
     * @param mas the reference object for array.
     * @return the number of elements with the same numbers of even and odd decimals.
     */
    public static int numberOfElementsWithTheSameEvenAndOddDecimals(int[] mas){
        int num=0,temp,even=0,odd=0;
        for(int i=0;i<mas.length; i++){
            temp=mas[i];
            while(temp!=0){
                if((temp%10)%2!=0){
                    odd++;
                }else even++;
                temp/=10;
            }
            if(odd==even)num++;
            odd=0;
            even=0;

        }

        return num;
    }

    /**
     * Task: Упорядочить и вывести числа в порядке возрастания (убывания) значений
     * их длины.
     * @param mas the reference object for array.
     * @return sorted array.
     */
    public static int[] sortArrayByLength(int[] mas){
        int[] lengthArr=fillTheLengthArray(mas);
        int [] sortedArray = new int[mas.length];
        for(int i=0; i<sortedArray.length; i++){
            sortedArray[i]=mas[findIndexOfMax(lengthArr)];
            lengthArr[findIndexOfMax(lengthArr)]=-1;
        }
        return sortedArray;

    }

    /**
     * Task: Найти число, в котором число различных цифр минимально. Если таких
     * чисел несколько, найти первое из них.
     * @param mas the reference object for array.
     * @return array which consists of numbers of diverse elements in each element of {@code mas}.
     */
    public static int[] fillDiverseArray(int mas[]){
        int m,temp,k,temp1,m1;
        boolean isFound=false;
        int[] diverseArray = new int[mas.length];
        for (int i=0; i<diverseArray.length;i++){
            temp=mas[i];
            k=0;
            do{
                m=temp%10;
                temp/=10;
                temp1=temp;
                while(temp1!=0){
                    m1=temp1%10;
                    temp1/=10;
                    if(m1==m){
                        isFound=true;
                    }
                }
                if(!isFound){
                    k++;
                }
                isFound=false;

            }while(temp!=0);
            diverseArray[i]=k;
        }


        return diverseArray;
    }


    /**
     * @param mas the reference object for array.
     * @return index of max element.
     */
    public static int findIndexOfMax(int[] mas){
        int maxLength=mas[0];
        int maxIndex=0;
        for(int i=0; i<mas.length;i++){
            if(mas[i]>maxLength){
                maxLength=mas[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    /**
     * @param mas the reference object for array.
     * @return index of min element.
     */
    public static int findIndexOfMin(int[] mas){
        int minLength=mas[0];
        int minIndex=0;
        for(int i=0; i<mas.length;i++){
            if(mas[i]<minLength){
                minLength=mas[i];
                minIndex=i;
            }
        }
        return minIndex;
    }


    /**
     * Task: Найти самое короткое и самое длинное число. Вывести найденные числа
     * и их длину.
     * @param mas the reference object for array.
     */
    public static void findTheShortestAndTheLongest(int mas[]){
        int[] lengthArr=fillTheLengthArray(mas);

        int maxIndex=findIndexOfMax(lengthArr),
                minIndex=findIndexOfMin(lengthArr);

        System.out.println("The longest number is: "+mas[maxIndex]+" Its length is: "+lengthArr[maxIndex]);
        System.out.println("The shortest number is: "+mas[minIndex]+" Its length is: "+lengthArr[minIndex]);

    }

    /**
     * @param mas the reference object for array.
     * @return array which consists of the lengths of each element of {@code mas}.
     */
    public static int[] fillTheLengthArray(int mas[]){
        int k,temp;
        int[] lengthArray=new int[mas.length];
        for(int i=0; i<mas.length; i++){
            k=0;
            temp=mas[i];

            do{
                temp/=10;
                k++;
            }while (temp!=0);
            lengthArray[i]=k;
        }
        return lengthArray;
    }


}