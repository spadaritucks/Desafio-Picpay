package com.desafio_picpay.desafio_picpay.domain.dtos;

import java.math.BigDecimal;

import com.desafio_picpay.desafio_picpay.domain.user.UserType;



public record UserDTO(String firstName, String lastName, String document, BigDecimal balance, String email, String password, UserType userType) {

}
