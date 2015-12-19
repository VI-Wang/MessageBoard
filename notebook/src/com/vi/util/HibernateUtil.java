package com.vi.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

final public class HibernateUtil {
	private static SessionFactory sessionFactory=null;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	
	private HibernateUtil()
	{
	}
	static{
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	//获取全新的session(opensession)
	public static Session openSession()
	{
		return sessionFactory.openSession();
	}
	//返回跟线程关联的session
	public static Session getCurrentSession()
	{
		Session session=threadLocal.get();
		if(session==null)
		{
			//创建一个
			session=sessionFactory.openSession();
			//放入threadLocal
			threadLocal.set(session);
		}
		return session;
		
	}
	public static void closeSessionFactory()
	{
		sessionFactory.close();
	}
	public static void closeCurrentSession()
	{
		Session s=getCurrentSession();
		if(s!=null&&s.isOpen())
		{
			s.close();
			threadLocal.set(null);
		}
	}
	
	public static Object findById(Class arg0,java.io.Serializable arg1)
	{
		Session session=null;
		Transaction ts=null;
		Object obj=null;
		try{
			session=openSession();
			ts=session.beginTransaction();
			obj=session.load(arg0, arg1);
			ts.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(ts!=null)
			{
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen())
			{
				session.close();
			}
		}
		return obj;
	}
	
	public static Object findByIdOpenInView(Class arg0,java.io.Serializable arg1)
	{
		Session session=getCurrentSession();
		Object obj=session.load(arg0, arg1);
		return obj;
	}
	
	
	
	//批量
	public static void executeUpdate(String hql,String []parameters)
	{
		Session session=null;
		Transaction ts=null;
		Query query=null;
		try{
			session=openSession();
			ts=session.beginTransaction();
			query=session.createQuery(hql);
			if(parameters!=null&&parameters.length>0)
			{
				for(int i=0;i<parameters.length;i++)
				{
					query.setString(i, parameters[i]);
				}
			}
			query.executeUpdate();
			ts.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(ts!=null)
			{
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen())
			{
				session.close();
			}
		}
	}
	
	
	public static void save(Object obj)
	{
		Session session=null;
		Transaction ts=null;
		Query query=null;
		try{
			session=openSession();
			ts=session.beginTransaction();
			session.save(obj);
			ts.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(ts!=null)
			{
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen())
			{
				session.close();
			}
		}
	}
	
	//带分页
	public static List excuteQueryByPage(String hql,String[]parameters,int pageSize,int pageNow)
	{
		Session session=null;
		Transaction ts=null;
		Query query=null;
		List list=null;
		try{
			session=openSession();
			ts=session.beginTransaction();
			query=session.createQuery(hql);
			if(parameters!=null&&parameters.length>0)
			{
				for(int i=0;i<parameters.length;i++)
				{
					query.setString(i, parameters[i]);
				}
			}
			query.setFirstResult((pageNow-1)*pageSize);
			query.setMaxResults(pageSize);
			list=query.list();
			ts.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(ts!=null)
			{
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen())
			{
				session.close();
			}
		}
		return list;
	}
	public static List excuteQueryByPageOpenInView(String hql,String[]parameters,int pageSize,int pageNow)
	{
		Session session=getCurrentSession();
		Query query=session.createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setString(i, parameters[i]);
			}
		}
		query.setFirstResult((pageNow-1)*pageSize);
		query.setMaxResults(pageSize);
		List list=query.list();
		return list;
	}
	
	public static List executeQuery(String hql,String[] parameters)
	{
		Session session=null;
		Transaction ts=null;
		Query query=null;
		List list=null;
		try{
			session=openSession();
			ts=session.beginTransaction();
			query=session.createQuery(hql);
			if(parameters!=null&&parameters.length>0)
			{
				for(int i=0;i<parameters.length;i++)
				{
					query.setString(i, parameters[i]);
				}
			}
			list=query.list();
			ts.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			if(ts!=null)
			{
				ts.rollback();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen())
			{
				session.close();
			}
		}
		return list;
		
	}
	public static List executeQueryOpenInView(String hql,String[] parameters)
	{
		Session session=getCurrentSession();
		
		Query query=session.createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setString(i, parameters[i]);
			}
		}
		List list=query.list();
		return list;
		
	}
	
	public static Object uniqueQueryOpenInView(String hql,String[] parameters)
	{
		Session session=getCurrentSession();
		
		Query query=session.createQuery(hql);
		if(parameters!=null&&parameters.length>0)
		{
			for(int i=0;i<parameters.length;i++)
			{
				query.setString(i, parameters[i]);
			}
		}
		Object obj=query.uniqueResult();
		return obj;
		
	}
	
	
	

}
