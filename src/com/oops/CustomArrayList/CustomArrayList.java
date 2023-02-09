package com.oops.CustomArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArrayList {
    private static final int DEFAULT_SIZE = 10;
    private static int size = 0;
    private int[] arr;

    public CustomArrayList() {
        this.arr = new int[DEFAULT_SIZE];
    }

    public CustomArrayList(int size){
        this.arr = new int[size];
    }
    @Override
    public String toString(){
        if(arr == null){
            return "null";
        }
        if(size-1 == -1) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;i<size;i++){
            sb.append(arr[i]);
            if(i == size-1) {
                return sb.append("]").toString();
            }
            sb.append(", ");
        }
        return sb.toString();
    }
    public void add(int data){
        if(this.isFull()) this.resize();
        arr[size++] = data;
    }

    private void resize() {
        int[] newArr = new int[DEFAULT_SIZE * 2];
        for(int i = 0;i<this.arr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private boolean isFull() {
        return size == this.arr.length;
    }

    public int sizeOfArray(){
        return size;
    }
    public int get(int index){
        if(index < size) return arr[index];
        else return -1;
    }
    public int getIndex(int value){
        for(int i = 0;i< size;i++){
            if(arr[i] == value) return i;
        }
        return -1;
    }
    public void remove(int value){
        if(size == 0) {
            System.out.println("No more element is present");
            return;
        }
        else {
            size = size - 1;
        }
        int index = getIndex(value);
        if(size > 0 && index == -1) {
            System.out.println("Element not found");
        }else if(size > 0){
            while(index <= size-1){
                arr[index] = arr[index+1];
                index++;
            }
        }

    }
    public void set(int index, int value){
        arr[index] = value;
    }
}
