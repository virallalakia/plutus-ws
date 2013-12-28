package com.voidmainworld.plutus.service.auth.impl;

import static com.voidmainworld.plutus.constant.PlutusContants.APP_JSON;
import static com.voidmainworld.plutus.constant.PlutusContants.APP_XML;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.voidmainworld.plutus.dao.user.User;
import com.voidmainworld.plutus.daoservice.user.UserService;
import com.voidmainworld.plutus.service.auth.AuthService;
import com.voidmainworld.plutus.vo.BaseResponseVO;
import com.voidmainworld.plutus.vo.BooleanVO;
import com.voidmainworld.plutus.vo.ErrorVO;
import com.voidmainworld.plutus.vo.user.UserVO;

@Path("/auth")
@Produces({ APP_JSON, APP_XML })
@Consumes({ APP_JSON, APP_XML })
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserService	userService;

	@POST
	@Path("/login")
	public BaseResponseVO auth(UserVO userVO) {
		User user = userService.getUser(userVO.getUsername());
		if (user == null || !userService.checkAuth(userVO.getUsername(), userVO.getPassword())) {
			return new BaseResponseVO(false, 401, ErrorVO.ERROR401);
		}
		return new BaseResponseVO(new UserVO(
				user.getId(),
				user.getUsername(),
				"",
				user.getCreatedDate().getTime(),
				user.getUpdatedDate().getTime()));
	}

	@POST
	@Path("/signup")
	public BaseResponseVO signup(UserVO userVO) {
		userService.addUser(new User(userVO.getUsername()), userVO.getPassword());
		User user = userService.getUser(userVO.getUsername());

		return new BaseResponseVO(new UserVO(
				user.getId(),
				user.getUsername(),
				"",
				user.getCreatedDate().getTime(),
				user.getUpdatedDate().getTime()));
	}

	@GET
	@Path("/checkuser/{username}")
	public BaseResponseVO checkUserExists(@PathParam("username") String username) {
		User user = userService.getUser(username);
		if (user != null) {
			return new BaseResponseVO(BooleanVO.TRUE);
		}
		return new BaseResponseVO(BooleanVO.FALSE);
	}

}
