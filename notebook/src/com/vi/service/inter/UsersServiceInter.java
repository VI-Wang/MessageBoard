package com.vi.service.inter;

import java.util.List;

import com.vi.domain.Users;

public interface UsersServiceInter extends BaseInterface{
	//���ﶨ�巽��
	public Users checkUser(Users user);
	public List getUserList(Users user);
	//ͨ���û�����id��ȡuser
	public Users getUser(String userId);
	
}
