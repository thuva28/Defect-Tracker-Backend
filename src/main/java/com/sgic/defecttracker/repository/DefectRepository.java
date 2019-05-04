package com.sgic.defecttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sgic.defecttracker.model.Defect;

@Repository
public interface DefectRepository  extends JpaRepository<Defect, Long> {
	Defect findDefectById(Long id);

}
