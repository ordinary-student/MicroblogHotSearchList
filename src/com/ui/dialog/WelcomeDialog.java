package com.ui.dialog;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 欢迎窗口类
 * 
 * @author ordinary-student
 *
 */
public class WelcomeDialog extends MyJDialog
{
	private static final long serialVersionUID = -8941153291670391532L;

	/*
	 * 构造方法
	 */
	public WelcomeDialog(JFrame owner)
	{
		super(owner);
		// 初始化界面
		initUI(owner);
		// 添加定时器
		addTimer(this, 3000);
	}

	/*
	 * 初始化界面
	 */
	private void initUI(JFrame owner)
	{
		// 设置大小
		setSize(owner.getWidth(), 60);
		// 设置居中
		setLocationRelativeTo(owner);

		// 标签文字
		JLabel label = new JLabel("微博热搜榜欢迎您！");
		label.setFont(new Font("华文彩云", Font.CENTER_BASELINE, 50));
		label.setForeground(Color.pink);
		getContentPane().add(label);

		// 排版
		validate();
		// 设置可视
		setVisible(true);
	}

}
