package com.example.restraunt.wishlists.repository;

import com.example.restraunt.wishlists.entity.WishListsEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListsRepositoryTest {

    @Autowired
    private WishListRepository wishListsRepository;

    private WishListsEntity create(){
        var wishList = new WishListsEntity();
        wishList.setTitle("title");
        wishList.setCategory("category");
        wishList.setAddress("address");
        wishList.setReadAddress("readAddress");
        wishList.setHomePageLink("");
        wishList.setImageLink("");
        wishList.setVisit(false);
        wishList.setVisitCount(0);
        wishList.setLastVisitDate(null);

        return wishList;
    }

    @Test
    public void saveTest(){

    }

    @Test
    public void findByIdTest(){

    }

    @Test
    public void deleteTest(){

    }

    @Test
    public void listAllTest(){

    }

}
