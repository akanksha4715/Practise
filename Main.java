import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Candies sol = new Candies();
        int[] ratings = {1,0,2};
        // int[] cost = {3,4,5,1,2};
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        System.out.println(sol.candy(ratings));
    }
    
}
