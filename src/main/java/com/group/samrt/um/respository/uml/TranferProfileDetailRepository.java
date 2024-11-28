package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.TranferProfile;
import com.group.samrt.um.domain.uml.TranferProfileDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TranferProfileDetailRepository extends JpaRepository<TranferProfileDetail,String>, JpaSpecificationExecutor<TranferProfileDetail> {
    Optional<TranferProfile> findById(Long id);

}
