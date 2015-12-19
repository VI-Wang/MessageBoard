package com.vi.service.imp;

import java.io.Serializable;

import com.vi.service.inter.BaseInterface;
import com.vi.util.HibernateUtil;

public abstract class BaseServiceImp implements BaseInterface {

	public Object findByIdOpenInView(Class arg0,java.io.Serializable arg1){
		return HibernateUtil.findByIdOpenInView(arg0, arg1);
	}
	public void save(Object obj){
		try{
			HibernateUtil.save(obj);
		}catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
}
