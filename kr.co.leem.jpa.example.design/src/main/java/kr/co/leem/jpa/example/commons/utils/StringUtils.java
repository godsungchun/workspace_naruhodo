package kr.co.leem.jpa.example.commons.utils;

/**
 * Created by Dream on 2016-07-21.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {
	public static String escapeDbWildcard(String path) {
		return path.replace("_", "|_");
	}
}
