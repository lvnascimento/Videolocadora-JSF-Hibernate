package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Exceção usada no caso de um DVD não ser encontrado em uma busca.
 * 
 * @author Leonardo
 */
public class DVDNaoEncontradoException extends Exception {

    public DVDNaoEncontradoException() {
    }

    public DVDNaoEncontradoException(String message) {
        super(message);
    }

    public DVDNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DVDNaoEncontradoException(Throwable cause) {
        super(cause);
    }

    public DVDNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
