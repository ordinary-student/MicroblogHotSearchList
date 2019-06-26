package com.main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.ui.frame.MicroblogSearchListFrame;

/**
 * 微博热搜榜
 * 
 * @author ordinary-student
 *
 */
public class MicroblogHotSearchList
{

	public static void main(String[] args) throws Exception
	{
		try
		{
			// 设置窗口风格样式
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "加载本地系统窗口样式失败！");
		} finally
		{
			// 主界面
			new MicroblogSearchListFrame();
		}

	}

}
