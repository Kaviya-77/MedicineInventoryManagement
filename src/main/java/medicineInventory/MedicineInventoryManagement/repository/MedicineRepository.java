package medicineInventory.MedicineInventoryManagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import medicineInventory.MedicineInventoryManagement.entities.Medicine;


public interface MedicineRepository extends JpaRepository<Medicine, Long> {}

