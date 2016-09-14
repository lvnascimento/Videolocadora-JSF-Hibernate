package br.com.lvnascimento.videolocadorajsfhib.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe que representa filmes do catálogo da videolocadora.
 * 
 * @author Leonardo
 */
public class Filme {
    private int id;
    private String titulo;
    private Genero genero;
    private Categoria categoria;
    private String tema;
    private int ano;
    private int classificacao;
    private String sinopse;
    private byte[] capa;
    private Set<DVD> dvds;

    public Filme() {
        this.dvds = new HashSet();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getNomeCategoria() {
        return categoria.getNome();
    }
    
    public double getPreco() {
        return categoria.getPreco();
    }
    
    public int getPrazo() {
        return categoria.getPrazo();
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public byte[] getCapa() {
        return capa;
    }

    public void setCapa(byte[] capa) {
        this.capa = capa;
    }

    public Set<DVD> getDvds() {
        return dvds;
    }

    public void setDvds(Set<DVD> dvds) {
        this.dvds = dvds;
    }

    public void adicionaDVD() {
        DVD dvd = new DVD(true);
        dvd.setFilme(this);
        dvds.add(dvd);
    }

    public List<DVD> novosDVDs() {
        List<DVD> result = new ArrayList();
        for(DVD dvd : dvds) {
            if(dvd.isNovo())
                result.add(dvd);
        }
        return result;
    }

    public boolean isNovo() {
        return id == 0 && titulo == null && genero == null && categoria == null;
    }
}
