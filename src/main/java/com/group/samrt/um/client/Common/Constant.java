package com.group.samrt.um.client.Common;

public interface Constant {
    public interface HTTP_ERROR {
        String ERROR_SUCCESS = "200"; // thanh cong
        String ERROR_ROLE = "403"; // k co quyen
        String ERROR_BAD_REQUEST = "400"; // loi
        String NOT_FOUND = "404"; // api k ton tai
    }

    public interface ROLE_USER {
        String ADMIN = "00"; // admin
        String NHANVIEN = "01"; // nha dau tu

    }
    public interface STATUS_USER {
        String PENDING = "00"; // cho duyet user
        String APPROVED = "01"; // da duyet user
        String EXPRIED = "02"; // het han dang ki
    }

    public interface STATUS_PROJECT {
        String NO_UPLOAD = "00"; // chua dang tai
        String UPLOADED = "01"; // da dang tai
        String RESULT="03"; // da co ket qua
        String OPENED="02"; // da mo thau
    }
    public interface STATUS_PROFILE {
        String CREATED = "00"; // tao ket qua
        String THOI_VIEC = "01"; // Đã thôi việc
        String NGHI_HUU = "03"; // Đã nghỉ hưu
        String CHUYEN_DEN = "04"; // Đã nghỉ hưu
        String CHUYEN_DI = "05"; // Đã nghỉ hưu
    }
    public interface STATUS_PROJECT_REGISTER {
        String SUBMITTED = "00"; // da nop ho so
        String OPENED = "01"; // da mo thau
        String WON_BID="02"; // trung thau
        String BID_SLIP="03"; // truot thau

    }
    public interface PAGE {
        int PAGE_NUMBER = 0;
        int PAGE_SIZE = 10;
    }

}
