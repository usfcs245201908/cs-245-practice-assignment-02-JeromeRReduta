import java.util.*;

public class NQueensDemo {
    public static void main(String[] args) throws Exception{
        NQueens a = new NQueens(18);
        a.placeNQueens();
        a.printToConsole();
    }
}
