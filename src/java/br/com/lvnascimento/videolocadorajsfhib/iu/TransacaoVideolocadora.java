package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.persistencia.HibernateUtil;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;

/**
 * Encasula uma transação (envolvendo várias operações) de interface.
 * 
 * @author Leonardo
 */
public class TransacaoVideolocadora {
    private Session sessaoHibernate;
    
    public void iniciar() {
        sessaoHibernate = HibernateUtil.getSessionFactory().openSession();
        sessaoHibernate.setFlushMode(FlushMode.MANUAL);
    }
    
    public void finalizar() {
        sessaoHibernate.flush();
        if(!sessaoHibernate.getTransaction().wasCommitted())
            sessaoHibernate.getTransaction().commit();
        sessaoHibernate.close();
    }
    
    public void iniciarRequisicao() {
        ManagedSessionContext.bind(sessaoHibernate);
        if(sessaoHibernate.getTransaction() != null && !sessaoHibernate.getTransaction().isActive())
            sessaoHibernate.beginTransaction();
    }
    
    public void finalizarRequisicao() {
        if(sessaoHibernate.isOpen() && sessaoHibernate.getTransaction().isActive())
            sessaoHibernate.getTransaction().commit();
        ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());
    }
    
    public void limpar() {
        HibernateUtil.getSessionFactory().getCurrentSession().clear();
    }
}
