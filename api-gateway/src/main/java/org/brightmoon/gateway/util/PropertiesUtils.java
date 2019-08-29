package org.brightmoon.gateway.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by C99 on 2018/8/28 22:56
 *
 * @Description: PropertiesUtils文件的工具类
 */
public final class PropertiesUtils {

	private static final String ENCODE_UTF8 = "UTF-8";

	private PropertiesUtils() {
	}

	/**
	 * @param fileClassPath
	 * @return java.util.Properties 路径有误返回null
	 * @throws
	 * @description 根据文件的classpath路径加载文件并返回Properties实例
	 * @date 2018/8/28 23:42
	 * @author C99
	 */
	public static Properties load(String fileClassPath) {

		if (StringUtils.isEmpty(fileClassPath))
			return null;

		Properties properties = new Properties();
		InputStreamReader reader = null;
		try {
			reader = new InputStreamReader(
					Thread.currentThread().getContextClassLoader().getResourceAsStream(fileClassPath), ENCODE_UTF8);
			properties.load(reader);
		} catch (Exception e) {
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}

	/**
	 * 解析Properties文件组装为Map后返回
	 * @param fileClassPath
	 * @return
	 */
	public static Map<String, String> loadAndConvertMap(String fileClassPath) {
		if (StringUtils.isEmpty(fileClassPath))
			return null;

		Map<String, String> load = new HashMap<>();
		Properties properties = load(fileClassPath);
		if (null != properties && properties.size() > 0) {
			properties.keySet().stream().forEach((key) -> {
				load.put(key.toString(), properties.get(key).toString());
			});
		}
		return load;
	}

	/**
	 * 解析Properties文件组装为不可变Map后返回
	 * @param fileClassPath
	 * @return
	 */
	public static Map<String, String> loadAndConvertUnmodifiableMap(String fileClassPath) {
		return Collections.unmodifiableMap(loadAndConvertMap(fileClassPath));
	}
}
