package com.example.expense_tracker.repository;

import java.util.Optional;
import com.example.expense_tracker.model.Expense;
import com.example.expense_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(User user);
    Optional<Expense> findByIdAndUser(Long id, User user);

}