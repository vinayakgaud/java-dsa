import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class gfg {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int n = 5;
        int s = 12;
        System.out.println(subarraySum(arr,n,s));
    }
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int curSum = 0;
        int i = 0;
        while(i < n){
            curSum += arr[i];
            if(map.containsKey(curSum-s)){
                return new ArrayList<Integer>(Arrays.asList(map.get(curSum-s)+1,i+1));
            }
            map.put(curSum,i+1);
            i++;
        }
        return new ArrayList<Integer>(Arrays.asList(-1,-1));
    }
}
