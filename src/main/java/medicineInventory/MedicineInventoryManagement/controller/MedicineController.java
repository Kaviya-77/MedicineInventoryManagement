package medicineInventory.MedicineInventoryManagement.controller;


import lombok.RequiredArgsConstructor;
import medicineInventory.MedicineInventoryManagement.entities.Medicine;
import medicineInventory.MedicineInventoryManagement.service.MedicineService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/api/medicines")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService service;

    // LIST ALL
    @GetMapping
    public String list(Model model) {
        model.addAttribute("medicines", service.getAll());
        return "medicine-list";
    }

    // ADD PAGE
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "medicine-form";
    }

    // SAVE
    @PostMapping("/save")
    public String save(@ModelAttribute Medicine medicine) {
        service.save(medicine);
        return "redirect:/dashboard"; 
    }

    // EDIT PAGE
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("medicine", service.get(id));
        return "medicine-edit-form";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/dashboard";
    }

    //  UPDATE STOCK
    @PostMapping("/stock/{id}")
    public String updateStock(@PathVariable Long id,
                              @RequestParam int quantity) {
        service.updateMedicineStock(id, quantity);
        return "redirect:/dashboard";
    }

    //UPDATE EXPIRY
    @PostMapping("/expiry/{id}")
    public String updateExpiry(@PathVariable Long id,
                               @RequestParam String expiryDate) {
        service.updateMedicineExpiry(id, expiryDate);
        return "redirect:/dashboard";
    }
 //EDIT POST – update only name, price, batchNumber
    @PostMapping("/edit/{id}")
    public String updateMedicine(
            @PathVariable Long id,
            @ModelAttribute Medicine formMedicine) {

        // fetch the existing medicine
        Medicine existing = service.get(id);

        // update only the editable fields
        existing.setName(formMedicine.getName());
        existing.setPrice(formMedicine.getPrice());
        existing.setBatchNumber(formMedicine.getBatchNumber());

        // save updated medicine
        service.save(existing);

        return "redirect:/dashboard"; // go back to dashboard after edit
    }

 }
