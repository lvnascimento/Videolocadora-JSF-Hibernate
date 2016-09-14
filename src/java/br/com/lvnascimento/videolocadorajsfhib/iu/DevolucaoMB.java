package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.dominio.ControladorDevolucao;
import br.com.lvnascimento.videolocadorajsfhib.dominio.ItemDeEmprestimo;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Videolocadora;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoEmprestadoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoEncontradoException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * Bean gerenciado para o caso de uso "Devolver DVDs".
 * 
 * @author Leonardo
 */
@ManagedBean
@ViewScoped
public class DevolucaoMB extends Bean {
    private final Videolocadora videolocadora;
    private final ControladorDevolucao controlador;
    private int codigoDVD;
    private double valorPago;
    
    public DevolucaoMB() {
        videolocadora = new Videolocadora();
        controlador = new ControladorDevolucao(videolocadora);
    }

    @Override
    public void aoIniciar() {
        controlador.iniciarNovaDevolucao();
    }

    public int getCodigoDVD() {
        return codigoDVD;
    }

    public void setCodigoDVD(int codigoDVD) {
        this.codigoDVD = codigoDVD;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public ControladorDevolucao getControlador() {
        return controlador;
    }
    
    public void processaCodigoDVD(ValueChangeEvent event) {
        try {
            controlador.devolverDVD((Integer)event.getNewValue());
        } catch (DVDNaoEncontradoException ex) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "O código informado não corresponde a nenhum DVD cadastrado no sistema.", ""));
        } catch (DVDNaoEmprestadoException ex) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "O DVD informado não encontra-se emprestado.", ""));
        }
    }
    
    public String terminarDevolucao() {
        controlador.terminarDevolucao();
        return null;
    }
    
    public void processaPagamento(ValueChangeEvent event) {
        controlador.fazerPagamento((Double)event.getNewValue());
    }
    
    public String fechar() {
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Devolução salva com sucesso!", ""));
        return "devolucao";
    }
    
    public void cancelarItem(ItemDeEmprestimo item) {
        controlador.cancelarItem(item);
    }
}
