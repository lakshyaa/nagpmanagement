package com.nagarro.nagpmanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nagpmanagementapplication.entity.Levels;
import org.springframework.data.jpa.repository.Query;

public interface LevelRepository extends JpaRepository<Levels, Integer> {



}
