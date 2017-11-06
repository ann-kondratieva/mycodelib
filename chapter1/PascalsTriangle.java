package chapter1;

public class PascalsTriangle {

    public static void main(String[] args) {
        int n=10;
        int[][] array = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            array[i][0]=1;
            array[i][i]=1;
            if(i==0 || i==1)continue;
            for(int j=1; j<i;j++){
                array[i][j]=array[i-1][j-1]+array[i-1][j];
            }
        }

        for(int i=0; i<=n;i++){
            for(int j=0; j<n-i;j++) System.out.print(" ");
            for(int k=0; k<=i; k++){
                System.out.print(array[i][k]+" ");
            }
            System.out.println();
        }

    }
}
