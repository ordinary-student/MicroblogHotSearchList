package com.timer;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.Timer;

import com.action.DialogDisappearingAction;

/**
 * 窗口消失定时器类
 * 
 * @author ordinary-student
 *
 */
public class DialogDisappearingTimer extends Timer
{
	private static final long serialVersionUID = 7883057058059567708L;

	/*
	 * 构造方法
	 */
	public DialogDisappearingTimer(int delay, ActionListener listener)
	{
		super(delay, listener);
	}

	/*
	 * 构造方法
	 */
	public DialogDisappearingTimer(JDialog jd, int delay)
	{
		super(delay, new DialogDisappearingAction(jd));
	}

}
