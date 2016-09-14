package br.com.lvnascimento.videolocadorajsfhib.iu;

import br.com.lvnascimento.videolocadorajsfhib.dominio.Cliente;
import br.com.lvnascimento.videolocadorajsfhib.dominio.ControladorCadastroClientes;
import br.com.lvnascimento.videolocadorajsfhib.dominio.Videolocadora;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.ClienteJaCadastradoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.ClientePossuiEmprestimosException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * Bean gerenciado para os casos de uso "Incluir Cliente", "Modificar Cliente",
 * "Excluir Cliente" e "Consultar Clientes".
 * 
 * @author leonardo
 */
@ManagedBean
@ViewScoped
public class CadastroClientesMB extends Bean {
    private final Videolocadora videolocadora;
    private final ControladorCadastroClientes controlador;
    private Cliente cliente = new Cliente();
    private List<Cliente> listaClientes;
    private boolean sucesso;
    
    public CadastroClientesMB() {
        this.videolocadora = new Videolocadora();
        this.controlador = new ControladorCadastroClientes(videolocadora);
    }

    @Override
    public void aoIniciar() {
        this.listaClientes = controlador.listarClientes();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    
    @Override
    public void limpar() {
        if(!sucesso)
            super.limpar();
    }
    
    public void novoCliente() {
        this.cliente = new Cliente();
    }
    
    public void carregarCliente(Cliente c) {
        this.cliente = c;
    }
    
    public void salvarCliente() {
        try {
            controlador.salvarCliente(cliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente salvo com sucesso!", ""));
            cliente = new Cliente();
            listaClientes = controlador.listarClientes();
            sucesso = true;
        } catch(ClienteJaCadastradoException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
            sucesso = false;
        }
    }
    
    public void removerCliente(Cliente c) {
        try {
            controlador.removerCliente(c);
            listaClientes.remove(c);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente removido com sucesso!", ""));
        } catch (ClientePossuiEmprestimosException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O cliente não pode ser removido pois já possui empréstimos registrados.", ""));
        }
    }
}
