package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Classe que encapsula uma exceção quando um DVD não pode ser removido.
 * 
 * @author leonardo
 */
public class DVDNaoPodeSerRemovidoException extends Exception {

    public DVDNaoPodeSerRemovidoException() {
    }

    public DVDNaoPodeSerRemovidoException(String message) {
        super(message);
    }

    public DVDNaoPodeSerRemovidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DVDNaoPodeSerRemovidoException(Throwable cause) {
        super(cause);
    }

    public DVDNaoPodeSerRemovidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
