package com.group.samrt.um.controller.uml;

import com.group.samrt.um.client.Common.Constant;
import com.group.samrt.um.client.client.request.QueryBaseRequestById;
import com.group.samrt.um.client.client.request.uml.*;
import com.group.samrt.um.client.client.response.BaseDataResponse;
import com.group.samrt.um.client.client.response.uml.*;
import com.group.samrt.um.domain.dto.uml.ViewThongKeProfileDTO;
import com.group.samrt.um.domain.uml.Profile;
import com.group.samrt.um.domain.uml.ViewThongKeProfile;
import com.group.samrt.um.filter.JwtTokenProvider;
import com.group.samrt.um.service.uml.CustomUserDetail;
import com.group.samrt.um.service.uml.ProfileService;
import com.group.samrt.um.service.uml.TranferProfileService;
import com.group.samrt.um.service.uml.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;
    @Autowired
    TranferProfileService tranferProfileService;
    @PostMapping("/profile/on-search")
    public ResponseEntity<BaseDataResponse<ProfileResponse>> onsearch(@Valid @RequestBody ProfileRequestSearch request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();

        ProfileResponse response=profileService.pageSearch(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/tranfer-profile/on-search")
    public ResponseEntity<BaseDataResponse<TranferProfileResponse>> onsearch(@Valid @RequestBody TranferProfileRequestSearch request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();

        TranferProfileResponse response=tranferProfileService.pageSearch(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/profile/create")
    public ResponseEntity<BaseDataResponse<Boolean>> authenticateUser(@Valid @RequestBody ProfileRequest profileRequest) {
        BaseDataResponse baseDataResponse=new BaseDataResponse();

        Boolean response = null;
        try {
            response = profileService.createUserForAdmin(profileRequest);
            baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
            baseDataResponse.setResponseMessage("Luu Thanh Cong");
            baseDataResponse.setBody(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/profile/get-profile-info")
    public ResponseEntity<BaseDataResponse<ProfileInfoResponse>> profileInforResponse(@Valid @RequestBody QueryBaseRequestById request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();

        ProfileInfoResponse response=profileService.getdetail(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/profile/find-all")
    public ResponseEntity<BaseDataResponse<List<Profile>>> listAllByStatus(){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        List<Profile> response=profileService.getListAll();
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/profile/thong-ke")
    public ResponseEntity<BaseDataResponse<ViewThongKeProfileDTO>> thongke(@Valid @RequestBody SearchDate searchDate){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        ViewThongKeProfileDTO response=tranferProfileService.getViewThongKeProfile(searchDate);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/tranfer-profile/create")
    public ResponseEntity<BaseDataResponse<TranferProfileResponse>> profileInforResponse(@Valid @RequestBody TranferProfileRequest request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        Boolean response=tranferProfileService.createAndUpdate(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/profile/delete")
    public ResponseEntity<BaseDataResponse<Boolean>> delete(@Valid @RequestBody QueryBaseRequestById request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        Boolean response=profileService.delete(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }
    @PostMapping("/tranfer-profile/delete")
    public ResponseEntity<BaseDataResponse<Boolean>> deleteTranfer(@Valid @RequestBody QueryBaseRequestById request){
        BaseDataResponse baseDataResponse = new BaseDataResponse();
        Boolean response=tranferProfileService.delete(request);
        baseDataResponse.setResponseCode(Constant.HTTP_ERROR.ERROR_SUCCESS);
        baseDataResponse.setResponseMessage("Detail Student By Class");
        baseDataResponse.setBody(response);
        return new ResponseEntity<>(baseDataResponse, HttpStatus.OK);
    }

}
