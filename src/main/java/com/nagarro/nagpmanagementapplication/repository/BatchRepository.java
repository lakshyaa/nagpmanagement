package com.nagarro.nagpmanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nagpmanagementapplication.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer> {


}
