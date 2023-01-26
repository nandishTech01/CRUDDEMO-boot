package com.anil.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.model.userModel;

@Repository
public interface userRepositary extends JpaRepository<userModel, Long> {

}
