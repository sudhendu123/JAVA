

package dynamicprogramming;

public class EditDistance {
    public int editDistance(String A, String B) {
        int[][] Table = new int[A.length() + 1][B.length() + 1];
        // Initialization
        for(int i = 0; i <= A.length(); i++)
            Table[i][0] = i;
        for(int i = 0; i <= B.length(); i++)
            Table[0][i] = i;
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    Table[i][j] = Table[i - 1][j - 1];
                }else{
                    Table[i][j] = 1 + Math.min(Table[i - 1][j - 1], Math.min(Table[i - 1][j], Table[i][j - 1]));
                }
            }
        }
        return Table[A.length()][B.length()];
    }
}
