package com.ui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import com.ui.dialog.TipsDialog;
import com.ui.dialog.WelcomeDialog;

/**
 * 主界面窗口类
 * 
 * @author ordinary-student
 *
 */
public class MicroblogSearchListFrame extends MyJFrame
{
	private static final long serialVersionUID = 8952522863622305093L;
	private JButton refresh_Btn;
	private JCheckBox setTop_CheckBox;
	private HotSearchPanel hsPanel;

	/*
	 * 构造方法
	 */
	public MicroblogSearchListFrame()
	{
		super();
		// 初始化界面
		initUI();
		// 欢迎窗口
		new WelcomeDialog(this);
	}

	/*
	 * 初始化界面
	 */
	public void initUI()
	{
		// 设置标题
		setTitle("微博热搜榜" + getCurrentTime());
		// 设置大小
		setSize(new Dimension(610, 700));
		// 设置最小的大小
		setMinimumSize(new Dimension(605, 640));
		// 设置位置
		setLocation(400, 50);
		// 设置默认关闭方式
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 热搜面板
		hsPanel = new HotSearchPanel();
		getContentPane().add(hsPanel, BorderLayout.CENTER);

		// 按钮面板
		JPanel panel = new JPanel();

		// 刷新按钮
		refresh_Btn = new JButton("刷新");
		refresh_Btn.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		refresh_Btn.setPreferredSize(new Dimension(100, 35));
		refresh_Btn.setFocusPainted(false);
		refresh_Btn.addActionListener(this);
		panel.add(refresh_Btn, BorderLayout.WEST);

		// 置顶按钮
		setTop_CheckBox = new JCheckBox("窗口置顶");
		setTop_CheckBox.setFont(new Font("宋体", Font.CENTER_BASELINE, 18));
		setTop_CheckBox.setPreferredSize(new Dimension(150, 35));
		setTop_CheckBox.setFocusPainted(false);
		setTop_CheckBox.addActionListener(this);
		panel.add(setTop_CheckBox, BorderLayout.EAST);

		getContentPane().add(panel, BorderLayout.SOUTH);
		// 排版
		validate();
		// 设置可视
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// 判断来源
		if (e.getSource() == refresh_Btn)
		{
			// 刷新
			refresh();
		} else if (e.getSource() == setTop_CheckBox)
		{
			// 窗口置顶
			setAlwaysOnTop(setTop_CheckBox.isSelected());
			// 判断
			if (setTop_CheckBox.isSelected())
			{
				new TipsDialog(this, "已切换为置顶模式！").setVisible(true);
			} else
			{
				new TipsDialog(this, "已切换为普通模式！").setVisible(true);
			}
		}

	}

	/*
	 * 刷新热搜
	 */
	private void refresh()
	{
		// 移除旧热搜面板
		getContentPane().remove(hsPanel);
		// 创建新 热搜面板
		hsPanel = new HotSearchPanel();
		// 设置位置与大小
		hsPanel.setBounds(5, 10, 600, 570);
		// 添加新热搜面板
		getContentPane().add(hsPanel, BorderLayout.CENTER);
		// 设置标题
		setTitle("微博热搜榜" + getCurrentTime());
		// 排版
		validate();
	}

	public String getCurrentTime()
	{
		// 格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 返回
		return df.format(System.currentTimeMillis());
	}

}
