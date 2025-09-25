package br.com.senai.urbanswift.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String senha;
}


