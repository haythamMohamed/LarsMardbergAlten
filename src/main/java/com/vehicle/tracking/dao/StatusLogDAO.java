package com.vehicle.tracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vehicle.tracking.model.StatusLog;

public interface StatusLogDAO extends JpaRepository<StatusLog, Long>{

}
