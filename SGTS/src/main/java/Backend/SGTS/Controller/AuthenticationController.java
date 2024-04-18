package Backend.SGTS.Controller;

import Backend.SGTS.Service.UserDetailServiceImpl;
import Backend.SGTS.security.AuthCreateUserRequest;
import Backend.SGTS.security.AuthLoginRequest;
import Backend.SGTS.security.AuthResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/auth")
    public class AuthenticationController {

        @Autowired
        private UserDetailServiceImpl userDetailService;

        @PostMapping("/registro")
        public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest userRequest){
            return new ResponseEntity<>(this.userDetailService.createUser(userRequest), HttpStatus.CREATED);
        }

        @PostMapping("/login")
        public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){
            return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
        }
    }

