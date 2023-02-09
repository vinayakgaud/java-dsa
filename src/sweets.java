import java.util.Arrays;

public class sweets {
    public static void main(String[] args) {
        int[] entry = {1,2,10,5,5};
        int[] exit = {4,5,12,9,12};
        int n = 5;
        System.out.println(Arrays.toString(findMaxGuests(entry, exit, n)));
    }
    public static int[] findMaxGuests(int[] Entry, int Exit[], int N){
 	    int[] ans = new int[2];
         // push code here.
         Arrays.sort(Entry);
         Arrays.sort(Exit);
         int maxGuest = 1;
         int guestIn = 1;
         int time = Entry[0];
         int i = 1;
         int j = 0;
         while(i < N && j < N){
             if(Entry[i] <= Exit[j]){
                 guestIn++;
                 if(maxGuest < guestIn){
                     maxGuest = guestIn;
                     time = Entry[i];
                 }
                 i++;
             }else{
                 guestIn--;
                 j++;
             }
         }
         ans[0] = maxGuest;
         ans[1] = time;
         return ans;
 	}
    public static int[] findMaxGuestsS(int[] Entry, int[] Exit, int N){
        int[] ans = new int[2];

        int min = Math.min(min(Entry),min(Exit));
        int max = Math.max(max(Entry),max(Exit));
        int maxCount = 0;
        for(int i = min;i<=max;i++){
            int count = 0;
            for(int j = 0;j<N;j++){
                if(i >= Entry[j] && i <= Exit[j]){
                    count++;
                }
            }
            if(maxCount < count){
                maxCount = count;
                ans[0] = maxCount;
                ans[1] = i;
            }
        }

        return ans;
    }
    static int min(int[] arr){
        return Arrays.stream(arr).min().getAsInt();
    }
    static int max(int[] arr){
        return Arrays.stream(arr).max().getAsInt();
    }
}
