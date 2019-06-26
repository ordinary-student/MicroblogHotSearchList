package com.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

/**
 * 窗口消失定时器的动作侦听器类
 * 
 * @author ordinary-student
 *
 */
public class DialogDisappearingAction implements ActionListener
{
	private JDialog jd;

	/*
	 * 构造方法
	 */
	public DialogDisappearingAction(JDialog jd)
	{
		this.jd = jd;
	}

	/*
	 * 构造方法
	 */
	public DialogDisappearingAction()
	{
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// 关闭窗口
		jd.dispose();
	}

}
