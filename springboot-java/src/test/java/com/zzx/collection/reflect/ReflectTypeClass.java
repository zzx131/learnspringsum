package com.zzx.collection.reflect;


/**
 * 泛型类
 * @param <Type>
 */
public class ReflectTypeClass<Type> {
    public Type object;

    /**
     * 泛型方法上定义数组
     * @param a
     * @param <T>
     * @return
     */
    <T> T[] toArray(T[] a){
        return a;
    }

    /**
     * 泛型方法
     * @param e
     * @param <E>
     */
    <E> void getE(E e){
        System.out.println("he he he ");
    }

    public Type get(){
        return object;
    }

    public void set(Type t){
       this.object = t;
    }
}
