package com.group.samrt.um.service.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.client.client.request.QueryBaseRequestById;
import com.group.samrt.um.client.client.request.uml.*;
import com.group.samrt.um.client.client.response.uml.*;
import com.group.samrt.um.domain.dto.uml.ProfileDTO;
import com.group.samrt.um.domain.dto.uml.UserAdminDetailDTO;
import com.group.samrt.um.domain.dto.uml.UserDetailDTO;
import com.group.samrt.um.domain.uml.*;
import com.group.samrt.um.respository.uml.AdminUserRepository;
import com.group.samrt.um.respository.uml.ProfileRepository;
import com.group.samrt.um.respository.uml.QuaTrinhRepository;
import io.github.jhipster.service.QueryService;
import io.github.jhipster.service.filter.StringFilter;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class ProfileService extends QueryService<Profile> {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AdminUserRepository adminUserRepository;
    @Autowired
    QuaTrinhRepository quaTrinhRepository;

    @Transactional(readOnly = true)
    public ProfileResponse pageSearch(ProfileRequestSearch request) throws ServiceException {
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
            Specification<Profile> specification = createSpecification(request);
            Sort sort = Sort.by(Sort.Order.desc("id"));
            Page<ProfileDTO> queryResults = this.profileRepository.findAll(
                    specification, PageRequest.of(request.getPageNumber(), request.getPageSize(), sort)
            ).map(ProfileDTO::new);
            ProfileResponse response = new ProfileResponse();
            response.setPage(OptimizedPage.convert(queryResults));

            return response;
        } catch (Exception e) {
            throw e;
        }
    }

    protected Specification<Profile> createSpecification(ProfileRequestSearch criteria) {

        Specification<Profile> specification = Specification.where(null);
        if (criteria.getCode() != null) {
            specification = specification.and(buildStringSpecification(criteria.getCode(), Profile_.code));
        }
        if (criteria.getFullname() != null) {
            specification = specification.and(buildStringSpecification(criteria.getFullname(), Profile_.fullname));
        }
        if (criteria.getGender() != null) {
            specification = specification.and(buildStringSpecification(criteria.getGender(), Profile_.gender));
        }
        if (criteria.getDantoc() != null) {
            specification = specification.and(buildStringSpecification(criteria.getDantoc(), Profile_.dan_toc));
        }
        return specification;
    }

    public Boolean createUserForAdmin(ProfileRequest profileRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AdminUser session = adminUserRepository.findByUsername(userDetails.getUsername());
        if (profileRequest.getId() != null) {
            Optional<Profile> check = profileRepository.findById(profileRequest.getId());
            if (check.isPresent()) {
                Profile profile = check.get();
                ModelMapper mn = new ModelMapper();
                profile = mn.map(profileRequest, Profile.class);
                profile.setUpdateBy(session.getId());
                profile.setUpdateDt(Instant.now());
                profile.setStatus(Constant.STATUS_PROFILE.CREATED);
                profileRepository.save(profile);
                List<QuaTrinh> list = this.quaTrinhRepository.findAllByProfileId(profile.getId());
                this.quaTrinhRepository.deleteAll(list);
                for (QuaTrinh quaTrinh : profileRequest.danh_sach_qt) {
                    quaTrinh.setProfileId(profile.getId());
                    this.quaTrinhRepository.save(quaTrinh);
                }
                return true;
            } else {
                return false;
            }
        } else if (profileRequest.getId() == null) {
            Optional<Profile> check=profileRepository.findAllByCode(profileRequest.getCode());
            if(check.isPresent()){
                return false;
            }
            ModelMapper modelMapper = new ModelMapper();
            Profile profile = modelMapper.map(profileRequest, Profile.class);
            profile.setCreateBy(session.getId());
            profile.setCreateDt(Instant.now());
            profile.setUpdateDt(Instant.now());
            profile.setUpdateBy(session.getId());
            profile.setStatus(Constant.STATUS_PROFILE.CREATED);
            profileRepository.save(profile);
            for (QuaTrinh quaTrinh : profileRequest.danh_sach_qt) {
                quaTrinh.setProfileId(profile.getId());
                this.quaTrinhRepository.save(quaTrinh);
            }
            return true;
        }
        return true;
    }
    public ProfileInfoResponse getdetail(QueryBaseRequestById request){
        ProfileInfoResponse response=new ProfileInfoResponse();
        Profile profile=this.profileRepository.findById(request.getId()).get();
        ModelMapper modelMapper = new ModelMapper();
        response=modelMapper.map(profile,ProfileInfoResponse.class);
        List<QuaTrinh> lts=new ArrayList<>();
        lts=this.quaTrinhRepository.findAllByProfileId(response.getId());
        response.setDanh_sach_qt(lts);
        return response;
    }
    public Boolean delete(QueryBaseRequestById request){
        try{
           Profile profile=this.profileRepository.findById(request.getId()).get();
           this.profileRepository.delete(profile);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    public List<Profile> getListAll(){
        Profile response=new Profile();
        List<Profile> profile=this.profileRepository.findAll();
        return profile;
    }
}
