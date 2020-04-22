package com.song.apitest.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ApiTestUtil {
	/**
	 * 返回json对象中指定路径下对象信息
	 * 
	 * @param responJson json对象
	 * @param path       格式为data[1].name
	 * @return
	 */
	public static Object getValueByPath(JSONObject responJson, String path) {
		Object result = responJson;
		for (String str : path.split("\\.")) {
			if (!str.isEmpty()) {
				if (!(str.contains("[") || str.contains("]"))) {
					Object temp = ((JSONObject) result).get(str);
					if (temp == null) {
						return null;
					}
					result = temp;
				} else if (str.contains("[") || str.contains("]")) {
					int indexNum = Integer.parseInt(str.split("\\[")[1].replace("]", ""));
					JSONArray jsonArray = ((JSONObject) result).getJSONArray(str.split("\\[")[0]);
					if (jsonArray == null || jsonArray.size() <= indexNum) {
						return null;
					}
					result = jsonArray.get(indexNum);
//					result = Optional.ofNullable(jsonArray).map(arr -> arr.get(indexNum));
				}
			}
		}
		return result;
	}
	
//	public static void main(String[] args) {
//		JSONObject responJson = new JSONObject();
//		Map<String, Object> hashMap = new HashMap<String, Object>();
//		List<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("name", "test123");
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("name", "test456");
//		arrayList.add(map);
//		arrayList.add(map2);
//		hashMap.put("data", arrayList);
//		responJson.putAll(hashMap);
//		System.out.println(responJson.toJSONString());
//		System.out.println(getValueByPath(responJson, "data[1].name"));
//	}

}
