package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoEmprestadoException;
import br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes.DVDNaoEncontradoException;

/**
 * Classe que implementa o padrão GRASP "Controlador" para o caso de uso "Devolver DVDs".
 * 
 * @author Leonardo
 */
public class ControladorDevolucao {
    private Devolucao devolucaoCorrente;
    private final Videolocadora videoloc;
    
    public ControladorDevolucao(Videolocadora videoloc) {
        this.videoloc = videoloc;
    }

    public Devolucao getDevolucaoCorrente() {
        return devolucaoCorrente;
    }
    
    public void iniciarNovaDevolucao() {
        devolucaoCorrente = new Devolucao();
    }
    
    public void devolverDVD(int codDVD) throws DVDNaoEncontradoException, DVDNaoEmprestadoException {
        DVD dvd = videoloc.getCatalogoDVDs().obterDVD(codDVD);
        if(dvd == null)
            throw new DVDNaoEncontradoException();
        if(!dvd.isEmprestado())
            throw new DVDNaoEmprestadoException();
        devolucaoCorrente.devolverDVD(dvd);
    }
    
    public void terminarDevolucao() {
        devolucaoCorrente.tornarSeCompleta();
    }
    
    public void fazerPagamento(double quantia) {
        devolucaoCorrente.fazerPagamento(quantia);
        videoloc.adicionarDevolucao(devolucaoCorrente);
    }

    public void cancelarItem(ItemDeEmprestimo item) {
        devolucaoCorrente.cancelarItem(item);
    }
}
