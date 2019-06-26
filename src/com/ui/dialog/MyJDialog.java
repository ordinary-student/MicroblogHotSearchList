package com.ui.dialog;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.timer.DialogDisappearingTimer;
import com.timer.DialogFadingTimer;

/**
 * 自定义弹窗类
 * 
 * @author ordinary-student
 *
 */
public class MyJDialog extends JDialog implements ActionListener, MouseListener
{
	private static final long serialVersionUID = -6631779766904851272L;

	/*
	 * 有参构造方法
	 */
	public MyJDialog(JFrame owner)
	{
		super(owner);
		// 设置居中
		setLocationRelativeTo(owner);
		// 设置布局
		getContentPane().setLayout(new FlowLayout());
		// 设置背景色
		getContentPane().setBackground(Color.black);
		// 禁用窗体装饰，不显示标题栏，关闭，最小化等
		setUndecorated(true);
		// 隐藏任务栏图标
		setType(JFrame.Type.UTILITY);
		// 透明度80%
		setOpacity(0.8f);
		// 设置关闭
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 设置不可视
		setVisible(false);
	}

	/*
	 * 无参构造方法
	 */
	public MyJDialog()
	{
		this(null);
	}

	/*
	 * 添加定时器
	 */
	public void addTimer(JDialog jd, int delay)
	{
		// 定时3秒自动消失
		DialogDisappearingTimer timer = new DialogDisappearingTimer(jd, delay);
		// 只执行一次
		timer.setRepeats(false);
		// 启动定时器
		timer.start();
		// 窗体变淡
		DialogFadingTimer.fading(jd);

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

}
