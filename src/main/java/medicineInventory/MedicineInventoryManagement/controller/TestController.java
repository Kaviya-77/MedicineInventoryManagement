package medicineInventory.MedicineInventoryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import medicineInventory.MedicineInventoryManagement.service.NotificationService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/email")
    public String testEmail() {

        notificationService.notifyAdmins(
                "Test Notification",
                "This is a test email sent to all admins."
        );

        return "Emails sent to all admins!";
    }
}
