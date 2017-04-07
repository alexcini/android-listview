package br.com.heiderlopes.jogoscomlistview.model;

public class Jogo {

    private int id;
    private String nome;
    private int anoLancamento;
    private int resourceIdImagem;

    //Criamos um construtor em branco para criarmos um objeto sem a necessidade passar algum valor
    public Jogo() {

    }

    //Criamos um objeto informando o id, nome, anoLancamento e o resourceId da Imagem
    public Jogo(int id, String nome, int anoLancamento, int resourceIdImagem) {

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

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getResourceIdImagem() {
        return resourceIdImagem;
    }

    public void setResourceIdImagem(int resourceIdImagem) {
        this.resourceIdImagem = resourceIdImagem;
    }
}
