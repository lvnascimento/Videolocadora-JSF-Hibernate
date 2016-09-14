package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoPodeSerAlteradoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoPodeSerRemovidoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.FilmeNaoEncontradoException;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.DVDDAO;
import br.com.lvnascimento.videolocadorajsfhib.persistencia.FilmeDAO;

/**
 * Representa o catálogo de DVDs da videolocadora.
 * 
 * @author Leonardo
 */
public class CatalogoDeDVDs {
    private DVDDAO dao;
    
    public CatalogoDeDVDs() {
        dao = new DVDDAO();
    }
    
    public DVD obterDVD(int codigo) {
        return dao.carregar(codigo);
    }
    
    public void atualizar(DVD dvd, String tituloFilme) throws FilmeNaoEncontradoException, DVDNaoPodeSerAlteradoException {
        if(dvd.getPodeSerAlterado()) {
            FilmeDAO filmeDAO = new FilmeDAO();
            Filme filme = filmeDAO.consultaPorTitulo(tituloFilme);
            if(filme == null)
                throw new FilmeNaoEncontradoException();
            else
                dvd.setFilme(filme);
            dao.salvar(dvd);
        } else {
            throw new DVDNaoPodeSerAlteradoException("O DVD não pode ser alterado, pois possui empréstimos já realizados.");
        }
    }
    
    public void remover(DVD dvd) throws DVDNaoPodeSerRemovidoException {
        if(dvd.getPodeSerRemovido())
            dao.remover(dvd);
        else
            throw new DVDNaoPodeSerRemovidoException("O DVD não pode ser removido, pois possui empréstimos já realizados.");
    }
}
