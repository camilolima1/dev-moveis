package br.ufc.quixada.dspdm.oficina.DAO;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dspdm.oficina.model.ModelOficina;

public class DAOOficina {
    private List<ModelOficina> oficinas = new ArrayList<>();

    public DAOOficina() {
    }

    public DAOOficina(List<ModelOficina> oficinas) {
        this.oficinas = oficinas;
    }

    public void addOficina(ModelOficina oficina) {
        this.oficinas.add(oficina);
    }

    public List listarOficinas() {
        return getOficinas();
    }

    public List<ModelOficina> getOficinas() {
        return oficinas;
    }

    public void setOficinas(List<ModelOficina> oficinas) {
        this.oficinas = oficinas;
    }

    @Override
    public String toString() {
        return "DAOOficina{" +
                "oficinas=" + oficinas +
                '}';
    }
}
