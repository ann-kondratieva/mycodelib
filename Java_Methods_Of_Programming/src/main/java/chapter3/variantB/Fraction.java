package chapter3.variantB;

public class Fraction {
    private int m;
    private int n;

    public Fraction(int m, int n) {
        this.m = m;
        if(n!=0){
            this.n = n;
        }
        else throw new ArithmeticException() ;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        if(m!=0 && m>0 && n>0) return m+"/"+n;
        else if (m==0) return "0";
        else if(m<0 && n<0) return Math.abs(m)+"/"+Math.abs(n);
        else return "-"+Math.abs(m)+"/"+Math.abs(n);
    }


}