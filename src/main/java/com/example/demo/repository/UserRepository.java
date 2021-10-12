package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository //todo overvej om det er for advance, reflection
@Transactional
public interface UserRepository extends JpaRepository<User, String> { //todo grimme quries med hibernate og quries, solid priciple

}
