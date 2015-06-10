/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.dac.jpa.consultas.consultas;

import edu.ifpb.dac.dac.jpa.consultas.entidades.Empregado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author emanuel
 */
public class MainCriteria {

    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("edu.ifpb.dac_dac-jpa-consultas_jar_1.0-SNAPSHOTPU").createEntityManager();
        CriteriaBuilder build = em.getCriteriaBuilder();

        //comsulta 1
        CriteriaQuery<Empregado> criteria = build.createQuery(Empregado.class);
        Root<Empregado> root = criteria.from(Empregado.class);
        criteria.select(root);

        TypedQuery<Empregado> query = em.createQuery(criteria);

        List<Empregado> lista = query.getResultList();
        lista.forEach(x -> System.out.println(x));

        //comsulta 2
        criteria.select(root).where(build.equal(root.get("id"), 1));
        TypedQuery<Empregado> query1 = em.createQuery(criteria);
        Empregado empregado = query1.getSingleResult();
        System.out.println(empregado);

        //consulta 3
        criteria.select(root).where(build.and(build.equal(root.get("id"), 1), build.equal(root.get("nome"), "Ricardo Job")));
        TypedQuery<Empregado> query2 = em.createQuery(criteria);
        Empregado empregado1 = query2.getSingleResult();
        System.out.println(empregado1);

        //comsulta 4
        criteria.select(root);

        TypedQuery<Empregado> query3 = em.createQuery(criteria);

        query3.setMaxResults(2).setFirstResult(2);
        List<Empregado> lista1 = query3.getResultList();
        lista1.forEach(x -> System.out.println(x));

        
        //consulta 5
        CriteriaQuery<String> criteriaString=build.createQuery(String.class);
        criteriaString.select(root.get("nome"));
        TypedQuery<String> query4=em.createQuery(criteriaString);
        List<String> lista2=query4.getResultList();
        lista2.forEach(x->System.out.println(x));
        
        //consulta 6
        CriteriaQuery<Tuple> criteriaTuple=build.createQuery(Tuple.class);
        criteriaTuple.select(build.tuple(root.get("nome").alias("nome"),root.get("id").alias("id")));
        TypedQuery<Tuple> query5=em.createQuery(criteriaTuple);
        Tuple tuple=query5.getSingleResult();
        System.out.println(tuple.get("nome")+" "+tuple.get("id"));
        
    }
}
