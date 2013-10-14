package cn.dayutianfei.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {
	private static Logger logger = Logger.getLogger(PropertyUtil.class);
	private static String default_conf_directory = null;
	private static HashMap<String, String> confAndPath = new HashMap<String, String>();
	private static HashMap<String, Properties> confCache = new HashMap<String, Properties>();
	static {
		try {
			String localConfigurePath = System.getProperty("user.dir");
			if (null == localConfigurePath) {
				throw new Exception("it does not work here.");
			}
			default_conf_directory = localConfigurePath + File.separator
					+ "conf" + File.separator;
			logger.debug("The local configuration path is : "
					+ default_conf_directory);
		} catch (Exception e) {
			logger.error("The system does not support "
					+ "the System.getProperty(\"user.dir\") method!");
		}
	}

	public static String getProperty(String confFile, String key) {
		Properties prop = new Properties();
		if (confCache.containsKey(confFile)) {
			prop = confCache.get(key);
		} else {
			// 缓存中没有&路径未设定
			if (!confAndPath.containsKey(confFile)) {
				// 全部使用默认设置
				String _full_path = default_conf_directory + confFile
						+ ".properties";
				confAndPath.put(confFile, _full_path);
			}
			try{
				String _path = confAndPath.get(confFile);
				logger.debug("The configuration file path : "+_path);
				InputStream _in = new BufferedInputStream(new FileInputStream(
						_path));
				prop.load(_in);
			}catch(IOException e){
				logger.error("Error occured when getting the configuration file");
			}
			confCache.put(confFile, prop);
		}
		// return null if the key does not appear in the configuration
		return prop.getProperty(key);
	}

	public static void setDefaultConfDirectory(String conf_directory_path) {
		PropertyUtil.default_conf_directory = conf_directory_path;
	}

	public static void setConfPath(String confName, String path) {
		if (confAndPath.containsKey(confName)) {
			confAndPath.remove(confName);
			confAndPath.put(confName, path);
		} else {
			confAndPath.put(confName, path);
		}
	}
}
