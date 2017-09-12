package cn.bdqn.web;

import java.util.Map;

import cn.bdqn.entity.Bookuser;
import cn.bdqn.service.IBookUserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BookUserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Bookuser bookuser;
	private IBookUserService bookuserservice;
	private String acond;

	public String getAcond() {
		return acond;
	}

	public void setAcond(String acond) {
		this.acond = acond;
	}

	public IBookUserService getBookuserservice() {
		return bookuserservice;
	}

	public void setBookuserservice(IBookUserService bookuserservice) {
		this.bookuserservice = bookuserservice;
	}

	public Bookuser getBookuser() {
		return bookuser;
	}

	public void setBookuser(Bookuser bookuser) {
		this.bookuser = bookuser;
	}

	public String login() throws Exception {
		String isLogin = "input";
		System.out.println("session中取值："
				+ ActionContext.getContext().getSession().get("random"));
		String random = (String) ActionContext.getContext().getSession()
				.get("random");
		if (acond.equals(random)) {
			if (bookuserservice.login(bookuser)) {
				isLogin = "success";
				bookuser = bookuserservice.getObjectBy(bookuser);
				ActionContext actionContext = ActionContext.getContext();
				Map session = actionContext.getSession();
				session.put("name", bookuser.getName());
				session.put("usertype", bookuser.getUsertype());

			}

		}

		return isLogin;
	}

}
