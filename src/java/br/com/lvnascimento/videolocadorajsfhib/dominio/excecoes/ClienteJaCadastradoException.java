package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Classe que encapsula uma exceção quando um cliente já existe no banco de dados.
 * 
 * @author leonardo
 */
public class ClienteJaCadastradoException extends Exception {

    public ClienteJaCadastradoException() {
    }

    public ClienteJaCadastradoException(String message) {
        super(message);
    }

    public ClienteJaCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteJaCadastradoException(Throwable cause) {
        super(cause);
    }

    public ClienteJaCadastradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
