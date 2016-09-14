package br.com.lvnascimento.videolocadorajsfhib.dominio;

/**
 * Representa uma categoria de filme (Lançamento, Catálogo, ...).
 * 
 * @author Leonardo
 */
public class Categoria {
    private int id;
    private String nome;
    private double preco;
    private int prazo;

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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }
    
}
