package com.happynewyeara.service;

import com.happynewyeara.common.ResultJson;

public interface login_service {
    public ResultJson login(String phone_num, String code);
}
