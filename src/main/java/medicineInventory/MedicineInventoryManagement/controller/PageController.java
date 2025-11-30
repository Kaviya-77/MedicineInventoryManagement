package medicineInventory.MedicineInventoryManagement.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import medicineInventory.MedicineInventoryManagement.service.MedicineService;

@Controller
public class PageController {

    private final MedicineService medicineService;

    public PageController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("medicines", medicineService.getAll());
        return "medicine-list";
    }
}
