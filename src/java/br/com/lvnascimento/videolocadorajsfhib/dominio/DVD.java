package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.persistencia.SequenciaDVDDAO;
import java.util.Set;

/**
 * Classe que representa DVDs físicos presentes no acervo da videolocadora.
 * 
 * @author Leonardo
 */
public class DVD {
    private int codigo;
    private Filme filme;
    private ItemDeEmprestimo itemDeEmprestimoCorrente;
    private Set<ItemDeEmprestimo> itensDeEmprestimo;
    private String motivoBaixa;
    
    // Atributo transiente usado para marcar um DVD como novo na inclusão de DVDs.
    // Somente DVDs marcados como novos são mostrados ao final da inclusão de DVDs.
    private boolean novo;

    public DVD() { }
    
    public DVD(boolean novo) {
        this.novo = novo;
        this.codigo = (new SequenciaDVDDAO()).proximoIdDVD();
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public ItemDeEmprestimo getItemDeEmprestimoCorrente() {
        return itemDeEmprestimoCorrente;
    }

    public void setItemDeEmprestimoCorrente(ItemDeEmprestimo itemDeEmprestimoCorrente) {
        this.itemDeEmprestimoCorrente = itemDeEmprestimoCorrente;
    }

    public boolean isNovo() {
        return novo;
    }
    
    public String getTitulo() {
        return filme.getTitulo();
    }
    
    public String getNomeCategoria() {
        return filme.getNomeCategoria();
    }
    
    public double getPreco() {
        return filme.getPreco();
    }
    
    public int getPrazo() {
        return filme.getPrazo();
    }
    
    public boolean isEmprestado() {
        return itemDeEmprestimoCorrente != null;
    }
    
    public Cliente getCliente() {
        return itemDeEmprestimoCorrente.getCliente();
    }

    public Set<ItemDeEmprestimo> getItensDeEmprestimo() {
        return itensDeEmprestimo;
    }

    public void setItensDeEmprestimo(Set<ItemDeEmprestimo> itensDeEmprestimo) {
        this.itensDeEmprestimo = itensDeEmprestimo;
    }

    public String getMotivoBaixa() {
        return motivoBaixa;
    }

    public void setMotivoBaixa(String motivoBaixa) {
        this.motivoBaixa = motivoBaixa;
    }
    
    public boolean isBaixa() {
        return motivoBaixa != null;
    }
    
    public boolean getPodeSerRemovido() {
        return itensDeEmprestimo.isEmpty();
    }

    public boolean getPodeSerAlterado() {
        return itensDeEmprestimo.isEmpty();
    }
}
