package medicineInventory.MedicineInventoryManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import medicineInventory.MedicineInventoryManagement.entities.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
    List<AppUser> findByRole(String role);   // <- IMPORTANT

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
   
}









