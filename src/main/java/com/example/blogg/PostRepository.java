package com.example.blogg;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<posts, Integer> {
    List <posts> findAllByUserID (int userID);

}
