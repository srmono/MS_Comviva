package com.itgurukul.saga.payment.repository;

import com.itgurukul.saga.payment.entity.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceRepository extends JpaRepository<UserBalance,Integer> {
}
