package com.nagarro.nagpmanagementapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nagpmanagementapplication.entity.Admin;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    @Query(value="select * from admin where name=:name and password=:password",nativeQuery = true)
    public Admin checkAdmin(String name,String password);

}
