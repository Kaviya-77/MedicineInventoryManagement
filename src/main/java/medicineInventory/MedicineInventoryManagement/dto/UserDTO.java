package medicineInventory.MedicineInventoryManagement.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String role; // ADMIN or VIEWER
}

