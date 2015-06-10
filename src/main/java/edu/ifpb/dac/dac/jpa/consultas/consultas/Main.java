package edu.ifpb.dac.dac.jpa.consultas.consultas;

import edu.ifpb.dac.dac.jpa.consultas.entidades.Dependente;
import edu.ifpb.dac.dac.jpa.consultas.entidades.Empregado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Emanuel Batista da Silva Filho
 */
public class Main {

    public static void main(String[] args) {
        EntityManager entityManager = createEntityManager();

        Empregado em=new Empregado();
        List<Dependente> lisDep=new ArrayList<>();
        Dependente dep=new Dependente();
        dep.setNome("Jose");
        lisDep.add(dep);
        em.setDependentes(lisDep);
        em.setNome("Emanuel");
        EntityTransaction et=entityManager.getTransaction();
        et.begin();
        entityManager.persist(em);
        et.commit();
//        Consulta 15
//        Query query1 = entityManager.createQuery("SELECT e FROM Empregado e JOIN e.dependentes d WHERE UPPER(d.nome) LIKE '%_A%'", Empregado.class);
//        List<Empregado> listaEmpregaado = query1.getResultList();
//        listaEmpregaado.forEach(x -> System.out.println("Consulta 1: " + x));
//
//        //Consulta 16
//        Query query2 = entityManager.createQuery("SELECT UPPER(e.nome) FROM Empregado e JOIN e.dependentes d", String.class);
//        List<String> listaString = query2.getResultList();
//        listaString.forEach(x -> System.out.println("Consulta 2: " + x));
//
//        //Consulta 17
//        Query query3 = entityManager.createQuery("SELECT COUNT(e) quantidade FROM Empregado e", Long.class);
//        Long quant = (Long) query3.getSingleResult();
//        System.out.println("Consulta 3: " + quant);
//
//        //Consulta 18
//        Query query4 = entityManager.createQuery("SELECT e FROM Empregado e ORDER BY e.nome ASC", Empregado.class);
//        listaEmpregaado = query4.getResultList();
//        listaEmpregaado.forEach(x -> System.out.println("Consulta 4: " + x));
//
//        //Consulta 19
//        Query query5 = entityManager.createQuery("SELECT e.nome,COUNT(d) quant_dep FROM Empregado e LEFT JOIN e.dependentes d GROUP BY e.nome");
//        List<Object[]> listaObject = query5.getResultList();
//        listaObject.forEach(x -> System.out.println("Consulta 5: " + x[0]+", "+x[1]));
//        
//        //Consulta 20
//        Query query6=entityManager.createQuery("SELECT e.nome FROM Empregado e WHERE e.id>(SELECT AVG(e1.id) media FROM Empregado e1)");
//        listaString=query6.getResultList();
//        listaString.forEach(x->System.out.println("Consulta 6: "+x));
//        
//        //Consulta 21
//        Query query7=entityManager.createQuery("SELECT e FROM Empregado e JOIN e.dependentes d WHERE d.id>2");
//        listaEmpregaado=query7.getResultList();
//        listaEmpregaado.forEach(x->System.out.println("Consulta 7: "+x));
//        
//        //Consulta 23
//        Query query8=entityManager.createQuery("SELECT e FROM Empregado e WHERE e.nome<>:nome");
//        listaEmpregaado=query8.setParameter("nome", "Emanuel").getResultList();
//        listaEmpregaado.forEach(x->System.out.println("Consulta 8: "+x));
        
    }

    public static EntityManager createEntityManager() {
        return Persistence.
                createEntityManagerFactory("edu.ifpb.dac_dac-jpa-consultas_jar_1.0-SNAPSHOTPU").
                createEntityManager();
    }

}
