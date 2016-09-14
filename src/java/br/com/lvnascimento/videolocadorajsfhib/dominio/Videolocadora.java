package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.persistencia.DevolucaoDAO;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.EmprestimoDAO;

/**
 * Classe que representa uma videolocadora.
 * 
 * @author Leonardo
 */
public class Videolocadora {
    private final CatalogoDeClientes catalogoClientes;
    private final CatalogoDeDVDs catalogoDVDs;

    public Videolocadora() {
        catalogoClientes = new CatalogoDeClientes();
        catalogoDVDs = new CatalogoDeDVDs();
    }

    public CatalogoDeClientes getCatalogoClientes() {
        return catalogoClientes;
    }

    public CatalogoDeDVDs getCatalogoDVDs() {
        return catalogoDVDs;
    }
    
    public void adicionarEmprestimo(Emprestimo e) {
        EmprestimoDAO dao = new EmprestimoDAO();
        dao.adicionar(e);
    }
    
    public void adicionarDevolucao(Devolucao d) {
        DevolucaoDAO dao = new DevolucaoDAO();
        dao.adicionar(d);
    }
}
