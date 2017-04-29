package com.yjy.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yjy.entity.User;
import com.yjy.service.UserService;


public class UserAction extends ActionSupport {
	private UserService userService;
	private User user;
	private List<User> listUser = new ArrayList<User>();
	
	//��¼
	public String login() throws Exception{
		boolean b = userService.login(user);
		if(b){
			ServletActionContext.getRequest().setAttribute("user", user);
			return "success";
		}
		ServletActionContext.getRequest().setAttribute("msg", "��¼ʧ�ܣ���");
		return "index";
	}

	//�õ�ȫ���û�
	public String listUI() throws Exception{
		listUser = userService.listAll();
		return "listUI";
	}
	
	//�����û�
	public String add() throws Exception{
		userService.addUser(user);
		return "list";
	}
	
	//�༭�û�ҳ��
	public String editUI() throws Exception{
		user = userService.getUser(user.getId());
		System.out.println(user);
		return "editUI";
	}
	//�༭�û�
	public String edit() throws Exception{
		userService.editUser(user);
		return "list";
	}
	
	//ɾ���û�
	public String delete() throws Exception{
		userService.deleteUser(user);
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

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
