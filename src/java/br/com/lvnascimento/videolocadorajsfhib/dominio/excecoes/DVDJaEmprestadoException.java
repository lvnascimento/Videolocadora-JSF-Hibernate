package br.com.lvnascimento.videolocadorajsfhib.dominio.excecoes;

/**
 * Exceção usada ao se tentar emprestar um DVD que já se encontra emprestado.
 * 
 * @author Leonardo
 */
public class DVDJaEmprestadoException extends Exception {

    public DVDJaEmprestadoException() {
    }

    public DVDJaEmprestadoException(String message) {
        super(message);
    }

    public DVDJaEmprestadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DVDJaEmprestadoException(Throwable cause) {
        super(cause);
    }

    public DVDJaEmprestadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
