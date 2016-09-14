package br.com.lvnascimento.videolocadorajsfhib.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa uma devolução de DVDs.
 * 
 * @author Leonardo
 */
public class Devolucao {
    private int id;
    private Date data;
    private boolean estahCompleta;
    private List<ItemDeEmprestimo> itens;
    private Pagamento pagamento;
    
    public Devolucao() {
        data = new Date();
        estahCompleta = false;
        itens = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isEstahCompleta() {
        return estahCompleta;
    }

    public void setEstahCompleta(boolean estahCompleta) {
        this.estahCompleta = estahCompleta;
    }

    public List<ItemDeEmprestimo> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeEmprestimo> itens) {
        this.itens = itens;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
    
    public void devolverDVD(DVD dvd) {
        ItemDeEmprestimo ite = dvd.getItemDeEmprestimoCorrente();
        itens.add(ite);
        ite.devolver();
    }
    
    public void tornarSeCompleta() {
        estahCompleta = true;
    }
    
    public double getTotal() {
        double total = 0;
        for(ItemDeEmprestimo ide: itens) {
            total += ide.getValorFinal();
        }
        return total;
    }
    
    public void fazerPagamento(double quantiaFornecida) {
        pagamento = new Pagamento(this, quantiaFornecida);
    }
    
    public double getTroco() {
        return pagamento.getTroco();
    }

    public void cancelarItem(ItemDeEmprestimo item) {
        item.cancelarDevolucao();
        itens.remove(item);
    }
}
