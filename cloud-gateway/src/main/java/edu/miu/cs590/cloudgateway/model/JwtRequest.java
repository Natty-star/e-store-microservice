package edu.miu.cs590.cloudgateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String userName;
    private String password;
}
