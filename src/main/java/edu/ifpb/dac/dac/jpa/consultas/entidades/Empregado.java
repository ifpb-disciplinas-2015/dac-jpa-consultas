
package edu.ifpb.dac.dac.jpa.consultas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
@NamedQueries({
        @NamedQuery(name = "empreado.todos",query = "SELECT e FROM Empregado e"),
        @NamedQuery(name = "empregado.id.1",query = "SELECT e FROM Empregado e WHERE e.id=1")})
@Entity
@SequenceGenerator(allocationSize = 1,name = "empregado",initialValue = 1,sequenceName = "empregado_seq")
public class Empregado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "empregado")
    private long id;
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependente> dependentes;
    @ManyToOne
    private Faculdade faculdade;
    @ManyToMany
    private List<Projeto> projetos;
    @OneToOne
    private Endereco endereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Faculdade getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(Faculdade faculdade) {
        this.faculdade = faculdade;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
    
    
}
