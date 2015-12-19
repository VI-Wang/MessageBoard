package com.vi.service.inter;

import java.util.List;

import com.vi.domain.Users;

public interface UsersServiceInter extends BaseInterface{
	//这里定义方法
	public Users checkUser(Users user);
	public List getUserList(Users user);
	//通过用户名和id获取user
	public Users getUser(String userId);
	
}
