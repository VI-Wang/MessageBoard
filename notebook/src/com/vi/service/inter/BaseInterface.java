package com.vi.service.inter;

public interface BaseInterface {
	//��һЩͨ�õķ����������û����ӿ���
	
	//ͨ��id����ȡһ������ʵ��
	public Object findByIdOpenInView(Class clazz,java.io.Serializable id);
	//����һ������
	public void save(Object obj); 

}
