package lauragallace.BEW7D5p.controller;

import lauragallace.BEW7D5p.entities.User;
import lauragallace.BEW7D5p.exceptions.BadRequestException;
import lauragallace.BEW7D5p.payloads.UserLoginDTO;
import lauragallace.BEW7D5p.payloads.UserLoginSuccessDTO;
import lauragallace.BEW7D5p.payloads.UserPostDTO;
import lauragallace.BEW7D5p.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserLoginSuccessDTO login(@RequestBody @Validated UserLoginDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            return new UserLoginSuccessDTO(authService.authenticateUser(body));
        }
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public User saveUser(@RequestBody @Validated UserPostDTO body, BindingResult validation) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        } else {
            try {
                return authService.registerUser(body);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}