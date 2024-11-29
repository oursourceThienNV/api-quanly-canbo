package com.group.samrt.um.service.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.client.client.request.QueryBaseRequestById;
import com.group.samrt.um.client.client.request.uml.*;
import com.group.samrt.um.client.client.response.uml.ProfileInfoResponse;
import com.group.samrt.um.client.client.response.uml.ProfileResponse;
import com.group.samrt.um.client.client.response.uml.TranferProfileResponse;
import com.group.samrt.um.domain.dto.uml.ProfileDTO;
import com.group.samrt.um.domain.dto.uml.TranferProfileDTO;
import com.group.samrt.um.domain.dto.uml.TranferProfileDetailDTO;
import com.group.samrt.um.domain.dto.uml.ViewThongKeProfileDTO;
import com.group.samrt.um.domain.uml.*;
import com.group.samrt.um.respository.uml.*;
import io.github.jhipster.service.QueryService;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class TranferProfileService extends QueryService<TranferProfileDetail> {
    @Autowired
    TranferProfileRepository tranferProfileRepository;
    @Autowired
    TranferProfileDetailRepository tranferProfileDetailRepository;
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AdminUserRepository adminUserRepository;
    @Autowired
    ViewThongKeProfileRepository viewThongKeProfileRepository;

    @Transactional(readOnly = true)
    public TranferProfileResponse pageSearch(TranferProfileRequestSearch request) throws ServiceException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser user = adminUserRepository.findByUsername(userDetails.getUsername());
//        if(user==null)
//            return null;
//        if(!user.getRole().equals(Constant.ROLE_USER.ADMIN)){
//            StringFilter userlogin=new StringFilter();
//            userlogin.setEquals(userDetails.getUsername());
//            request.setUsername(userlogin);
//        }
        try {
            if (request == null)
                return null;

            if (request.getPageNumber() < Constant.PAGE.PAGE_NUMBER)
                request.setPageNumber(Constant.PAGE.PAGE_NUMBER);

            if (request.getPageSize() < 1)
                request.setPageSize(Constant.PAGE.PAGE_SIZE);
            Specification<TranferProfileDetail> specification = createSpecification(request);
            Sort sort = Sort.by(Sort.Order.desc("id"));
            Page<TranferProfileDetailDTO> queryResults = this.tranferProfileDetailRepository.findAll(
                    specification, PageRequest.of(request.getPageNumber(), request.getPageSize(), sort)
            ).map(TranferProfileDetailDTO::new);
            TranferProfileResponse response = new TranferProfileResponse();
            response.setPage(OptimizedPage.convert(queryResults));

            return response;
        } catch (Exception e) {
            throw e;
        }
    }

    protected Specification<TranferProfileDetail> createSpecification(TranferProfileRequestSearch criteria) {

        Specification<TranferProfileDetail> specification = Specification.where(null);
        if (criteria.getCode() != null) {
            specification = specification.and(buildStringSpecification(criteria.getCode(), TranferProfileDetail_.code));
        }
        if (criteria.getFullname() != null) {
            specification = specification.and(buildStringSpecification(criteria.getFullname(), TranferProfileDetail_.fullname));
        }
        if (criteria.getType()!=null){
            specification = specification.and(buildStringSpecification(criteria.getType(), TranferProfileDetail_.type));
        }
        if (criteria.getStatus()!=null){
            specification = specification.and(buildStringSpecification(criteria.getStatus(), TranferProfileDetail_.status));
        }
        return specification;
    }

    public Boolean createAndUpdate(TranferProfileRequest tranferProfileRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
        if (tranferProfileRequest.getId() != null) {
            Optional<TranferProfile> check = tranferProfileRepository.findById(tranferProfileRequest.getId());
            if (check.isPresent()) {
                TranferProfile tranferProfile = check.get();
                ModelMapper mn = new ModelMapper();
                tranferProfile = mn.map(tranferProfileRequest, TranferProfile.class);
                tranferProfileRepository.save(tranferProfile);
                Optional<Profile> profile=profileRepository.findById(tranferProfileRequest.getProfile_id());
                profile.get().setStatus(tranferProfile.getStatus());
                this.profileRepository.save(profile.get());
                return true;
            } else {
                return false;
            }
        } else if (tranferProfileRequest.getId() == null) {
            ModelMapper modelMapper = new ModelMapper();
            TranferProfile tranferProfile = modelMapper.map(tranferProfileRequest, TranferProfile.class);
            tranferProfileRepository.save(tranferProfile);
            Optional<Profile> profile=profileRepository.findById(tranferProfileRequest.getProfile_id());
            profile.get().setStatus(tranferProfile.getStatus());
            this.profileRepository.save(profile.get());
            return true;
        }
        return true;
    }
    public ViewThongKeProfileDTO getViewThongKeProfile(SearchDate request){
        Object[] list=this.profileRepository.findProfileStatisticsByNamSinhRange(request.getStartYear(),request.getEndYear());
        ViewThongKeProfileDTO dto = new ViewThongKeProfileDTO();
        if (list.length > 0 && list[0] instanceof Object[]) {
            Object[] nestedArray = (Object[]) list[0];

            // Trích xuất từng giá trị
            dto.setTong(nestedArray[0] != null ? ((Number) nestedArray[0]).longValue() : null);
            dto.setSo_nam(nestedArray[1] != null ? ((Number) nestedArray[1]).longValue() : null);
            dto.setSo_nu(nestedArray[1] != null ? ((Number) nestedArray[2]).longValue() : null);
            dto.setSo_kinh(nestedArray[2] != null ? ((Number) nestedArray[3]).longValue() : null);
            dto.setSo_khmer(nestedArray[2] != null ? ((Number) nestedArray[4]).longValue() : null);
           dto.setSo_hoa(nestedArray[2] != null ? ((Number) nestedArray[5]).longValue() : null);
            dto.setSo_cham(nestedArray[2] != null ? ((Number) nestedArray[6]).longValue() : null);
            dto.setSo_khac(nestedArray[2] != null ? ((Number) nestedArray[7]).longValue() : null);

        }
        return dto;
    }
    public List<Profile> getListByStatus(ProfileRequestStatus request){
        Profile response=new Profile();
        List<Profile> profile=this.profileRepository.findAllByStatus(request.getStatus());
        return profile;
    }
    public Boolean delete(QueryBaseRequestById request){
        try{
            TranferProfile profile=this.tranferProfileRepository.findById(request.getId()).get();
            this.tranferProfileRepository.delete(profile);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
