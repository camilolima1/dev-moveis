package br.ufc.quixada.dspdm.oficina.model;

public class ModelOficina {
    private int id;
    private String nome;
    private String slogan;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;

    public ModelOficina() {
    }

    public ModelOficina(int id, String nome, String slogan,
                        String rua, int numero, String bairro, String cidade) {
        this.id = id;
        this.nome = nome;
        this.slogan = slogan;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "ModelOficina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", slogan='" + slogan + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
