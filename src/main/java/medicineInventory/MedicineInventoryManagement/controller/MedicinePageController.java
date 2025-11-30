package medicineInventory.MedicineInventoryManagement.controller;


import lombok.RequiredArgsConstructor;
import medicineInventory.MedicineInventoryManagement.service.MedicineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MedicinePageController {

    private final MedicineService service;

    @GetMapping("/medicines")
    public String viewAll(Model model) {
        model.addAttribute("medicines", service.getAll());
        return "medicines";
    }
}

