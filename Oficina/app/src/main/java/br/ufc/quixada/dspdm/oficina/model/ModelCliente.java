package br.ufc.quixada.dspdm.oficina.model;

import java.util.Date;

public class ModelCliente {

    private String cpf;
    private String nome;
    private String rua;
    private String bairro;
    private String modeloCarro;

    public ModelCliente() {

    }

    public ModelCliente(String cpf, String nome, String rua, String bairro, String modeloCarro) {
        this.cpf = cpf;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.modeloCarro = modeloCarro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", modeloCarro='" + modeloCarro + '\'' +
                '}';
    }
}
