package com.ui.dialog;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 提示窗口类
 * 
 * @author ordinary-student
 *
 */
public class TipsDialog extends MyJDialog
{
	private static final long serialVersionUID = 3791551228705653666L;

	/*
	 * 构造方法
	 */
	public TipsDialog(JFrame owner, String mess)
	{
		super(owner);
		// 初始化界面
		initUI(owner, mess);
		// 添加定时器
		addTimer(this, 2000);
	}

	/*
	 * 初始化界面
	 */
	private void initUI(JFrame owner, String mess)
	{
		// 设置大小
		setSize(owner.getWidth(), 60);
		// 设置居中
		setLocationRelativeTo(owner);

		// 标签文字
		JLabel label = new JLabel(mess);
		label.setFont(new Font("华文彩云", Font.CENTER_BASELINE, 50));
		label.setForeground(Color.green);
		getContentPane().add(label);

		// 排版
		validate();
		// 设置可视
		setVisible(true);
	}

}
