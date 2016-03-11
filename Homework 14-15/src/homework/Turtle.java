package homework;

import java.util.Random;

/**
 * Created by Женя on 11.03.2016.
 */
public class Turtle {
    static int[][] field;
    static int n = 10;
    static int maxSum  = 0;
    public static void main(String[] args) {
        Random r =  new Random();
        field = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                field[i][j] = r.nextInt(100);
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        runTurtle(0,0,0);
        System.out.println(maxSum);
        runTurtleRoute(0,0,0);
    }

    public static void runTurtle(int x, int y, int sum){
        if(x < n - 1){
            runTurtle(x+1, y, sum + field[x][y]);
        }
        if(y < n - 1){
            runTurtle(x, y+1, sum + field[x][y]);
        }
        if(x == n - 1 && y ==  n - 1){
            if(maxSum < sum) {
                maxSum = sum;
            }
        }
    }

    public static int runTurtleRoute(int x, int y, int sum){
        if(x < n - 1){
            if(runTurtleRoute(x+1, y, sum + field[x][y]) == 1)
            {
                System.out.println("x " + field[x][y]);
                return 1;
            }
        }
        if(y < n - 1){
            if(runTurtleRoute(x, y+1, sum + field[x][y]) == 1)
            {
                System.out.println("y " + field[x][y]);
                return 1;
            }
        }
        if(maxSum == sum){
            return 1;
        }
        return 0;
    }
}
