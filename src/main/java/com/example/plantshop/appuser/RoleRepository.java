package com.example.plantshop.appuser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleOfUser,Long> {
    RoleOfUser findByName(String name);

}
