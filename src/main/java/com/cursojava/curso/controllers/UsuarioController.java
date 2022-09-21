package com.cursojava.curso.controllers;


import com.cursojava.curso.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
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

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setApellido("Tamara");
        usuario.setNombre("Hernan");
        usuario.setEmail("hernan@correo.com");
        usuario.setTelefono("3004254252");
        usuarios.add(usuario);

        Usuario usuario3 = new Usuario();
        usuario3.setId(3);
        usuario3.setApellido("Lucas");
        usuario3.setNombre("Moy");
        usuario3.setEmail("lucas@correo.com");
        usuario3.setTelefono("3004254252");
        usuarios.add(usuario3);

        Usuario usuario2 = new Usuario();
        usuario2.setId(2);
        usuario2.setApellido("Juancho");
        usuario2.setNombre("Perez");
        usuario2.setEmail("Juancho@correo.com");
        usuario2.setTelefono("3004254252");
        usuarios.add(usuario2);
        return usuarios;
    }


    @RequestMapping(value = "usuario1")
    public Usuario editar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Tamara");
        usuario.setNombre("Hernan");
        usuario.setEmail("hernan@correo.com");
        usuario.setTelefono("3004254252");
        return usuario;
    }

    @RequestMapping(value = "usuario2")
    public Usuario eliminar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Tamara");
        usuario.setNombre("Hernan");
        usuario.setEmail("hernan@correo.com");
        usuario.setTelefono("3004254252");
        return usuario;
    }

    @RequestMapping(value = "usuario3")
    public Usuario buscar(){
        Usuario usuario = new Usuario();
        usuario.setApellido("Tamara");
        usuario.setNombre("Hernan");
        usuario.setEmail("hernan@correo.com");
        usuario.setTelefono("3004254252");
        return usuario;
    }
}
