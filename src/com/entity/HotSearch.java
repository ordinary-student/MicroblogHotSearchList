package com.entity;

/**
 * 热搜类
 * 
 * @author ordinary-student
 *
 */
public class HotSearch
{
	// 序号
	private int id;
	// 名称
	private String name;
	// 链接地址
	private String url;

	/*
	 * 构造方法
	 */
	public HotSearch(int id, String name, String url)
	{
		this.id = id;
		this.name = name;
		this.url = url;
	}

	/*
	 * 构造方法
	 */
	public HotSearch(int id, String name)
	{
		this(id, name, "");
	}

	@Override
	public String toString()
	{
		return this.id + "  " + this.name;
	}

	/**
	 * @return name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return url
	 */
	public String getUrl()
	{
		return this.url;
	}

	/**
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
}
