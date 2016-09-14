package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.persistencia.CategoriaDAO;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.FilmeDAO;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.GeneroDAO;
import java.util.List;

/**
 * Classe que implementa o padrão GRASP "Controlador" para os casos de uso relacionados ao
 * cadastro de filmes (Incluir Filme, Modificar Filme, Excluir Filme, Consultar Filmes).
 * 
 * @author leonardo
 */
public class ControladorCadastroFilmes {
    private final FilmeDAO dao;
    private final GeneroDAO generoDAO;
    private final CategoriaDAO categoriaDAO;
    
    public ControladorCadastroFilmes() {
        this.dao = new FilmeDAO();
        this.generoDAO = new GeneroDAO();
        this.categoriaDAO = new CategoriaDAO();
    }
    
    public void salvarFilme(Filme f) {
        dao.salvar(f);
    }
    
    public void removerFilme(Filme f) {
        dao.remover(f);
    }
    
    public List<Filme> getListaFilmes() {
        return dao.listar();
    }

    public Genero carregaGenero(int idGenero) {
        return generoDAO.carregar(idGenero);
    }
    
    public List<Genero> listaGeneros() {
        return generoDAO.listar();
    }
    
    public Categoria carregaCategoria(int idCategoria) {
        return categoriaDAO.carregar(idCategoria);
    }
    
    public List<Categoria> listaCategorias() {
        return categoriaDAO.listar();
    }
}
