package com.ui.frame;

import javax.swing.JLabel;

/**
 * 热搜标签类
 * 
 * @author ordinary-student
 *
 */
public class HotSearchLabel extends JLabel
{
	private static final long serialVersionUID = 4976868270462911734L;
	private String url;

	/*
	 * 构造函数
	 */
	public HotSearchLabel()
	{
		super();
	}

	/*
	 * 构造函数
	 */
	public HotSearchLabel(String string)
	{
		super(string);
	}

	/**
	 * @return url
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * @param url
	 *            要设置的 url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

}
