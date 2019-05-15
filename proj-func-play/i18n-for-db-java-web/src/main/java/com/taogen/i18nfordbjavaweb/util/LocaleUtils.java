package com.taogen.i18nfordbjavaweb.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LocaleUtils
{

	/**
	 * 获取 Locale
	 * @param localeStr
	 * @return
	 */
	public static Locale getLocaleByStr(String localeStr)
	{
		if (! StringUtils.isEmpty(localeStr))
		{
			localeStr = getRightLocaleStr(localeStr);
			String[] localeArr = localeStr.split("-");
			if (localeArr.length >= 2)
			{
				return new Locale(localeArr[0], localeArr[1]);
			}
			else
			{
				return new Locale(localeArr[0]);
			}
		}
		else 
		{
			return getDefaultLocale();
		}
	}
	
	public static Locale getLocaleByRequest(HttpServletRequest request)
	{
		String localeStr = request.getHeader(HttpHeader.LOCALE);
		localeStr = getRightLocaleStr(localeStr);
		Locale locale = getLocaleByStr(localeStr);
		return locale;
	}
	
	/**
	 * localeStr 转换为 zh-CH, zh-HK, en, ja, ko
	 * @param localeStr
	 * @return
	 */
	public static String getRightLocaleStr(String localeStr)
	{
		if (! StringUtils.isEmpty(localeStr))
		{
			if (LocaleType.SIMPLIFIED_CHINESE_LIST.contains(localeStr))
			{
				return LocaleType.UNIQUE_SIMPLIFIED_CHINESE;
			}
			else if(LocaleType.TRADITIONAL_CHINESE_LIST.contains(localeStr))
			{
				return LocaleType.UNIQUE_TRADITIONAL_CHINESE;
			}
			else
			{
				if (localeStr.split("-").length >= 2)
				{
					return localeStr.split("-")[0];
				}
				if (localeStr.split("_").length >= 2)
				{
					return localeStr.split("_")[0];
				}
			}
		}
		return localeStr;
	}
	
	/**
	 * localeStr 转换为下划线格式 zh_CN, zh_HK, en, ja, ko
	 * @param localeStr
	 * @return
	 */
	public static String getUrlLocaleStr(String localeStr)
	{
		if (! StringUtils.isEmpty(localeStr))
		{
			if (LocaleType.SIMPLIFIED_CHINESE_LIST.contains(localeStr))
			{
				return LocaleType.ZH_CN;
			}
			else if(LocaleType.TRADITIONAL_CHINESE_LIST.contains(localeStr))
			{
				return LocaleType.ZH_HK;
			}
			else
			{
				if (localeStr.split("-").length >= 2)
				{
					return localeStr.split("-")[0];
				}
				else if (localeStr.split("_").length >= 2)
				{
					return localeStr.split("_")[0];
				}
				else
				{
					return localeStr;
				}
			}
		}
		else
		{
			return getDefaultLocaleStr();
		}
	}
	
	/**
	 * localeStr 转换为国内国外两种locale, zh_CN, en
	 * @param localeStr
	 * @return
	 */
	public static String getHomeOrAbroadLocaleStr(String localeStr)
	{
		if (! StringUtils.isEmpty(localeStr))
		{
			if (LocaleType.SIMPLIFIED_CHINESE_LIST.contains(localeStr) || 
				LocaleType.TRADITIONAL_CHINESE_LIST.contains(localeStr))
			{
				return LocaleType.ZH_CN;
			}
		}
		return getDefaultLocaleStr();
	}
	
	public static Locale getDefaultLocale()
	{
		return new Locale(LocaleType.DEFAULT_LANG);
	}
	
	public static String getDefaultLocaleStr()
	{
		return LocaleType.DEFAULT_LANG;
	}
	
	public static List<String> getLocaleList(String localeStr)
	{
		if (StringUtils.isEmpty(localeStr))
		{
			return Arrays.asList(LocaleType.EN);
		}
		String[] split1 = localeStr.split("-");
		String[] split2 = localeStr.split("_");
		if (split1.length > 1)
		{
			return Arrays.asList(split1);
		}
		else if (split2.length > 1)
		{
			return Arrays.asList(split2);
		}
		else
		{
			return Arrays.asList(localeStr);
		}
	}
	
	public static String getLocaleStrByLocale(Locale locale)
	{
		String localeStr = "";
		if (locale != null)
		{
			if (! StringUtils.isEmpty(locale.getLanguage()))
			{
				localeStr = locale.getLanguage();
				if (! StringUtils.isEmpty(locale.getCountry()))
				{
					localeStr = localeStr + "-" + locale.getCountry();
				}
			}
		}
		return localeStr;
	}
	
}
