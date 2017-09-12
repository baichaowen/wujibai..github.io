package cn.bdqn.web;

import java.io.ByteArrayInputStream;

import cn.bdqn.util.RandomNumUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 该类主要用于生成验证码
 * 
 */
public class RandomAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private ByteArrayInputStream inputStream;
    

	// 生成验证码方法
    public String execute() throws Exception {
        RandomNumUtil rdnu = RandomNumUtil.Instance();
       
        this.setInputStream(rdnu.getImage());/// 取得带有随机字符串的图片
       
        ActionContext.getContext().getSession().put("random", rdnu.getString());// ȡ������ַ����HttpSession
      System.out.println("ghhf"+rdnu.getString());
    /*String acon=rdnu.getString();
    if(!acon.equals(acond)){
    	
    	return "acond";
    	
    }*/
        return SUCCESS;
    }

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }
}
