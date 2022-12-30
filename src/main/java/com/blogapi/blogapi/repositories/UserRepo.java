package com.blogapi.blogapi.repositories;

import com.blogapi.blogapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


}
