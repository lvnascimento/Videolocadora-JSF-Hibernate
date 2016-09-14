package br.com.lvnascimento.videolocadorajsfhib.dominio;

/**
 * Classe que representa um pagamento efetuado pelo cliente ao devolver um DVD.
 * 
 * @author Leonardo
 */
public class Pagamento {
    private int id;
    private double quantiaDadaPeloCliente;
    private double troco;

    public Pagamento() {}
    
    public Pagamento(Devolucao dev, double quantiaDadaPeloCliente) {
        this.quantiaDadaPeloCliente = quantiaDadaPeloCliente;
        this.troco = quantiaDadaPeloCliente - dev.getTotal();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantiaDadaPeloCliente() {
        return quantiaDadaPeloCliente;
    }

    public void setQuantiaDadaPeloCliente(double quantiaDadaPeloCliente) {
        this.quantiaDadaPeloCliente = quantiaDadaPeloCliente;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }
}
