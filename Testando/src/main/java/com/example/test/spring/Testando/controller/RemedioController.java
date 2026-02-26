package com.example.test.spring.Testando.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.spring.Testando.remedio.DadosCadastroRemedio;
import com.example.test.spring.Testando.remedio.DadosListarRemedio;
import com.example.test.spring.Testando.remedio.entity.RemedioEntity;
import com.example.test.spring.Testando.remedio.repository.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/remedio")
public class RemedioController {


    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados) {

        repository.save(new RemedioEntity(dados));

    }

    @GetMapping
    public List<DadosListarRemedio> listar() {
        return repository.findAll().stream().map(DadosListarRemedio::new).toList();

    }

  
}
