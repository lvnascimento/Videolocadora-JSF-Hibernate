package br.com.lvnascimento.videolocadorajsfhib.iu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.context.internal.ManagedSessionContext;

/**
 * Classe base para managed beans da aplicação.
 * 
 * @author Leonardo
 */
public abstract class Bean {
    private TransacaoVideolocadora transacaoCorrente;
    
    @PostConstruct
    public void inicializacao() {
        transacaoCorrente = new TransacaoVideolocadora();
        transacaoCorrente.iniciar();
        HttpSession sessaoHTTP = (HttpSession) 
                FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessaoHTTP.setAttribute("transacaoCorrente", transacaoCorrente);
        transacaoCorrente.iniciarRequisicao();
        aoIniciar();
    }
    
    @PreDestroy
    public void finalizacao() {
        aoFinalizar();
        transacaoCorrente.finalizar();
        HttpSession sessaoHTTP = (HttpSession) 
                FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessaoHTTP.removeAttribute("transacaoCorrente");
    }
    
    public void limpar() {
        transacaoCorrente.limpar();
    }
    
    public void aoIniciar() { }
    public void aoFinalizar() { }
}
