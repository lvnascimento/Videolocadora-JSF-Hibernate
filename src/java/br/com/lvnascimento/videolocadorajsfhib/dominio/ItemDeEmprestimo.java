package br.com.lvnascimento.videolocadorajsfhib.dominio;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Representa um item de um empréstimo.
 * 
 * @author Leonardo
 */
public class ItemDeEmprestimo {
    private int id;
    private double valorOriginal;
    private Date dataParaDevolucao;
    private int diasEmAtraso;
    private DVD dvd;
    private Emprestimo emprestimo;

    public ItemDeEmprestimo() {
        
    }
    
    public ItemDeEmprestimo(DVD dvd) {
        this.dvd = dvd;
        this.valorOriginal = dvd.getPreco();
        this.dataParaDevolucao = calcularDataDevolucao(dvd);
        this.dvd.setItemDeEmprestimoCorrente(this);
    }

    private Date calcularDataDevolucao(DVD dvd1) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(GregorianCalendar.DAY_OF_MONTH, dvd1.getPrazo());
        return cal.getTime();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public Date getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataParaDevolucao(Date dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }

    public int getDiasEmAtraso() {
        return diasEmAtraso;
    }

    public void setDiasEmAtraso(int diasEmAtraso) {
        this.diasEmAtraso = diasEmAtraso;
    }

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }
    
    public Cliente getCliente() {
        return emprestimo.getCliente();
    }
    
    public void devolver() {
        Date hoje = new Date();
        if(hoje.after(dataParaDevolucao))
            this.diasEmAtraso = (int)((hoje.getTime() - this.dataParaDevolucao.getTime())/86400000L);
        else
            this.diasEmAtraso = 0;
        dvd.setItemDeEmprestimoCorrente(null);
    }
    
    public double getValorMulta() {
        return diasEmAtraso * valorOriginal;
    }
    
    public double getValorFinal() {
        return valorOriginal + getValorMulta();
    }
    
    public boolean isAtrasado() {
        return diasEmAtraso > 0;
    }

    public void cancelarEmprestimo() {
        this.dvd.setItemDeEmprestimoCorrente(null);
    }
    
    public void cancelarDevolucao() {
        this.dvd.setItemDeEmprestimoCorrente(this);
    }
    
}
