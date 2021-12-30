package com.example.restraunt.wishlists.repository;

import com.example.restraunt.db.MemoryDBRepoAbstract;
import com.example.restraunt.wishlists.entity.WishListsEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDBRepoAbstract<WishListsEntity> {

}
