package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.FilmeNaoEncontradoException;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.DVDDAO;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.FilmeDAO;
import java.util.List;

/**
 * Classe que implementa o padrão GRASP "Controlador" para os casos de uso relacionados ao
 * cadastro de DVDs (Incluir DVD, Modificar DVD, Excluir DVD, Consultar DVDs).
 * 
 * @author leonardo
 */
public class ControladorCadastroDVDs {
    private final FilmeDAO filmeDAO;
    private Filme filmeCorrente;

    public Filme getFilmeCorrente() {
        return filmeCorrente;
    }
    
    public ControladorCadastroDVDs() {
        this.filmeDAO = new FilmeDAO();
    }

    public List<String> filtraFilmes(String titulo) {
        return filmeDAO.filtroPorTitulo(titulo);
    }
    
    public void salvarDVDs(String tituloFilme, int quantidade) throws FilmeNaoEncontradoException {
        filmeCorrente = filmeDAO.consultaPorTitulo(tituloFilme);
        if(filmeCorrente == null)
            throw new FilmeNaoEncontradoException();
        for(int i = 0; i < quantidade; i++) {
            filmeCorrente.adicionaDVD();
        }
        filmeDAO.salvar(filmeCorrente);
    }
    
    public List<DVD> novosDVDs() {
        return filmeCorrente.novosDVDs();
    }
    
}
