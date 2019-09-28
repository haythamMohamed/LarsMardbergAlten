package com.vehicle.tracking.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.vehicle.tracking.dto.SearchVechileDTO;
import com.vehicle.tracking.model.Vechile;

public class CustomVechileDAOImpl implements CustomVechileDAO{

	@PersistenceContext
    private EntityManager em;

	@Override
	public List<Vechile> searchForVechiles(SearchVechileDTO searchVechileDTO) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
	    CriteriaQuery<Vechile> cq = cb.createQuery(Vechile.class);
	 
	    Root<Vechile> vechile = cq.from(Vechile.class);
	    List<Predicate> predicates = new ArrayList<>();
	     
	    if(searchVechileDTO != null) {
	    	if (searchVechileDTO.getCustomer() != null) {
	    		predicates.add(cb.equal(vechile.get("customer"), searchVechileDTO.getCustomer().getId()));
	    	}
	    	if (searchVechileDTO.getStatus() != null) {
	    		predicates.add(cb.equal(vechile.get("lastStatus"), searchVechileDTO.getStatus()));
	    	}	    	
	    }
	    cq.where(predicates.toArray(new Predicate[0]));
	 
	    return em.createQuery(cq).getResultList();
	}
	
	
}
