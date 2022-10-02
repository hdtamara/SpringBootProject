package com.cursojava.curso.controllers;


import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.util.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setApellido("Tamara");
        usuario.setNombre("Hernan");
        usuario.setEmail("hernan@correo.com");
        usuario.setTelefono("3004254252");
        return usuario;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        if(!validartoken(token)){
            return null;
        }

        return  usuarioDao.getUsuarios();
    }

    @PostMapping(value = "api/usuarios")
    public void registarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }

    private  boolean validartoken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;

    }

    @RequestMapping(value = "api/usuario1")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Tamara");
        usuario.setNombre("Hernan");
        usuario.setEmail("hernan@correo.com");
        usuario.setTelefono("3004254252");
        return usuario;
    }

    @DeleteMapping("api/usuarios/{id}")
    public void eliminar(@RequestHeader(value = "Authorization")String token,@PathVariable Long id){
        if(!validartoken(token)){
            return;
        }
       usuarioDao.eliminar(id);
    }


}
