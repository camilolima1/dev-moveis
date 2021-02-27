package br.ufc.quixada.dspdm.oficina.DAO;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dspdm.oficina.model.ModelLogin;

public class DAOLogin {

      public static List<ModelLogin> logins = new ArrayList<ModelLogin>();

//    public DAOLogin() {
//    }
//
//    public DAOLogin(List<ModelLogin> login) {
//        this.logins = login;
//    }

    public List<ModelLogin> getLogin() {
        return logins;
    }

    public void setLogin(List<ModelLogin> login) {
        this.logins = login;
    }

    public void addLogin(ModelLogin login) {
        logins.add(login);
        System.out.println("C Logins: "+logins.toString());
    }

    public String Logar(String cpf, String senha) {
        for(ModelLogin l : logins) {
            if(l.getCpf().equals(cpf) && l.getSenha().equals(senha)){
                return "ok";
            }
        }
        return "nok";
    }

    @Override
    public String toString() {
        return "DAOLogin{" +
                "logins=" + logins +
                '}';
    }
}
