package com.taogen.i18nfordbjavaweb.util;

import java.util.Arrays;
import java.util.List;

public class LocaleType
{
	public static final String ZH = "zh";
	public static final String CN = "CN";
	public static final String ZH_CN = "zh_CN";
	public static final String ZH_HK = "zh_HK";
	public static final String EN = "en";
	public static final String JA = "ja";
	public static final String KO = "ko";
	public static final String DEFAULT_LOCALE = "en";
	public static final String DEFAULT_LANG = "en";
	
	public static final String UNIQUE_SIMPLIFIED_CHINESE = "zh-CN";
	public static final String UNIQUE_TRADITIONAL_CHINESE = "zh-HK";
	
	public static final List<String> SIMPLIFIED_CHINESE_LIST = 
		Arrays.asList("zh", "zh-CN", "zh-Hans", "zh-Hans-CN", "zh_CN", "zh_Hans", "zh_Hans_CN");
	public static final List<String> TRADITIONAL_CHINESE_LIST = 
		Arrays.asList("zh-HK", "zh-TW", "zh-Hant", "zh-Hant-HK", "zh-Hant-TW", "zh_HK", "zh_TW", "zh_Hant", "zh_Hant_HK", "zh_Hant_TW");
}
