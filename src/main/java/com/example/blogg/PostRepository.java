package com.example.blogg;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<posts, Integer> {
}
