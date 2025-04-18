package com.niladri.linkedin.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.niladri.linkedin.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value="SELECT * FROM t_linkedin_users WHERE email = ?1", nativeQuery=true)
    User findByEmail(String email);
  
}
