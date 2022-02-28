package com.zaitsava.springboot_touristsite.repository;

import com.zaitsava.springboot_touristsite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRespository extends JpaRepository<Role,Long> {
    public Role findByRole(String role);
}
