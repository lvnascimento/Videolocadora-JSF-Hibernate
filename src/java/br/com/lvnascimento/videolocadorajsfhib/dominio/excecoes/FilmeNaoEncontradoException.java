package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Classe que encapsula uma exceção quando um filme não existe no banco de dados.
 * 
 * @author leonardo
 */
public class FilmeNaoEncontradoException extends Exception {

    public FilmeNaoEncontradoException() {
    }

    public FilmeNaoEncontradoException(String message) {
        super(message);
    }

    public FilmeNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FilmeNaoEncontradoException(Throwable cause) {
        super(cause);
    }

    public FilmeNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
