
package edu.ifpb.dac.dac.jpa.consultas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
@Entity
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String descricao;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "projetos")
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
