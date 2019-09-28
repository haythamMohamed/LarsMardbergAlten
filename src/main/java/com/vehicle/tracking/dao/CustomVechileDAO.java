package com.vehicle.tracking.dao;

import java.util.List;

import com.vehicle.tracking.dto.SearchVechileDTO;
import com.vehicle.tracking.model.Vechile;

public interface CustomVechileDAO {

	List<Vechile> searchForVechiles(SearchVechileDTO searchVechileDTO);
}
