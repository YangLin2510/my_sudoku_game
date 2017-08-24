package com.yang.lin.numberplace;

import java.util.ArrayList;
import java.util.List;

/**
 * 排列组合
 */
public class Permutation<T> {
    private List<T> objectArray;

    public Permutation(List<T> objects) {
        this.objectArray = objects;
    }

    public List<List<T>> permutation() {
        return permutation(objectArray,objectArray.size());
    }


    public List<List<T>> permutation(int c){
        return permutation(objectArray,c);
    }

    /**
     * 部分排列
     *
     * @param list
     * @param c
     * @return
     */

    private List<List<T>> permutation(List<T> list, int c) {
        List<List<T>> re = new ArrayList<List<T>>();
        if (c <= 0 || c > list.size()) {
            throw new IllegalArgumentException();
        }
        if(c==1){
            for(T t:list){
                List<T> r = new ArrayList<T>();
                r.add(t);
                re.add(r);
            }
            return re;
        }

        for (T t : list) {
            List<T> subList = new ArrayList<T>();
            subList.addAll(list);
            subList.remove(t);
            int nextX = c - 1;
            List<List<T>> perRes = permutation(subList, nextX);
            for (List<T> l : perRes) {
                l.add(0,t);
            }
            re.addAll(perRes);
        }
        return re;
    }
}
