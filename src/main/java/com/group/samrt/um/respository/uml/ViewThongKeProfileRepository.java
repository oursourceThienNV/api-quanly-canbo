package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.dto.uml.ViewThongKeProfileDTO;
import com.group.samrt.um.domain.uml.ViewThongKeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViewThongKeProfileRepository extends JpaRepository<ViewThongKeProfile,Long>, JpaSpecificationExecutor<ViewThongKeProfile> {
    List<ViewThongKeProfile> findAllByNamSinhBetween(Long startYear, Long endYear);
}
