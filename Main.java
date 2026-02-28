import java.util.List;
public class Main {

    public static void main(String[] args) {
        List<List<Integer>> arr = List.of(
            List.of(1,2, 3),
            List.of( 4, 5),
            List.of(6, 7, 8, 15),
            List.of(10,11,12,13),
            List.of(5, 10)
        );
        System.out.println(TopKEle.reorganizeString("aaabc"));
    }
    
}
