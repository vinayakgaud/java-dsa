package com.recursion.stringsandarrays;

import java.util.*;
public class SubsequenceAndSubset {
    public static void main(String[] args) {
//        subSeq("","abcc");
//        ArrayList<String> r = new ArrayList<>();
//        subSeqA("","abcd",r);
//        System.out.println(r);
//        int l = 4;
//        ArrayList<String> r1 = new ArrayList<>();
//        for (int i = 0; i < r.size(); i++) {
//            String s = "ab";
//            if(r.get(i).length() == (l-2)) {
//                s += r.get(i);
//                r1.push(s);
//            }
//        }
//        System.out.println(r1);

//        System.out.println(subSeqAlt("","abc"));
        int[] arr = {1,2,3};
//        List<List<Integer>> res = new ArrayList<>();
//        res = subSet(arr);
//        System.out.println(res);
//        System.out.println(subSetDuplicate(arr));
        System.out.println(subSet(arr));
    }
    static void subSeq(String proc, String unproc){
        if(unproc.isEmpty()) {System.out.print(proc+" "); return;}
        char c = unproc.charAt(0);
        subSeq(proc + c, unproc.substring(1));
        subSeq(proc,unproc.substring(1));
//        subSeq(proc + (c + 0), unproc.substring(1)); //for ascii value
    }
    static ArrayList<String> subSeqA(String proc, String unproc, ArrayList<String> res){
        if(unproc.isEmpty()){
            res.add(proc);
            return res;
        }
        char c = unproc.charAt(0);
        subSeqA(proc + c, unproc.substring(1),res);
        subSeqA(proc,unproc.substring(1),res);
//        subSeqA(proc + (c + 0), unproc.substring(1),res); //for ascii value
        return res;
    }
    static ArrayList<String> subSeqAlt(String proc, String unproc){
        if(unproc.isEmpty()) {
            return new ArrayList<String>(Collections.singletonList(proc));
        }
        char c = unproc.charAt(0);
        ArrayList<String> left = subSeqAlt(proc + c, unproc.substring(1));
        ArrayList<String> right = subSeqAlt(proc,unproc.substring(1));
        left.addAll(right);
        return left;
    }


    static List<List<Integer>> subSet(int[] arr){
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for(int i : arr){ //loop for arr
            int sizeOfOuter = outerList.size();
            for(int j = 0;j<sizeOfOuter;j++){ //loop till number of list present in outerlist
                List<Integer> internalList = new ArrayList<>(outerList.get(j)); //creating copy of already present list
                internalList.add(i); //adding value ot copied list(current iterated value)
                outerList.add(internalList); //addign copied list to main list
            }
        }
        return outerList;
    }

    static List<List<Integer>> subSetDuplicate(int[] arr){
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int start;
        int end = 0;
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++){ //loop for arr
            start = 0;
            if(i > 0 && arr[i] == arr[i-1]){
                start = end + 1;
            }
            end = outerList.size()-1;
            int sizeOfOuter = outerList.size();
            for(int j = start;j<sizeOfOuter;j++){ //loop till number of list present in outerlist
                List<Integer> internalList = new ArrayList<>(outerList.get(j)); //creating copy of already present list
                internalList.add(arr[i]); //adding value ot copied list(current iterated value)
                outerList.add(internalList); //addign copied list to main list
            }
        }
        return outerList;
    }
}
