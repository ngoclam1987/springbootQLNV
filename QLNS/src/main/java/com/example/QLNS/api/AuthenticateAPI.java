package com.example.QLNS.api;

import com.example.QLNS.models.JwtRequest;
import com.example.QLNS.models.JwtResponse;
import com.example.QLNS.models.ServiceResult;
import com.example.QLNS.security.jwt.JwtUtility;
import com.example.QLNS.service.MyUserDetailsService;
import com.example.QLNS.service.impl.AccountService;
import com.example.QLNS.utils.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticateAPI {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String home() {
        return "Wellcome to jwt tutorial";
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getUsername(),
                        jwtRequest.getPassword()
                )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        if(userDetails == null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ServiceResult(StatusCodeConstant.ERROR,"Đăng nhập thất bại",null));
        }
        final String token = jwtUtility.generateToken(userDetails);
        JwtResponse jwtResponse =  new JwtResponse(token);
        Object result = jwtResponse;
        return ResponseEntity.status(HttpStatus.OK).body(new ServiceResult(StatusCodeConstant.SUCCESS,"Đăng nhập thành công",result));
    }
}
