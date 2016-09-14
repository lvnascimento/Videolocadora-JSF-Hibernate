package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Cliente;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Emprestimo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Leonardo
 */
public class EmprestimoDAO {
    public void adicionar(Emprestimo e) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.save(e);
    }
    
    public List<Emprestimo> consultaPorCliente(Cliente c) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createQuery("FROM Emprestimo WHERE cliente.id = :idCliente")
                .setInteger("idCliente", c.getId())
                .list();
    }
}
