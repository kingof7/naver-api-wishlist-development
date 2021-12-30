package com.example.restraunt.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDBRepoIfs<T> {

    Optional<T> findById(int index);
    T save(T entity);
    void deleteById(int index);
    List<T> listAll();

}