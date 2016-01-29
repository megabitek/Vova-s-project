/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author vl
 */
public interface DAO<T> {
    void insert (T t);
    void delete (T t);
    List <T> getAll();
    void update (T t);
    T getById(int id);
    
    default int getnextID (){
    int size = getAll().size();
    return size+1;
    };
    
    
}
