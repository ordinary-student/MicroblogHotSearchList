package com.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.entity.HotSearch;

/**
 * 热搜工具类
 * 
 * @author ordinary-student
 *
 */
public class HotSearchUtil
{
	private static String url = "https://s.weibo.com/top/summary?cate=realtimehot";

	/*
	 * 构造方法
	 */
	public HotSearchUtil()
	{
	}

	/**
	 * 获取热搜对象List数组
	 */
	public static List<HotSearch> getResouList()
	{
		// 得到document对象
		Document document = DocumentUtil.getDocument(url);
		// 如果为空
		if (document == null)
		{
			JOptionPane.showMessageDialog(null, "网络错误！");
			System.exit(0);
		}

		// 选择tbody下的a标签
		Elements elements = document.select("tbody").select("a");
		// 创建数组
		List<HotSearch> list = new ArrayList<HotSearch>(elements.size());
		// 遍历
		for (int i = 0; i < elements.size(); i++)
		{
			// 获取单个元素
			Element element = elements.get(i);
			// 创建热搜对象
			HotSearch hs = null;
			// 如果是广告位
			if (i == 3)
			{
				// 创建热搜对象
				hs = new HotSearch(i, element.text(), element.attr("abs:href_to"));
			} else
			{
				// 创建热搜对象
				hs = new HotSearch(i, element.text(), element.attr("abs:href"));
			}
			// 加入集合
			list.add(hs);
		}

		// 返回热搜集合
		return list;
	}

}
