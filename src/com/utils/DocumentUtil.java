package com.utils;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 解析网页链接工具类
 * 
 * @author ordinary-student
 *
 */
public class DocumentUtil
{

	// 代理头
	private static String os = "5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko)";
	private static String chrome = "70.0.3538.25";
	private static String safari = "537.36";
	private static String core = "1.70.3695.400";
	private static String qqbrowser = "10.4.3562.400";

	public DocumentUtil()
	{
	}

	/*
	 * 获取文档对象
	 */
	public static Document getDocument(String url)
	{
		// 代理头
		String agent = os + " " + "Chrome/" + chrome + " " + "Safari/" + safari + " " + "Core/" + core + " "
				+ "QQBrowser/" + qqbrowser;
		// 尝试次数
		int num = 0;
		boolean flag = false;
		Document document = null;
		// 循环
		do
		{
			try
			{
				// 请求代理头
				// 获得document对象
				document = Jsoup.connect(url).userAgent(agent).timeout(5000).get();
				// 获取成功，退出
				flag = false;
			} catch (IOException e)
			{
				num++;
				if (num > 3)
				{
					JOptionPane.showMessageDialog(null, "网络请求超时！");
					// 请求4次还打不开，就退出
					flag = false;
				} else
				{
					// 否则继续请求
					flag = true;
				}
			}
		} while (flag);

		// 返回document对象
		return document;
	}

}
