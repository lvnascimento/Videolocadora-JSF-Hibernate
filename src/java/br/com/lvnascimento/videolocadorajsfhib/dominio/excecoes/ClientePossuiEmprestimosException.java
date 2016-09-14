package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Classe que encapsula uma exceção quando um cliente possui empréstimos.
 * 
 * @author leonardo
 */
public class ClientePossuiEmprestimosException extends Exception {

    public ClientePossuiEmprestimosException() {
    }

    public ClientePossuiEmprestimosException(String message) {
        super(message);
    }

    public ClientePossuiEmprestimosException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientePossuiEmprestimosException(Throwable cause) {
        super(cause);
    }

    public ClientePossuiEmprestimosException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
