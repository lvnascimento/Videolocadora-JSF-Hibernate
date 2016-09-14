package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Excecao usada quando se tenta devolver um DVD que não foi emprestado.
 * 
 * @author Leonardo
 */
public class DVDNaoEmprestadoException extends Exception {

    public DVDNaoEmprestadoException() {
    }

    public DVDNaoEmprestadoException(String message) {
        super(message);
    }

    public DVDNaoEmprestadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DVDNaoEmprestadoException(Throwable cause) {
        super(cause);
    }

    public DVDNaoEmprestadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
