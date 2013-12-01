package com.voidmainworld.plutus.service.auth;

import com.voidmainworld.plutus.vo.BaseResponseVO;
import com.voidmainworld.plutus.vo.user.UserVO;

public interface AuthService {

	BaseResponseVO auth(UserVO user);

	BaseResponseVO signup(UserVO user);

	BaseResponseVO checkUserExists(String username);

}
