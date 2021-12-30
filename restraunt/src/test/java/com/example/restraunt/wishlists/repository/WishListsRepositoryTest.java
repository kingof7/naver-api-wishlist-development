package com.example.restraunt.wishlists.repository;

import com.example.restraunt.wishlists.entity.WishListsEntity;
import org.junit.jupiter.api.Assertions;
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
        var wishListEntity = create();
        var expected = wishListsRepository.save(wishListEntity);

        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1, expected.getIndex()); // 첫번째 인덱스
        
    }

    @Test
    public void updateTest(){
        var wishListEntity = create();
        var expected = wishListsRepository.save(wishListEntity);

        expected.setTitle("update test");
        var saveEntity = wishListsRepository.save(expected); // save 함수를 썻더라도 업데이트를 했기 때문에 카운트가 1->2로 늘어나지 않도록

        Assertions.assertEquals("update test", saveEntity.getTitle()); // 첫번째 인덱스
        Assertions.assertEquals(1, wishListsRepository.listAll().size()); // 업데이트 확인
    }

    @Test
    public void findByIdTest(){
        var wishListEntity = create();
        wishListsRepository.save(wishListEntity);
        
        var expected = wishListsRepository.findById(1);
        
        Assertions.assertEquals(true, expected.isPresent()); // 값이 있는지 찾기
        Assertions.assertEquals(1, expected.get().getIndex()); // 위에 저장한 1이 찾아져야함
    }

    @Test
    public void deleteTest(){
        var wishListEntity = create(); // 저장
        wishListsRepository.save(wishListEntity);

        wishListsRepository.deleteById(1); // 삭제

        int count = wishListsRepository.listAll().size(); // 리스트 사이즈

        Assertions.assertEquals(0, count); // 확인
    }

    @Test
    public void listAllTest(){
        var wishListEntity1 = create(); // 저장
        wishListsRepository.save(wishListEntity1);

        var wishListEntity2 = create(); // 저장
        wishListsRepository.save(wishListEntity2);

        int count = wishListsRepository.listAll().size();

        Assertions.assertEquals(2, count); // 2개 저장되었는지 확인

    }

}
