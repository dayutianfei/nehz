package cn.dayutianfei.common;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PropertyUtilTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Are you ready to be tested?");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Well done, I mean the test method itself.");
	}

	@Test
	public void testGetProperty() {
		String confName = "config";
		String path = System.getProperty("user.dir")+ File.separator  + "conf"
				+ File.separator + confName + ".properties";
		System.out.println(path);
		PropertyUtil.setConfPath(confName, path);
		String _username = PropertyUtil.getProperty(confName, "test.name");
		assertEquals("dayu", _username);
	}

}
