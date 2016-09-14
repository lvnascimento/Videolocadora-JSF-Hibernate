package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Classe DAO para geração da sequência de valores para códigos de DVD.
 * 
 * @author leonardo
 */
public class SequenciaDVDDAO {
    public synchronized int proximoIdDVD() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        
        SequenciaDVD seq = (SequenciaDVD) sessao.createQuery("FROM SequenciaDVD")
                                .uniqueResult();
        
        seq.incrProximoIdDVD();
        sessao.update(seq);
        
        t.commit();
        sessao.close();
        return seq.getProximoIdDVD();
    }
}
