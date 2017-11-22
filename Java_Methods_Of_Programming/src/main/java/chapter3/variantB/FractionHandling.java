package chapter3.variantB;

import java.util.Scanner;

/**
 * Class {@code Manager} contains methods which handle arrays that contain
 * {@code Student} elements
 * Определить класс {@code Fraction} в виде пары чисел m и n.
 * Объявить и инициализировать массив из k дробей, ввести/вывести
 * значения для массива дробей. Создать массив/список/множество объектов и пе-
 * редать его в метод, который изменяет каждый элемент массива с четным
 * индексом путем добавления следующего за ним элемента.
 * @author Ann Kondratieva
 */

public class FractionHandling {

    public static void main(String[] args) {
        Fraction[] fraction = new Fraction[3];
        Scanner scanner = new Scanner(System.in);
        int m,n;

        for(int i=0; i<fraction.length; i++){
            System.out.println("Ведите числитель: ");
            m = scanner.nextInt();
            System.out.println("Введите знаменатель: ");
            n = scanner.nextInt();
            fraction[i] = new Fraction(m,n);
        }

        printArray(fraction);
        System.out.println(addition(fraction));
        System.out.println(subtraction(fraction));
        System.out.println(multiplication(fraction));
        System.out.println(division(fraction));
        changeEven(fraction);
        printArray(fraction);




    }

    public static void printArray(Fraction[] fractions){
        for(int i=0; i<fractions.length; i++){
            System.out.println(fractions[i]+", ");
        }
    }

    public static Fraction addition(Fraction... fraction){
        int m=0,n=1;
        int t=1;
        for(int i=0; i<fraction.length; i++){
            for(int j=0; j<fraction.length; j++ ){
                if(j==i) continue;
                t*=fraction[j].getN();
            }
            m+=fraction[i].getM()*t;
            t=1;
        }

        for(int i=0; i<fraction.length; i++){
            n*=fraction[i].getN();
        }

        return new Fraction(m/gcd(m,n),n/gcd(m,n));
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    public static Fraction subtraction(Fraction[] fraction){
        int m=0,n=1;
        int t=1;
        for(int i=0; i<fraction.length; i++){
            for(int j=0; j<fraction.length; j++ ){
                if(j==i) continue;
                t*=fraction[j].getN();
            }
            if(i!=0) {
                m -= fraction[i].getM() * t;
            } else {
                m = fraction[i].getM() * t;
            }
            t=1;
        }

        for(int i=0; i<fraction.length; i++){
            n*=fraction[i].getN();
        }

        return new Fraction(m/gcd(m,n),n/gcd(m,n));
    }

    public static Fraction multiplication(Fraction[] fraction){
        int m=1,n=1;
        for(int i=0; i<fraction.length; i++){
            m*=fraction[i].getM();
            n*=fraction[i].getN();
        }

        return new Fraction(m/gcd(m,n),n/gcd(m,n));
    }

    public static Fraction division(Fraction[] fraction){
        int m=1,n=1;
        for(int i=0; i<fraction.length; i++){
            if(i!=0) {
                m *= fraction[i].getN();
                n *= fraction[i].getM();
            } else {
                m *= fraction[i].getM();
                n *= fraction[i].getN();
            }
        }

        return new Fraction(m/gcd(m,n),n/gcd(m,n));
    }

    public static void changeEven(Fraction[] fraction){
        for(int i=0; i<fraction.length-1; i++){
           if(i%2==0){
               fraction[i]=addition(fraction[i],fraction[i+1]);
           }
        }


    }




}