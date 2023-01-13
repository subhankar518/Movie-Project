package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Details;

@Repository
public interface UserRepository extends JpaRepository<Details, Integer>
{
     Details getDetailsByEmail(String email);
     Details getDetailsById(int id);
     Long removeByEmail(String email);
     Details findById(int id);
     
}
