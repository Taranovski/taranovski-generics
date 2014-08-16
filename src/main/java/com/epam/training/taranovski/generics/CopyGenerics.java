/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.training.taranovski.generics;

import java.util.Collection;

/**
 *
 * @author Alyx
 */
public class CopyGenerics {

    /**
     *
     * @param <T>
     * @param a
     * @param c
     */
    public <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for (T item : a) {
            c.add(item);
        }
    }
}
