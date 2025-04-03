package com.desafio_picpay.desafio_picpay.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio_picpay.desafio_picpay.domain.dtos.UserDTO;
import com.desafio_picpay.desafio_picpay.domain.user.User;
import com.desafio_picpay.desafio_picpay.domain.user.UserType;
import com.desafio_picpay.desafio_picpay.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validadeTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuario do tipo lojista não está autorizado a realizar a transação");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Usuario não tem saldo o suficiente");
        }
    }

    public User findUserById(Long id) throws Exception {
        System.out.println(id);
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
