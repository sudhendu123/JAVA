

package searching;

import java.util.HashMap;

public class TwoSumEqualToK {
    public int[] twoSumK(int[] A, int K) {
        if(A.length < 2) return null;
        int[] res = new int[2];
        // HashMap<value, index>;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                res[0] = map.get(A[i]) + 1;
                res[1] = i + 1;           
            }else{
                map.put(K - A[i], i);
            }
        }
        return res;
    }
}
