package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.Profile;
import com.group.samrt.um.domain.uml.QuaTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuaTrinhRepository extends JpaRepository<QuaTrinh,String>, JpaSpecificationExecutor<QuaTrinh> {
    Optional<QuaTrinh> findById(Long id);
    List<QuaTrinh> findAllByProfileId(Long id);
}
