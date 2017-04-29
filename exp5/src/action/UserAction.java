package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

import entity.User;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -5829221114435987141L;
	private UserDao userDao;
	private User user;
	private List<User> listUser = new ArrayList<User>();
	
	//��¼
	public String login() throws Exception{
		boolean b = userDao.login(user);
		if(b){
			ServletActionContext.getRequest().setAttribute("user", user);
			return "success";
		}
		ServletActionContext.getRequest().setAttribute("msg", "��¼ʧ�ܣ���");
		return "index";
	}

	//�õ�ȫ���û�
	public String listUI() throws Exception{
		listUser = userDao.listAll();
		return "listUI";
	}
	
	//�����û�
	public String add() throws Exception{
		userDao.add(user);
		return "list";
	}
	
	//�༭�û�ҳ��
	public String editUI() throws Exception{
		user = userDao.getUser(user.getId());
		return "editUI";
	}
	//�༭�û�
	public String edit() throws Exception{
		userDao.editUser(user);
		return "list";
	}
	
	//ɾ���û�
	public String delete() throws Exception{
		userDao.deleteUser(user.getId());
		return "list";
	}
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
}
