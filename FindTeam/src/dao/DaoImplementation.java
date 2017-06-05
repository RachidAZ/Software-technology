package dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

import metier.Admin;
import metier.Like;
import metier.member;
import metier.project;

public class DaoImplementation implements IDao {

	
	public void addProject(project p) {
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
		 session.beginTransaction();
		 session.save(p);
		session.getTransaction().commit();
		
		 
		
	}

	
	public List<project> getProjects(Admin admin) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		 session.beginTransaction();
		 
		Query req=session.createQuery("select p from project p");
		
		return req.list();
		
	}

	@Override
	public List<project> getProjects(String descri) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		 session.beginTransaction();
		 
		 
		
		Query req=session.createQuery("select p from project p where p.Description like :x");
		req.setParameter("x","%"+descri+"%");
		return req.list();
		
		
	}

	@Override
	public void deleteProject(int id_project) {
			
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		project u=(project) session.get(project.class, id_project);
		session.delete(u);	
		session.getTransaction().commit();
	}

	@Override
	public void addMember(member memberA) {
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
		 session.beginTransaction();
		 session.save(memberA);
		 session.getTransaction().commit();
		 
	}

	@Override
	public List<member> getMembers() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		 session.beginTransaction();
		
		Query req=session.createQuery("select m from member m");
		
		return req.list();
		
		
		
	}

	

	@Override
	public void deleteMember(int id_member) {
		
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 
		
		 session.beginTransaction();
			
		
		member m=(member) session.get(member.class, id_member);
		session.delete(m);	
		
		session.getTransaction().commit();
		
	}

	@Override
	public void UpdateMember( member newMember) {
		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		session.update(newMember);
		session.getTransaction().commit();
		
		
		
	}

	@Override
	public void doMatch(Like like) {
		
		
		Like l=(Like) HibernateUtil.getSessionFactory().getCurrentSession().get(Like.class, like.getLikeID());
		
		l.setIsMatch('Y');
		
				
		
	}

	@Override
	public void addLike(Like like) {
		

		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			
		 session.beginTransaction();
		 session.save(like);
		 session.getTransaction().commit();
		 
		 
		
	}

	@Override
	public List<Like> getLikes() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		 session.beginTransaction();
		 
		Query req=session.createQuery("select l from Like l");
		
		return req.list();
		
		
		
		
		
	}


	
	public List<Admin> getAdmins() {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		 session.beginTransaction();
		
		Query req=session.createQuery("select a from Admin a");
		
		return req.list();
		
		
	}


	
	public member getMember(int id_member) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
		session.beginTransaction();		
		member M=(member)session.load(member.class, id_member);
		
		return M;
				
		
	}


	
	public project getProjectById(int id_project) {
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
		session.beginTransaction();		
		project P=(project)session.load(project.class, id_project);
		
		return P;
				
		
	}


	
	public void UpdateProject(project p) {

	
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		
	}


	@Override
	public void UpdateLike(Like like) {
		

		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		session.update(like);
		session.getTransaction().commit();
		
		
		
	}



	public void deleteLike(int id_like) {

		
		 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 session.beginTransaction();
		 Like u=(Like) session.get(Like.class, id_like);
		session.delete(u);	
		session.getTransaction().commit();
		
	}
	
	

}
