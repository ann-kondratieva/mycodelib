package chapter3.variantC;

import chapter3.variantB.Fraction;
import chapter3.variantB.FractionHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class {@code Line} describes a line y=k*x+b.
 * Определить класс {@code Line} на плоскости (в пространстве), параметры кото-
 * рой задаются с помощью Рациональной Дроби. Определить точки пересе-
 * чения прямой с осями координат. Определить координаты пересечения
 * двух прямых. Создать массив/список/множество объектов и определить
 * группы параллельных прямых.
 * @author Ann Kondratieva
 */

public class Line {

    Fraction k;
    Fraction b;

    public static void main(String[] args) {
        Line line = new Line(new Fraction(2,3),new Fraction(3,5));
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пересечение с ОХ:"+line.crossOX()[0]+" ,"+line.crossOX()[1]);
        System.out.println("Пересечение с ОY:" + line.crossOY()[0] + " ," + line.crossOY()[1]);

        System.out.println("Введите числитель для k: ");
        int m = scanner.nextInt();
        System.out.println("Введите знаменатель для b: ");
        int n = scanner.nextInt();

        System.out.println("Введите числитель для k: ");
        int p = scanner.nextInt();
        System.out.println("Введите знаменатель для b: ");
        int s = scanner.nextInt();

        Fraction[] cross = line.crossLine(new Line(new Fraction(m,n),new Fraction(p,s)));

        System.out.println("Пересечение с прямой: "+cross[0]+", "+cross[1]);

        Line[] lines = new Line[6];
        lines[0] = new Line(new Fraction(2,3),new Fraction(3,5));
        lines[1] = new Line(new Fraction(4,3),new Fraction(6,5));
        lines[2] = new Line(new Fraction(2,3),new Fraction(4,5));
        lines[3] = new Line(new Fraction(2,3),new Fraction(4,5));
        lines[4] = new Line(new Fraction(4,3),new Fraction(4,5));
        lines[5] = new Line(new Fraction(5,6),new Fraction(4,5));

        findParallel(lines);

    }

    public Line(Fraction k, Fraction b) {
        this.k = k;
        this.b = b;
    }

    public Line() {
    }

    public Fraction getK() {
        return k;
    }

    public void setK(Fraction k) {
        this.k = k;
    }

    public Fraction getB() {
        return b;
    }

    public void setB(Fraction b) {
        this.b = b;
    }

    public Fraction[] crossLine(Line line){
        Fraction[] point = new Fraction[2];

        point[0] = FractionHandling.division((FractionHandling.subtraction(line.getB(),this.getB())),
                (FractionHandling.subtraction(this.getK(),line.getK())));
        if(point[0]==null) {
            System.out.println("Прямые параллельны");
            return null;
        }
        point[1] = FractionHandling.addition(FractionHandling.multiplication(line.getK(),point[0]),line.getB());

        return point;

    }

    public Fraction[] crossOX(){
        Fraction[] point = new Fraction[2];

        Fraction x = FractionHandling.division(b,k);


            point[1] = new Fraction(0, 1);
            point[0] = new Fraction(-x.getM(), x.getN());



        return point;
    }

    public Fraction[] crossOY(){
        Fraction[] point = new Fraction[2];

        point[0] = new Fraction(0,1)  ;
        point[1] = b;

        return point;
    }

    public boolean isParallel(Line line ){
        boolean isParallel = false;

        if((this.getK().toString()).equals(line.getK().toString())){
            isParallel = true;
        }

        return isParallel;
    }

    public static void findParallel(Line...lines){
        boolean isFirst = true;
        List<Fraction> inputed = new ArrayList<>();
        System.out.println("Группы параллельных прямых: ");
        for(int i=0; i<lines.length; i++){
           if(!inputed.contains(lines[i].getK())) {
                for (int j = i + 1; j < lines.length; j++) {

                    if (lines[i].isParallel(lines[j])) {
                        if(isFirst) {
                            System.out.print((i + 1) + " && " + (j + 1) + " ");
                            inputed.add(lines[j].getK());
                            isFirst = false;
                        } else {
                            System.out.print(" && " + (j + 1) + " ");
                        }
                    }
                }
                System.out.println();
                isFirst = true;
            }

        }
    }
}