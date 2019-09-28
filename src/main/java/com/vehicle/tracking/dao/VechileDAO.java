package com.vehicle.tracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vehicle.tracking.model.Status;
import com.vehicle.tracking.model.Vechile;

@Repository
public interface VechileDAO extends JpaRepository<Vechile, Integer> , CustomVechileDAO{

	@Query("UPDATE Vechile v SET v.lastStatus =:status WHERE v.id =:id")
	@Modifying
	void updateStatus (@Param(value = "id")Integer id , @Param(value = "status")Status status);
}
