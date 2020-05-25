

package stringalgorithms;

import java.util.ArrayList;

public class NumberCombinations {
    public ArrayList<ArrayList<Integer>> numberCombinations(int n, int k) {
        if(n < k)
            return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k == 1){
            for(int i = 1; i <= n; i++){
                ArrayList<Integer> arr = new ArrayList<Integer>();
                arr.add(i);
                res.add(arr);
            }
            return res;
        }
        for(int i = n; i>= k; i--){
            for(ArrayList<Integer> arr : numberCombinations(i - 1, k - 1)){
                arr.add(i);
                res.add(arr);
            }
        }
        return res;
    }
}
