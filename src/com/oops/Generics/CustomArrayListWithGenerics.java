package com.oops.Generics;

public class CustomArrayListWithGenerics<GenericType> {
    private static final int DEFAULT_SIZE = 10;
    private static int size = 0;
    private Object[] arr;

    public CustomArrayListWithGenerics() {
        this.arr = new Object[DEFAULT_SIZE];
    }

    public CustomArrayListWithGenerics(int size){
        this.arr = new Object[size];
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
    public void add(GenericType data){
        if(this.isFull()) this.resize();
        arr[size++] = data;
    }

    private void resize() {
        Object[] newArr = new Object[DEFAULT_SIZE * 2];
        for(int i = 0;i<this.arr.length;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    private boolean isFull() {
        return size == this.arr.length;
    }

    public int sizeOfList(){
        return size;
    }
    public GenericType get(int index){
        if(index < size) return (GenericType) arr[index];
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public int getIndex(GenericType value){
        for(int i = 0;i< size;i++){
            if(arr[i] == value) return i;
        }
        return -1;
    }
    public void remove(GenericType value){
        if(size == 0) {
            System.out.println("No more element is present");
            return;
        }
        int index = getIndex(value);
        if(size > 0 && index == -1) {
            System.out.println("Element not found");
        }else if(size > 0){
            while(index <= size-1){
                arr[index] = arr[index+1];
                index++;
            }
            size = size - 1;
        }
    }
    public void set(int index, GenericType value){
        arr[index] = value;
    }
}
