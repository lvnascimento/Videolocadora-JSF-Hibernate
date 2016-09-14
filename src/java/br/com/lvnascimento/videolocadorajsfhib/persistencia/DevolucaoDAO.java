package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Devolucao;
import org.hibernate.Session;

/**
 * 
 * @author Leonardo
 */
public class DevolucaoDAO {
    public void adicionar(Devolucao d) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(d);
    }
}
