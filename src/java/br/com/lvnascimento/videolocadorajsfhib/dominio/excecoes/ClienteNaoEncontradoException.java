package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Classe que encapsula uma exceção quando um cliente não é encontrado em uma operação de busca.
 * 
 * @author Leonardo
 */
public class ClienteNaoEncontradoException extends Exception {

    public ClienteNaoEncontradoException() {
    }

    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteNaoEncontradoException(Throwable cause) {
        super(cause);
    }

    public ClienteNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
