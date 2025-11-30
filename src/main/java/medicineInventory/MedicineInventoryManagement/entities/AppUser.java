package medicineInventory.MedicineInventoryManagement.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private String role;   // ROLE_ADMIN or ROLE_VIEWER

    @Column(unique = true)
    private String email;
}
