package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.dominio.ControladorCadastroGeneros;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Genero;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Bean gerenciado para os casos de uso "Incluir Gênero", "Modificar Gênero",
 * "Excluir Gênero" e "Consultar Gêneros".
 * 
 * @author leonardo
 */
@ManagedBean
@ViewScoped
public class CadastroGenerosMB extends Bean {
    private final ControladorCadastroGeneros controlador;
    private Genero genero = new Genero();
    
    public CadastroGenerosMB() {
        this.controlador = new ControladorCadastroGeneros();
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public String salvarGenero() {
        controlador.salvarGenero(genero);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gênero salvo com sucesso!", ""));
        genero = new Genero();
        return "cadastroGeneros";
    }
}
