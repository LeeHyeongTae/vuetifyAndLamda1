package com.lamda.web.proxy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.function.Function;

@Component @Lazy
public class Inventory<T> {
    private ArrayList<T> inventory;
    //add, get, list, clear, size, newInventory
    public Inventory(){inventory = new ArrayList<>();}
    public void add(T t){inventory.add(t);}
    public ArrayList<T> get(){return inventory;}
    public T get(int i){
       Function<Integer, T> g =  inventory::get;
       return g.apply(i);
    }
    public int size(){return inventory.size();}
    public void clear(){inventory.clear();}
    public void newInventory(){inventory = new ArrayList<T>();}
}
