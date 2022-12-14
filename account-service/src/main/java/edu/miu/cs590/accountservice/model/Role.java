package edu.miu.cs590.accountservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Long Id;
    private String role;

}
