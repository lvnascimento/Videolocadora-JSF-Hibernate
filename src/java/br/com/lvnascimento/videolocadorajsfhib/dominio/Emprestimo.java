package br.com.lvnascimento.videolocadorajsfhib.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa um empréstimo realizado na videolocadora.
 * 
 * @author Leonardo
 */
public class Emprestimo {
    private int id;
    private Date data;
    private boolean estahCompleto;
    private Cliente cliente;
    private List<ItemDeEmprestimo> itens;

    public Emprestimo() {
        data = new Date();
        estahCompleto = false;
        itens = new ArrayList<ItemDeEmprestimo>();
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

    public boolean isEstahCompleto() {
        return estahCompleto;
    }

    public void setEstahCompleto(boolean estahCompleto) {
        this.estahCompleto = estahCompleto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemDeEmprestimo> getItens() {
        return itens;
    }

    public void setItens(List<ItemDeEmprestimo> itens) {
        this.itens = itens;
    }

    public void criarItem(DVD dvd) {
        itens.add(new ItemDeEmprestimo(dvd));
    }
    
    public void tornarSeCompleto() {
        estahCompleto = true;
    }
    
    public double getTotal() {
        double total = 0;
        for(ItemDeEmprestimo ite : itens) {
            total += ite.getValorOriginal();
        }
        return total;
    }

    public void cancelarItem(ItemDeEmprestimo item) {
        item.cancelarEmprestimo();
        itens.remove(item);
    }
}
