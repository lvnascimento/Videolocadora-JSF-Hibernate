package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Filme;
import java.util.List;
import org.hibernate.Session;

/**
 * Classe de persistencia para filmes.
 * 
 * @author leonardo
 */
public class FilmeDAO {
    public void salvar(Filme f) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.saveOrUpdate(f);
    }

    public Filme consultaPorTitulo(String tituloFilme) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Filme) sessao.createQuery("FROM Filme WHERE titulo = :titulo")
                .setString("titulo", tituloFilme)
                .uniqueResult();
    }
    
    public List<String> filtroPorTitulo(String titulo) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createQuery("SELECT titulo FROM Filme WHERE titulo LIKE :titulo")
                .setString("titulo", "%"+titulo+"%")
                .list();
    }
    
    public void remover(Filme f) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(f);
    }
    
    public List<Filme> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createQuery("FROM Filme").list();
    }
}
