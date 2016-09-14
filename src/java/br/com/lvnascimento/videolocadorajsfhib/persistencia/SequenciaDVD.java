package br.com.lvnascimento.videolocadorajsfhib.persistencia;

/**
 * Classe de modelo para a sequência de valores para geração de códigos de DVDs.
 * 
 * @author leonardo
 */
public class SequenciaDVD {
    private int id;
    private int proximoIdDVD;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProximoIdDVD() {
        return proximoIdDVD;
    }

    public void setProximoIdDVD(int proximoIdDVD) {
        this.proximoIdDVD = proximoIdDVD;
    }

    public void incrProximoIdDVD() {
        proximoIdDVD++;
    }
}
