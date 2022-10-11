package edu.miu.cs590.accountservice.repo;

import edu.miu.cs590.accountservice.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser,Long> {
    AppUser findByEmail(String email);
}
