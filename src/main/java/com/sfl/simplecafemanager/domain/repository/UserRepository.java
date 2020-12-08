package com.sfl.simplecafemanager.domain.repository;

import com.sfl.simplecafemanager.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.username = ?1 and u.password = ?2 ")
    User findUserByUsernameAndPassword(String username, String password);
}
