package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;

@RestController
public class UserController {
    private List<UserModel> users = new ArrayList<>();

    @PostMapping("/add_user")
    public String adicionarUsuario(@RequestBody UserModel user) {
        users.add(user);
        return "Usuario Cadastrado com sucesso";
    }

    @GetMapping("/listar-user")
    public List<UserModel> ListarUsuarios() {
        return users;
    }

    @PutMapping("/atualizar")
    public String AtualizarUsuario(@RequestBody UserModel user) {
        for (UserModel u : users) {
            if (u.nome.equals(user.nome)) {
                u.descricao = user.descricao;
                u.preco = user.preco;
                u.categoria = user.categoria;
            }
        }
        return "Usuario Atualizado";
    }

    @DeleteMapping("/deletar/{nome}")
    public String DeletarUsuario(@PathVariable("nome") String nome) {
        for (UserModel u : users) {
            if (u.nome.equals(nome)) {
                users.remove(u);
            }
        }
        return "Usuario Deletado";
    }
}
