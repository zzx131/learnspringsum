package com.zzx.collection.reflect;

import org.junit.Test;

/**
 * 泛型类
 * @param <E>
 */
public class ReflectE<E>{
    public E obj;

    public void setObj(E e){
        this.obj = e;
    }

    public E getObj(){
        return obj;
    }

    /**
     * 泛型方法
     * @param e
     * @param <E>
     */
    public <E> void show(E e) {
        System.out.println(e);
    }

    @Test
    public void testReflectE(){
        ReflectE reflectE = new ReflectE();
        reflectE.show("hahaha");
    }

}
