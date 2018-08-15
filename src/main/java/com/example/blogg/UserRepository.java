package com.example.blogg;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<users, Integer> {
}
