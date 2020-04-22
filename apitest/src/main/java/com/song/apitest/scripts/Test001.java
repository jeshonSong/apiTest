package com.song.apitest.scripts;

import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.song.apitest.bean.ApiTestTemplate;
import com.song.apitest.bean.RestClient;
import com.song.apitest.utils.ApiTestUtil;

public class Test001 extends ApiTestTemplate {
	final static Logger Log = Logger.getLogger(RestClient.class);
	
	private RestClient restClient = new RestClient();
	private CloseableHttpResponse closeableHttpResponse;
	
	public void run() {
		String url = "http://localhost/home/getMenus";
		try {
			closeableHttpResponse = restClient.get(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int code = restClient.getStatusCode(closeableHttpResponse);
		Log.info("返回状态码校验");
		Assert.assertEquals(code, 200);

//		String re = null;
//		try {
//			re = ApiTestUtil.getValueByPath(restClient.getResponseJson(closeableHttpResponse), "data[0]").toString();
//		} catch (ParseException | IOException e) {
//			e.printStackTrace();
//		}
//		Log.info("返回数据校验");
//		Assert.assertEquals(re, "menu1");
	}
	
	public void setup() {
		// 预制条件及步骤
	}
	
	public void teardown() {
		// 执行完之后的清除动作
	}
}
