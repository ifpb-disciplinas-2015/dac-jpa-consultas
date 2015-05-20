
package edu.ifpb.dac.dac.jpa.consultas.entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 *
 * @author Emanuel Batista da Silva Filho
 */

@Entity
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String rua,bairro;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "endereco")
    private Empregado empregado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public void setEmpregado(Empregado empregado) {
        this.empregado = empregado;
    }
    
    
    
}
