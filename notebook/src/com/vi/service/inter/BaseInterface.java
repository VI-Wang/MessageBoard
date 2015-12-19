package com.vi.service.inter;

public interface BaseInterface {
	//把一些通用的方法声明到该基础接口中
	
	//通过id来获取一个对象实例
	public Object findByIdOpenInView(Class clazz,java.io.Serializable id);
	//保存一个对象
	public void save(Object obj); 

}
