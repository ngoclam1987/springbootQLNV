package com.example.QLNS.repository;

import com.example.QLNS.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    @Query(value = "SELECT * FROM qlns_test.account WHERE user_name = :userName", nativeQuery = true)
    AccountEntity findUserByUserName(@Param("userName") String userName);

}
