
package edu.ifpb.dac.dac.jpa.consultas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author Emanuel Batista da Silva Filho
 */

@Entity
public class Faculdade implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "faculdade")
    private List<Empregado> empregados;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Empregado> getEmpregados() {
        return empregados;
    }

    public void setEmpregados(List<Empregado> empregados) {
        this.empregados = empregados;
    }
    
    
    
    
}
