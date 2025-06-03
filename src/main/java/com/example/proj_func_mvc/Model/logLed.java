package com.example.proj_func_mvc.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class logLed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String acao;

    private LocalDateTime data;

    public logLed() {
        this.data = LocalDateTime.now();
    }

    public logLed(String acao) {
        this.acao = acao;
        this.data = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
