package medicineInventory.MedicineInventoryManagement.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import medicineInventory.MedicineInventoryManagement.entities.Medicine;
import medicineInventory.MedicineInventoryManagement.repository.MedicineRepository;

@Service
@RequiredArgsConstructor
public class MedicineService {

    private final MedicineRepository repo;
    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private NotificationService notificationService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Medicine save(Medicine m){
        return repo.save(m);
    }

    public Medicine update(Long id, Medicine med){
        Medicine m = repo.findById(id).orElseThrow();
        m.setName(med.getName());
        m.setBatchNumber(med.getBatchNumber());
        m.setExpiryDate(med.getExpiryDate());
        m.setPrice(med.getPrice());
        m.setQuantity(med.getQuantity());
        return repo.save(m);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public List<Medicine> getAll(){
        return repo.findAll();
    }

    public Medicine get(Long id){
        return repo.findById(id).orElseThrow();
    }
    
    public Medicine updateMedicineStock(Long id, int newQuantity) {

        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine Not Found"));

        medicine.setQuantity(newQuantity);
        Medicine saved = medicineRepository.save(medicine);

        // 🔥 Low stock alert
        if (newQuantity < 10) {
            notificationService.notifyAdmins(
                    "Low Stock Alert - " + medicine.getName(),
                    "Medicine '" + medicine.getName() + "' stock is low.\n" +
                            "Current quantity: " + newQuantity + "\n" +
                            "Please restock immediately."
            );
        }

        return saved;
    }
    
    public Medicine updateMedicineExpiry(Long id, String newExpiryDate) {
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicine Not Found"));

        medicine.setExpiryDate(newExpiryDate);
        Medicine saved = medicineRepository.save(medicine);

        // Expiry alert: check if expiry date is within 1 month
        if (newExpiryDate != null && !newExpiryDate.isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate expiry = LocalDate.parse(newExpiryDate, formatter);
                LocalDate today = LocalDate.now();

                long daysToExpiry = ChronoUnit.DAYS.between(today, expiry);

                if (daysToExpiry <= 30 && daysToExpiry >= 0) {
                    notificationService.notifyAdmins(
                            "Expiry Alert - " + medicine.getName(),
                            "Medicine '" + medicine.getName() + "' is expiring soon!\n" +
                                    "Expiry Date: " + expiry + "\n" +
                                    "Please take necessary action."
                    );
                }
            } catch (Exception e) {
                System.out.println("Invalid expiry date format for medicine: " + medicine.getName());
            }
        }

        return saved;
    }
 

}

