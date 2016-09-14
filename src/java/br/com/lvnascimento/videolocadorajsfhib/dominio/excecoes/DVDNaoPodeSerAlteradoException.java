package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Classe que encapsula uma exceção quando um DVD não pode ser alterado.
 * 
 * @author leonardo
 */
public class DVDNaoPodeSerAlteradoException extends Exception {

    public DVDNaoPodeSerAlteradoException() {
    }

    public DVDNaoPodeSerAlteradoException(String message) {
        super(message);
    }

    public DVDNaoPodeSerAlteradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DVDNaoPodeSerAlteradoException(Throwable cause) {
        super(cause);
    }

    public DVDNaoPodeSerAlteradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
