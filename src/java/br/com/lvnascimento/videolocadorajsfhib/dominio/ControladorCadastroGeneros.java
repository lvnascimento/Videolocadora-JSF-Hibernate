package br.com.lvnascimento.videolocadorajsfhib.dominio;

import br.com.lvnascimento.videolocadorajsfhib.persistencia.GeneroDAO;

/**
 * Classe que implementa o padrão GRASP "Controlador" para os casos de uso relacionados ao
 * cadastro de gêneros (Incluir Gênero, Modificar Gênero, Excluir Gênero, Consultar Gêneros).
 * 
 * @author leonardo
 */
public class ControladorCadastroGeneros {
    private final GeneroDAO dao;
    
    public ControladorCadastroGeneros() {
        this.dao = new GeneroDAO();
    }
    
    public void salvarGenero(Genero g) {
        dao.salvar(g);
    }
}
