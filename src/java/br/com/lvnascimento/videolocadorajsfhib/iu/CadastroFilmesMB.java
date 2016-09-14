package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Categoria;
import br.com.lvnascimento.videolocadorajsfhib.dominio.ControladorCadastroFilmes;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Filme;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Genero;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

/**
 * Bean gerenciado para os casos de uso "Incluir Filme", "Modificar Filme",
 * "Excluir Filme" e "Consultar Filmes".
 * 
 * @author leonardo
 */
@ManagedBean
@ViewScoped
public class CadastroFilmesMB extends Bean {
    private final ControladorCadastroFilmes controlador;
    private Filme filme = new Filme();
    private int idGenero;
    private int idCategoria;
    private UploadedFile arquivoFoto;
    private List<Filme> listaFilmes;

    public CadastroFilmesMB() {
        controlador = new ControladorCadastroFilmes();
    }

    @Override
    public void aoIniciar() {
        listaFilmes = controlador.getListaFilmes();
    }
    
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public UploadedFile getArquivoFoto() {
        return arquivoFoto;
    }

    public void setArquivoFoto(UploadedFile arquivoFoto) {
        this.arquivoFoto = arquivoFoto;
    }
    
    public List<Genero> getListaGeneros() {
        return controlador.listaGeneros();
    }
    
    public List<Categoria> getListaCategorias() {
        return controlador.listaCategorias();
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void novoFilme() {
        filme = new Filme();
    }
    
    public String salvarFilme() {
        filme.setGenero(controlador.carregaGenero(idGenero));
        filme.setCategoria(controlador.carregaCategoria(idCategoria));
        filme.setCapa(arquivoFoto.getContents());
        if(filme.getId() == 0)
            listaFilmes.add(filme);
        controlador.salvarFilme(filme);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme salvo com sucesso!", ""));
        filme = new Filme();
        return null;
    }
    
    public void removerFilme(Filme f) {
        controlador.removerFilme(f);
        listaFilmes.remove(f);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Filme removido com sucesso!", ""));
    }
    
    public void carregarFilme(Filme f) {
        StreamedContent streamCapa;
        idGenero = f.getGenero().getId();
        idCategoria = f.getCategoria().getId();
        filme = f;
        if(f.getCapa() == null)
            streamCapa = null;
        else
            streamCapa = new DefaultStreamedContent(new ByteArrayInputStream(filme.getCapa()), "image/jpeg");
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sessaoHTTP.setAttribute("streamCapa", streamCapa);
    }
    
}
