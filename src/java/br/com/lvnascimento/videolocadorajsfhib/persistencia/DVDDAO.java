package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.DVD;
import org.hibernate.Session;

/**
 * Classe de persistência para DVDs
 * 
 * @author Leonardo
 */
public class DVDDAO {
    public DVD carregar(int codigo) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (DVD) sessao.get(DVD.class, codigo);
    }
    
    public void salvar(DVD dvd) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.update(dvd);
    }
    
    public void remover(DVD dvd) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(dvd);
    }
}
