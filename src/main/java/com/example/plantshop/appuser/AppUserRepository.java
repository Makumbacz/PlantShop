package com.example.plantshop.appuser;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByFirstname(String firstName);

    AppUser findByEmail(String email);
}
