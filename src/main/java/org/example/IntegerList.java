package org.example;

import org.example.exceptions.InvalidIndexException;
import org.example.exceptions.NullItemException;

import java.util.Arrays;

public class IntegerList {
    int size;
    private Integer[] array;
    public IntegerList() {
        array = new Integer[10];
    }

    public IntegerList(int size) {
        array = new Integer[size];
    }

    public Integer add(Integer item) {

        return add(size,item);
    }

    public Integer add(int index, Integer item) {
        validateItem(item);
        validateIndex(index);
        if(size>array.length-1){
            grow();
        }
        if (index == size) {
            array[size++] = item;
            return item;
        }
        validateSize();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = array[index];
        if(index!=size){
            System.arraycopy(array,index+1,array,index,size-index);
        }
        size--;

        return item;
    }


    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    public int indexOf(Integer item) {
        validateItem(item);
        Integer[] tmpArr = Arrays.copyOf(array,array.length);
        ArrayService.sortInsertion(tmpArr);
        int min = 0;
        int max = tmpArr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.equals(tmpArr[mid])) {
                return mid;
            }

            if (item < tmpArr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;
//        for (int i = 0; i < size; i++) {
//            if (array[i].equals(item)) {
//                return i;
//            }
//        }
//        return -1;
    }

    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return array[index];
    }

    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }


    public Integer[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException("Элемент равен null");
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayFullException("Массив переполнен");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException("Некорректный индекс");
        }
    }
    private void grow(){
        int newLength = array.length+ array.length/2;
        array=Arrays.copyOf(array,newLength);
    }

    @Override
    public String toString() {
        return "IntegerList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
