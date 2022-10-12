package edu.miu.cs590.cloudgateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    private Long id;
    private String email;
    private String userName;
    private String password;
    private Boolean isActive;
    private List<Roles> roles = new ArrayList<>();
}
