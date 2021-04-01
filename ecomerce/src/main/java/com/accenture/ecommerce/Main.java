package com.accenture.ecommerce;

import com.accenture.ecommerce.model.Usuario;
import com.accenture.ecommerce.service.CadastraUsuario;

public class Main {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Luan","18348298888","lufeo","teste123");


        CadastraUsuario.buscarTodos().forEach(x-> System.out.println(x));

    }
}
