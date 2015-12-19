/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.vi.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.vi.domain.Message;
import com.vi.domain.Users;
import com.vi.service.imp.MessageServiceImp;
import com.vi.service.inter.MessageServiceInter;

/** 
 * MyEclipse Struts
 * Creation date: 12-17-2015
 * 
 * XDoclet definition:
 * @struts.action parameter="flag"
 */
public class GoMessageUiAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//获取应该现实的留言信息完成显示
		//取出该用户收到的信息
		MessageServiceInter messageServiceInter=new MessageServiceImp();
		List<Message> list=messageServiceInter.showMessage((Users)request.getSession().getAttribute("userInfo"));
		request.setAttribute("messageList", list);
		return mapping.findForward("goMessageUi");
	}
}