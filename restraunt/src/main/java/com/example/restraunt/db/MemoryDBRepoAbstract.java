package com.example.restraunt.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

abstract public class MemoryDBRepoAbstract<T extends MemoryDBEntity> implements MemoryDBRepoIfs<T>{
    private final List<T> db = new ArrayList<>();
    private int index = 0;

    @Override
    public Optional<T> findById(int index){
        return db.stream().filter(it -> it.getIndex() == index).findFirst();
    }

    @Override
    public T save(T entity){
        var optionalEntity = db.stream().filter(it -> it.getIndex() == entity.getIndex()).findFirst();
        // db에 데이터가 없는 경우
        if(optionalEntity.isEmpty()){
            index++;
            entity.setIndex(index);
            db.add(entity);
            return entity;
        }

        // db에 이미 데이터가 있는경우
        else{
            var preIndex = optionalEntity.get().getIndex();
            entity.setIndex(preIndex);

            deleteById(preIndex); // 이전데이터삭제
            db.add(entity); //새로받을데이터 밀어넣음
            return entity;
        }
    }

    @Override
    public void deleteById(int index){
        var optionalEntity = db.stream().filter(it -> it.getIndex() == index).findFirst();
        if(optionalEntity.isPresent()){
            db.remove(optionalEntity.get());
        }
    }

    @Override
    public List<T> listAll(){
        return db;
    }
}
