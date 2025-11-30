package medicineInventory.MedicineInventoryManagement.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import medicineInventory.MedicineInventoryManagement.dto.UserDTO;
import medicineInventory.MedicineInventoryManagement.entities.AppUser;
import medicineInventory.MedicineInventoryManagement.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public AppUser registerUser(UserDTO dto){

        String role = dto.getRole().equalsIgnoreCase("ADMIN")
                ? "ROLE_ADMIN"
                : "ROLE_VIEWER";

        AppUser user = AppUser.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .role(role)
                .build();

        return repo.save(user);
    }

    public AppUser findByUsername(String username){
        return repo.findByUsername(username).orElseThrow();
    }
}

