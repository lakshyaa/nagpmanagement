package com.nagarro.nagpmanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nagpmanagementapplication.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
