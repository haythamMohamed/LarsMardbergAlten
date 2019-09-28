package com.vehicle.tracking.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vehicle.tracking.dao.StatusLogDAO;
import com.vehicle.tracking.dao.VechileDAO;
import com.vehicle.tracking.dto.SearchVechileDTO;
import com.vehicle.tracking.model.Status;
import com.vehicle.tracking.model.StatusLog;
import com.vehicle.tracking.model.Vechile;

@Service
@Transactional
public class VechileService {

	@Autowired VechileDAO vechileDAO;
	@Autowired StatusLogDAO statusLogDAO;
	
	public List<Vechile> searchForVechiles(SearchVechileDTO searchVechileDTO){
		return vechileDAO.searchForVechiles(searchVechileDTO);
	}
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void generateRandomStatuses () {
		List<Vechile> vechiles = vechileDAO.findAll();
		
		if(vechiles != null) {
			vechiles.forEach(v -> {
				Status status = Status.randomStatus() ;
				
				StatusLog statusLog = new StatusLog();
				statusLog.setLogDate(new Date());
				statusLog.setStatus(status);
				statusLog.setVechile(v);
				statusLogDAO.save(statusLog);
				
				vechileDAO.updateStatus(v.getId(), status);
				
			});
		}
	}
}
