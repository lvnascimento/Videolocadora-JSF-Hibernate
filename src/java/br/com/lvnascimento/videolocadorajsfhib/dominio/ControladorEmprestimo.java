package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.ClienteNaoEncontradoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDJaEmprestadoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoEncontradoException;

/**
 * Classe que implementa o padrão GRASP "Controlador" para o caso de uso "Emprestar DVDs".
 * 
 * @author Leonardo
 */
public class ControladorEmprestimo {
    private Emprestimo emprestimoCorrente;
    private final Videolocadora videoloc;
    
    public ControladorEmprestimo(Videolocadora videoloc) {
        this.videoloc = videoloc;
        emprestimoCorrente = null;
    }

    public Emprestimo getEmprestimoCorrente() {
        return emprestimoCorrente;
    }

    public Videolocadora getVideoloc() {
        return videoloc;
    }
    
    public void iniciarNovoEmprestimo() {
        emprestimoCorrente = new Emprestimo();
    }
    
    public void identificaCliente(String nome) throws ClienteNaoEncontradoException {
        Cliente c = videoloc.getCatalogoClientes().obterCliente(nome);
        if(c != null)
            emprestimoCorrente.setCliente(c);
        else
            throw new ClienteNaoEncontradoException();
    }
    
    public void emprestarDVD(int codDVD) throws DVDNaoEncontradoException, DVDJaEmprestadoException {
        DVD dvd = videoloc.getCatalogoDVDs().obterDVD(codDVD);
        if(dvd == null)
            throw new DVDNaoEncontradoException();
        if(dvd.isEmprestado())
            throw new DVDJaEmprestadoException();
        emprestimoCorrente.criarItem(dvd);
    }
    
    public void terminarEmprestimo() {
        emprestimoCorrente.tornarSeCompleto();
        videoloc.adicionarEmprestimo(emprestimoCorrente);
    }

    public void cancelarItem(ItemDeEmprestimo item) {
        emprestimoCorrente.cancelarItem(item);
    }
}
