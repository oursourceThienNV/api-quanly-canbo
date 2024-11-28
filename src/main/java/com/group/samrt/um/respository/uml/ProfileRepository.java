package com.group.samrt.um.respository.uml;

import com.group.samrt.um.domain.uml.AdminUser;
import com.group.samrt.um.domain.uml.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,String>, JpaSpecificationExecutor<Profile> {
    Optional<Profile> findById(Long id);

    Optional<Profile> findAllByCode(String code);

    List<Profile> findAllByStatus(String status);

    @Query(value = "SELECT "
            + "COUNT(*) AS tong_so_luong, "
            + "SUM(so_nam) AS so_nam, "
            + "SUM(so_nu) AS so_nu, "
            + "SUM(so_kinh) AS so_kinh, "
            + "SUM(so_khmer) AS so_khmer, "
            + "SUM(so_hoa) AS so_hoa, "
            + "SUM(so_cham) AS so_cham, "
            + "SUM(so_khac) AS so_khac "
            + "FROM view_thong_ke_profile p "
            + "WHERE nam_sinh BETWEEN :startYear AND :endYear", nativeQuery = true)
    Object[] findProfileStatisticsByNamSinhRange(@Param("startYear") Integer startYear,
                                                       @Param("endYear") Integer endYear);


}


