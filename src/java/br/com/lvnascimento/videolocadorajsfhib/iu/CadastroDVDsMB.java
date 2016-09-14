package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.dominio.ControladorCadastroDVDs;
import br.com.lvnascimento.videolocadorajsfhib.dominio.DVD;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Videolocadora;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoPodeSerAlteradoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoPodeSerRemovidoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.FilmeNaoEncontradoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Bean gerenciado para os casos de uso "Incluir DVD", "Modificar DVD",
 * "Excluir DVD" e "Consultar DVDs".
 * 
 * @author leonardo
 */
@ManagedBean
@ViewScoped
public class CadastroDVDsMB extends Bean {
    private final Videolocadora videoloc;
    private final ControladorCadastroDVDs controlador;
    private String tituloFilme;
    private int quantidadeDVDs;
    private int idDVD;
    private DVD dvd;
    
    public CadastroDVDsMB() {
        controlador = new ControladorCadastroDVDs();
        videoloc = new Videolocadora();
    }

    public ControladorCadastroDVDs getControlador() {
        return controlador;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public int getQuantidadeDVDs() {
        return quantidadeDVDs;
    }

    public void setQuantidadeDVDs(int quantidadeDVDs) {
        this.quantidadeDVDs = quantidadeDVDs;
    }

    public int getIdDVD() {
        return idDVD;
    }

    public void setIdDVD(int idDVD) {
        this.idDVD = idDVD;
    }

    public DVD getDvd() {
        return dvd;
    }
    
    public String salvarDVDs() {
        try {
            controlador.salvarDVDs(tituloFilme, quantidadeDVDs);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DVDs cadastrados com sucesso!", ""));
        } catch (FilmeNaoEncontradoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O filme informado não está cadastrado!", ""));
        }
        return null;
    }
    
    public List<DVD> getNovosDVDs() {
        return controlador.novosDVDs();
    }
    
    public String finalizar() {
        return "cadastroDVDs";
    }
    
    public List<String> filtraFilmesPorTitulo(String titulo) {
        return controlador.filtraFilmes(titulo);
    }
    
    public void carregar() {
        dvd = videoloc.getCatalogoDVDs().obterDVD(idDVD);
        if(dvd == null)
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "DVD não encontrado!", ""));
        else
            tituloFilme = dvd.getTitulo();
    }
    
    public void atualizar() {
        try {
            videoloc.getCatalogoDVDs().atualizar(dvd, tituloFilme);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DVD salvo com sucesso!", ""));
        } catch(DVDNaoPodeSerAlteradoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        } catch (FilmeNaoEncontradoException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O filme informado não está cadastrado!", ""));
        }
    }
    
    public void remover() {
        try {
            videoloc.getCatalogoDVDs().remover(dvd);
            dvd = null;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "DVD removido com sucesso!", ""));
        } catch(DVDNaoPodeSerRemovidoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
        }
    }
}
