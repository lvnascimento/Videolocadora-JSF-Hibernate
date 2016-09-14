package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.dominio.ControladorEmprestimo;
import br.com.lvnascimento.videolocadorajsfhib.dominio.ItemDeEmprestimo;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Videolocadora;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.ClienteNaoEncontradoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDJaEmprestadoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoEncontradoException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * Bean gerenciado para o caso de uso "Emprestar DVDs".
 * 
 * @author Leonardo
 */
@ManagedBean
@ViewScoped
public class EmprestimoMB extends Bean {
    private final Videolocadora videolocadora;
    private final ControladorEmprestimo controlador;
    private String nomeCliente;
    private int codigoDVD;
    
    public EmprestimoMB() {
        videolocadora = new Videolocadora();
        controlador = new ControladorEmprestimo(videolocadora);
    }

    @Override
    public void aoIniciar() {
        controlador.iniciarNovoEmprestimo();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getCodigoDVD() {
        return codigoDVD;
    }

    public void setCodigoDVD(int codigoDVD) {
        this.codigoDVD = codigoDVD;
    }
    
    public ControladorEmprestimo getControlador() {
        return controlador;
    }
    
    public List<String> filtraClientes(String nome) {
        return videolocadora.getCatalogoClientes().filtrarPorNome(nome);
    }
    
    public void processaNomeCliente(ValueChangeEvent event) {
        try {
            controlador.identificaCliente(event.getNewValue().toString());
        } catch(ClienteNaoEncontradoException cne) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi encontrado nenhum cliente com o nome especificado.", ""));
        }
    }
    
    public void processaCodigoDVD(ValueChangeEvent event) {
        try {
            controlador.emprestarDVD((Integer)event.getNewValue());
        } catch (DVDNaoEncontradoException ex) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "O código informado não corresponde a nenhum DVD cadastrado no sistema.", ""));
        } catch (DVDJaEmprestadoException ex) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "O DVD informado já se encontra emprestado.", ""));
        }
    }
    
    public String terminarEmprestimo() {
        controlador.terminarEmprestimo();
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_INFO, "Empréstimo salvo com sucesso!", ""));
        return "emprestimo";
    }
    
    public void cancelarItem(ItemDeEmprestimo item) {
        controlador.cancelarItem(item);
    }
}
