package br.com.lvnascimento.videolocadorajsfhib.persistencia;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 * Classe de persistência para Clientes.
 * 
 * @author Leonardo
 */
public class ClienteDAO {
    public void salvar(Cliente c) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.saveOrUpdate(c);
    }
    
    public List<Cliente> listar() {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createQuery("FROM Cliente").list();
    }
    
    public Cliente carregar(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Cliente) sessao.createQuery("FROM Cliente WHERE nome = :nome")
                .setString("nome", nome)
                .uniqueResult();
    }
    
    public List<String> consultarPorNome(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return sessao.createQuery("SELECT nome FROM Cliente WHERE nome like :nome")
                .setString("nome", nome+"%")
                .list();
    }

    public Cliente consultarPorCpf(String cpf) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Cliente) sessao.createQuery("FROM Cliente WHERE cpf = :cpf")
                .setString("cpf", cpf)
                .uniqueResult();
    }
    
    public void remover(Cliente c) {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.delete(c);
    }
}
