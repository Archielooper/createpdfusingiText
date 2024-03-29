package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.State;

@Repository
public interface StateRepository extends JpaRepository<State, Short> {

}
