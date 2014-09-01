/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.generics.fruits;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Alyx
 */
public class Fruits {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Fruit> fr = null;
        List<Apple> app = null;
        List<Orange> or = null;
        List<RedApple> rapp = null;
        List<Melon> mel = null;
        copyAll(or, fr);
        copyAll(rapp, fr);
        copyAll(rapp, app);
        copyAll(rapp, rapp);
        //copyAll(fr, or);
    }

    /**
     *
     * @param <T>
     * @param <V>
     * @param from
     * @param to
     */
    private static <T extends Fruit> void copyAll(List<T> from, List<? super T> to) {
        for (T item : from) {
            to.add(item);
        }
    }

    /**
     *
     * @param <T>
     * @param collection
     * @param geraterThan
     * @return
     */
    public static <T extends Fruit & Comparable<T>> Collection<T>
            getItemsGreaterThanSomething(Collection<T> collection, T geraterThan) {
        Collection<T> newCollection = new LinkedList<>();
        for (T collectionItem : collection) {
            if (collectionItem.compareTo(geraterThan) > 0) {
                newCollection.add(geraterThan);
            }
        }
        return newCollection;
    }
}

/**
 *
 * @author Alyx
 */
class Fruit {

    private String name = "fruit";

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

}

/**
 *
 * @author Alyx
 */
class Apple extends Fruit implements Comparable<Apple> {

    private String name = "apple";
    private int number;

    /**
     *
     * @param number
     */
    public Apple(int number) {
        this.number = number;
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Apple o) {
        return getNumber() - o.getNumber();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.number;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Apple other = (Apple) obj;
        return this.number == other.number;
    }

}

/**
 *
 * @author Alyx
 */
class RedApple extends Apple {

    private String name = "red apple";

    public RedApple(int number) {
        super(number);
    }

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }
}

/**
 *
 * @author Alyx
 */
class Orange extends Fruit {

    private String name = "orange";

    /**
     *
     * @return
     */
    @Override
    public String getName() {
        return name;
    }
}

/**
 *
 * @author Alyx
 */
class Melon {

    private String name = "melon";

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
