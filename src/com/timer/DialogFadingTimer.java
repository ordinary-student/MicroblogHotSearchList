package com.timer;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;

import com.timer.task.DialogFadingTimerTask;

/**
 * 窗口变淡定时器类
 * 
 * @author ordinary-student
 *
 */
public class DialogFadingTimer extends Timer
{

	/*
	 * 构造方法
	 */
	public DialogFadingTimer()
	{
		super();
	}

	/**
	 * 窗体变淡
	 * 
	 * @param dialog
	 */
	public static void fading(JDialog dialog)
	{
		// 创建定时器
		Timer timer = new DialogFadingTimer();
		// 任务
		TimerTask task = new DialogFadingTimerTask(dialog);
		// 安排执行
		timer.schedule(task, 500, 20);
	}

}