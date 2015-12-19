package com.vi.service.inter;

import java.util.List;

import com.vi.domain.Message;
import com.vi.domain.Users;

public interface MessageServiceInter extends BaseInterface{
	public List<Message> showMessage(Users user);
	
}
