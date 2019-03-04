package com.lharo.g4g.Games4Gamers.util;

import org.springframework.util.DigestUtils;

public class Utility {
	public static String digestStr(String str) {
		String digestedStr = DigestUtils.md5DigestAsHex(str.getBytes());
		return digestedStr;
	}
}
