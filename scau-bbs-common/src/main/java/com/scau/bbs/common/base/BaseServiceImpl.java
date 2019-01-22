package com.scau.bbs.common.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lhr on 17-8-1.
 */
public class BaseServiceImpl<E extends JpaRepository,T> implements BaseService<T>{

    @Autowired
    protected E repository;


    public T findOne(int key) {
        return (T) repository.findOne(key);
    }


    public T save(T entity) {
        return (T) repository.save(entity);
    }


    public void delete(Object key) {
        repository.delete(key);
    }


    public List<T> findAll() {
       return repository.findAll();
    }


    public void deleteInBatch(Iterable<T> iterable) {
        repository.deleteInBatch(iterable);
    }


    public List<T> findAll(Iterable<Integer> iterable) {
        return repository.findAll(iterable);
    }


    public List<T> save(Iterable<T> iterable) {
        return repository.save(iterable);
    }


}
