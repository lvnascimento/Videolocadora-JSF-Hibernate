package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Categoria;
import java.util.List;
import org.hibernate.Session;

/**
 * Classe de persistencia para categorias de filmes.
 * 
 * @author leonardo
 */
public class CategoriaDAO {
    public Categoria carregar(int idCategoria) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Categoria) sessao.get(Categoria.class, idCategoria);
    }

    public List<Categoria> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createCriteria(Categoria.class).list();
    }
}
