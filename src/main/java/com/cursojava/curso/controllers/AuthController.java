package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
   private  JWTUtil jwtUtil;

    @PostMapping(value = "api/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogin = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogin !=  null) {
            String tokenJWT = jwtUtil.create(String.valueOf(usuarioLogin.getId()),usuarioLogin.getEmail());
            return tokenJWT;
        }

        return "FAIL";
    }
}