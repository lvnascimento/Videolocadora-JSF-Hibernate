package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.persistencia.ClienteDAO;
import java.util.List;

/**
 * Representa o catálogo de clientes da locadora.
 * 
 * @author Leonardo
 */
public class CatalogoDeClientes {
    private ClienteDAO dao;
    
    public CatalogoDeClientes() {
        dao = new ClienteDAO();
    }
    
    public void salvarCliente(Cliente c) {
        dao.salvar(c);
    }
    
    public Cliente obterCliente(String nome) {
        return dao.carregar(nome);
    }
    
    public List<Cliente> listarClientes() {
        return dao.listar();
    }
    
    public List<String> filtrarPorNome(String nome) {
        return dao.consultarPorNome(nome);
    }

    public Cliente obterClientePorCPF(String cpf) {
        return dao.consultarPorCpf(cpf);
    }
    
    public void removerCliente(Cliente c) {
        dao.remover(c);
    }
}
