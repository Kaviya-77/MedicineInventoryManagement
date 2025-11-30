package medicineInventory.MedicineInventoryManagement.controller;


import lombok.RequiredArgsConstructor;
import medicineInventory.MedicineInventoryManagement.dto.UserDTO;
import medicineInventory.MedicineInventoryManagement.entities.AppUser;
import medicineInventory.MedicineInventoryManagement.repository.UserRepository;
import medicineInventory.MedicineInventoryManagement.security.JwtUtil;
import medicineInventory.MedicineInventoryManagement.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

//    private final AuthenticationManager authenticationManager;
//    private final UserService userService;
//    private final JwtUtil jwtUtil;
   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;
    
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
//        // Check if username already exists
//        if(userRepository.existsByUsername(userDTO.getUsername())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body("Error: Username '" + userDTO.getUsername() + "' is already taken!");
//        }
//
//        // You can also check for email uniqueness if needed
//        if(userRepository.existsByEmail(userDTO.getEmail())) {
//            return ResponseEntity
//                    .badRequest()
//                    .body("Error: Email '" + userDTO.getEmail() + "' is already in use!");
//        }
//
//        // Otherwise, create new user
//        AppUser user = new AppUser();
//        user.setUsername(userDTO.getUsername());
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//        user.setRole(userDTO.getRole());
//
//        userRepository.save(user);
//
//        return ResponseEntity.ok("User registered successfully!");
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody UserDTO dto) {
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
//        );
//
//        AppUser user = userService.findByUsername(dto.getUsername());
//        String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
//
//        return ResponseEntity.ok(token);
//    }
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password) {
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password)
//        );
//
//        return "redirect:/dashboard";
//    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDTO userDTO) {

        // ✅ block saving if username exists
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return "redirect:/register?error=username";
        }

        // ✅ block saving if email exists
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return "redirect:/register?error=email";
        }

        // ✅ SAVE ONLY IF NO ERRORS
        AppUser user = new AppUser();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole("ROLE_" + userDTO.getRole());

        userRepository.save(user);

        return "redirect:/login";
    }


}
