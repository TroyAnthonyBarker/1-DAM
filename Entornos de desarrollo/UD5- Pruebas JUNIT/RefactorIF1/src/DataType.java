import java.util.ArrayList;
import java.util.List;

public class DataType {
    public static void main(String[] args) {
        System.out.println(DataType.gd(20));
        System.out.println(DataType.gd(702));
        System.out.println(DataType.gd(0));
    }
    public static String gd(int code){
        int[] codeDate = {702, 1082, 1083, 1114, 1184, 1266, 12403};
        int[] codeNumeric = {20, 21, 23, 24, 26, 700, 701, 790, 1700, 2202, 2203, 2204, 2205,
        2206, 3734, 3769,12396};

        for (int codeToCompare : codeDate){
            if (code == codeToCompare){
                return "DATE";
            }
        }
        for (int codeToCompare : codeNumeric){
            if (code == codeToCompare){
                return "NUMERIC";
            }
        }
        return "STRING";
    }
}
