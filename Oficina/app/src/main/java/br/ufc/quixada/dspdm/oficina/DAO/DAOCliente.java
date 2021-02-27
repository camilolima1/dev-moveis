package br.ufc.quixada.dspdm.oficina.DAO;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dspdm.oficina.model.ModelCliente;
import br.ufc.quixada.dspdm.oficina.model.ModelLogin;

public class DAOCliente {

    public static List<ModelCliente> clientes = new ArrayList<>();

    public DAOCliente() {
    }

    public DAOCliente(List<ModelCliente> modelClientes) {
        this.clientes = modelClientes;
    }

    public List<ModelCliente> getModelClientes() {
        return clientes;
    }

    public void setModelClientes(List<ModelCliente> modelClientes) {
        this.clientes = modelClientes;
    }

    public void addCliente (ModelCliente modelCliente) {
        this.clientes.add(modelCliente);
    }

    public ModelCliente SelecionarCliente(String cpf) {
        for(ModelCliente c : clientes) {
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public String atualizarCliente(ModelCliente c) {
        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCpf().equals(c.getCpf())){
                clientes.get(i).setCpf(c.getCpf());
                clientes.get(i).setNome(c.getNome());
                clientes.get(i).setRua(c.getRua());
                clientes.get(i).setBairro(c.getBairro());
                clientes.get(i).setModeloCarro(c.getModeloCarro());
                return "ok";
            }
        }
        return "nok";
    }

    @Override
    public String toString() {
        return "DAOCliente{" +
                "clientes=" + clientes +
                '}';
    }


}
