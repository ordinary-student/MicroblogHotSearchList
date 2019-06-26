package com.ui.frame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.entity.HotSearch;
import com.utils.HotSearchUtil;

/**
 * 热搜面板类
 * 
 * @author ordinary-student
 *
 */
public class HotSearchPanel extends JScrollPane implements MouseListener
{
	private static final long serialVersionUID = 9017143084378444211L;

	/*
	 * 构造方法
	 */
	public HotSearchPanel()
	{
		// 初始化界面
		initUI();
	}

	/*
	 * 初始化界面
	 */
	private void initUI()
	{
		// 设置大小
		setPreferredSize(new Dimension(600, 600));

		// 获取热搜对象集合
		List<HotSearch> list = HotSearchUtil.getResouList();

		// 初始化内部面板
		JPanel innerPanel = new JPanel(new GridLayout(list.size(), 1));

		// 热搜标签
		HotSearchLabel[] label = new HotSearchLabel[list.size()];

		// 遍历
		for (int i = 0; i < list.size(); i++)
		{
			// 获取单个热搜对象
			HotSearch hs = list.get(i);
			// 创建热搜标签，设置序号和名字
			label[i] = new HotSearchLabel(hs.toString());
			// 设置链接地址
			label[i].setUrl(hs.getUrl());
			// 设置字体
			label[i].setFont(new Font("微软雅黑", Font.CENTER_BASELINE, 18));
			label[i].setPreferredSize(new Dimension(590, 30));
			// 设置光标形状
			label[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			// 添加鼠标监听
			label[i].addMouseListener(this);
			// 添加进内部面板
			innerPanel.add(label[i]);
		}

		// 特殊的热搜标签变色
		label[0].setForeground(Color.pink);
		label[3].setForeground(Color.orange);
		// 排版
		innerPanel.validate();

		// 设置视图
		setViewportView(innerPanel);
		// 设置水平，垂直都有滚动条
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);

		// 排版
		validate();
	}

	@Override
	public void mouseClicked(MouseEvent me)
	{
		// 判断是否为鼠标左键
		if (me.getButton() == MouseEvent.BUTTON1)
		{
			// 获取源标签
			HotSearchLabel label = (HotSearchLabel) me.getComponent();
			// 变色
			label.setForeground(Color.gray);

			try
			{
				// 创建URI对象
				URI uri = new URI(label.getUrl());
				// 调用默认浏览器打开指定URL
				Desktop.getDesktop().browse(uri);

			} catch (Exception e)
			{
				JOptionPane.showMessageDialog(this, "链接打开失败！");
			}
		}
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

}
