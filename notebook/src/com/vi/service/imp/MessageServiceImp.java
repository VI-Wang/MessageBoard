package com.vi.service.imp;

import java.util.List;

import com.vi.domain.Message;
import com.vi.domain.Users;
import com.vi.service.inter.MessageServiceInter;
import com.vi.util.HibernateUtil;

public class MessageServiceImp extends BaseServiceImp implements MessageServiceInter{
	//显示用户接收到的所有message
	public List<Message> showMessage(Users user)
	{
		String hql="from Message where getter.userId=? or getter.userId=4";
		String parameters[]={user.getUserId()+""};
		List<Message> messages=HibernateUtil.executeQueryOpenInView(hql, parameters);
		return messages;
	}
}
