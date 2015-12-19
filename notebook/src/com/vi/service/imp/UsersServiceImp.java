package com.vi.service.imp;

import java.util.List;

import com.vi.domain.Users;
import com.vi.service.inter.UsersServiceInter;
import com.vi.util.HibernateUtil;
import com.vi.util.MyTools;

//����һ��ҵ����࣬��ɶ�users����ĸ��ֲ���
public class UsersServiceImp extends BaseServiceImp implements UsersServiceInter{
	//��֤�û��ķ�ʽ
	/**
	 * @author vi
	 * @param user
	 * @return user
	 * @function qualify login
	 */
	public Users checkUser(Users user)
	{
		String hql="from Users where userId=? and password=?";
		String parameters[]={user.getUserId()+"",MyTools.MD5(user.getPassword())};
		//��������hibernate��³���ԣ����ö��η�װ��
		List<Users> list=HibernateUtil.executeQuery(hql, parameters);
		if(list.size()==0)
		{
			return null;
		}else{
			return list.get(0);
		}
	}
	
	public List getUserList(Users user)
	{
		String hql="from Users where userId not in (?)";
		String parameters[]={user.getUserId()+""};
		//��������hibernate��³���ԣ����ö��η�װ��
		List<Users> list=HibernateUtil.executeQuery(hql, parameters);
		if(list.size()==0)
		{
			return null;
		}else{
			return list;
		}
	}

	@Override
	public Users getUser(String userId) {
		// TODO Auto-generated method stub
		Users user=null;
		String hql="from Users where userId=?";
		String parameters[]={userId};
		try{
			user=(Users)HibernateUtil.uniqueQueryOpenInView(hql, parameters);
		}catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
		return user;
	}
	
}
