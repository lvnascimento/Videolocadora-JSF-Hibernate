package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.ClienteJaCadastradoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.ClientePossuiEmprestimosException;
import java.util.List;

/**
 * Classe que implementa o padrão GRASP "Controlador" para os casos de uso relacionados ao
 * cadastro de clientes (Incluir Cliente, Modificar Cliente, Excluir Cliente, Consultar Clientes).
 * 
 * @author leonardo
 */
public class ControladorCadastroClientes {
    private final Videolocadora videoloc;
    
    public ControladorCadastroClientes(Videolocadora videoloc) {
        this.videoloc = videoloc;
    }
    
    public void salvarCliente(Cliente c) throws ClienteJaCadastradoException {
        Cliente existente = this.videoloc.getCatalogoClientes().obterCliente(c.getNome());
        if(existente != null && !c.equals(existente))
            throw new ClienteJaCadastradoException("Já existe um cliente cadastrado com o nome \""+c.getNome()+"\"");
        existente = this.videoloc.getCatalogoClientes().obterClientePorCPF(c.getCpf());
        if(existente != null && !c.equals(existente))
            throw new ClienteJaCadastradoException("Já existe um cliente cadastrado com o CPF \""+c.getCpf()+"\"");
        this.videoloc.getCatalogoClientes().salvarCliente(c);
    }
    
    public void removerCliente(Cliente c) throws ClientePossuiEmprestimosException {
        if(c.possuiEmprestimos()) 
            throw new ClientePossuiEmprestimosException();
        else
            this.videoloc.getCatalogoClientes().removerCliente(c);
    }
    
    public List<Cliente> listarClientes() {
        return this.videoloc.getCatalogoClientes().listarClientes();
    }
}
