package com.br.testes.controller;


import com.br.testes.modelo.ParametrosEntrada;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

//    @Autowired
//    private ValidaParametros valida;

    @PostMapping(value = "/completa")
    public String completa(@RequestBody ParametrosEntrada parametrosEntrada){
        parametrosEntrada.validarDados();
       return  "sucesso";
    }
}
