package medicineInventory.MedicineInventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medicineInventory.MedicineInventoryManagement.entities.AppUser;
import medicineInventory.MedicineInventoryManagement.repository.UserRepository;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public void notifyAdmins(String subject, String message) {

        List<AppUser> admins = userRepository.findByRole("ROLE_ADMIN");

        for (AppUser admin : admins) {
            emailService.sendEmail(
                    admin.getEmail(),
                    subject,
                    message
            );
        }
    }
}
