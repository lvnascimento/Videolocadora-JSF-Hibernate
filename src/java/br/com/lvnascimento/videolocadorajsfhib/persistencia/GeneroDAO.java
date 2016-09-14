package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Genero;
import java.util.List;
import org.hibernate.Session;

/**
 * Classe de persistencia para gêneros de filmes.
 * 
 * @author leonardo
 */
public class GeneroDAO {
    public void salvar(Genero g) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.saveOrUpdate(g);
    }

    public Genero carregar(int idGenero) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Genero) sessao.get(Genero.class, idGenero);
    }

    public List<Genero> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createQuery("FROM Genero ORDER BY nome").list();
    }
}
