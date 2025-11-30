package medicineInventory.MedicineInventoryManagement.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String batchNumber;
    private String expiryDate;
    private double price;
    private int quantity;
}

