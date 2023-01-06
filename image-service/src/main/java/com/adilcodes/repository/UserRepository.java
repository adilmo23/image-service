package com.adilcodes.repository;

import com.adilcodes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserNameAndPassword(String userName, String pwd);
}
