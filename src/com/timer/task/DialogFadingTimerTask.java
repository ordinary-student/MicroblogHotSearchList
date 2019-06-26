package com.timer.task;

import java.util.TimerTask;

import javax.swing.JDialog;

/**
 * 窗口变淡定时器任务类
 * 
 * @author ordinary-student
 *
 */
public class DialogFadingTimerTask extends TimerTask
{
	// 起始透明度
	private float opacity = 0.8f;
	// 透明度递减步长
	private float opacityStep = 0.01f;
	// 窗体
	private JDialog dialog;

	/*
	 * 构造方法
	 */
	public DialogFadingTimerTask()
	{
		this(null);
	}

	/*
	 * 构造方法
	 */
	public DialogFadingTimerTask(JDialog dialog)
	{
		this.dialog = dialog;
	}

	@Override
	public void run()
	{
		// 判断
		if (opacity >= 0)
		{
			// 设置透明度
			dialog.setOpacity(opacity);
			// 透明度递减
			opacity = opacity - opacityStep;
		} else
		{
			// 取消任务
			cancel();
		}
	}

}
