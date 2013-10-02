package com.portal.common.collection;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * ArrayList를 상속받아 구현한 SBoxList
 * 
 * @author SungRangKong
 * @since 2013.08.14
 * @version v1.0
 * 
 * @param <E>
 */
public class SBoxList<E> extends ArrayList<E> {

	/**
	 * serialVersionID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <pre>
	 * SBoxList ����
	 * </pre>
	 * 
	 */
	public SBoxList() {
		super();
	}

	/**
	 * <pre>
	 * List 를 가져와 SBoxList로 변환하는 오버로딩 된 생성자
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.14
	 * @param list
	 *            변환할 대상의 List 객체
	 */
	@SuppressWarnings("unchecked")
	public SBoxList(List<?> list) {
		if (list != null) {
			Iterator<?> it = list.iterator();
			while (it.hasNext()) {
				this.add((E) it.next());
			}
		}
	}

	/**
	 * <pre>
	 * SBoxList에 Object 셋팅하는 메소드
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.14
	 * @param obj
	 *            SBoxList에 셋팅할 값
	 */
	public void set(E obj) {
		super.add(obj);
	}

	/**
	 * <pre>
	 * SBoxList 에 Object Array 셋팅하는 메소드
	 * </pre>
	 * 
	 * @param objs
	 *            : 추가할 Object Array
	 */
	public void set(E[] objs) {
		for (E obj : objs) {
			super.add(obj);
		}
	}

	/**
	 * <pre>
	 * JSON 형식의 Data 를 SBox를 포함한 SBoxList Data로 Settting 함
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013. 8. 26.
	 * @param jsonData
	 *            : json 형식의 Data
	 */
	@SuppressWarnings("unchecked")
	public void setJson(String jsonData) {

		Object obj = JSONValue.parse(jsonData);
		JSONArray array = (JSONArray) obj;

		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) instanceof JSONObject) {
				SBox sBox = new SBox();
				sBox.putAll((JSONObject) array.get(i));
				this.set((E) sBox);
			}

		}

	}

	/**
	 * <pre>
	 * SBoxList 를 String 으로 출력하는 메소드
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.14
	 * @return SBoxList 출력 String
	 */
	public String toString() {

		StringBuffer sb = new StringBuffer();

		if (this != null) {
			Iterator<E> itList = this.iterator();
			while (itList.hasNext()) {
				E obj = itList.next();
				if (obj instanceof SBox) {
					sb.append(obj.toString());
				} else if (obj instanceof SBoxList) {
					sb.append("SBoxList Object");
				} else if (obj instanceof String[]) {
					String temp = "";
					for (int i = 0; i < ((String[]) obj).length; i++) {
						temp += ((String[]) obj)[i];
						temp += ",";
					}
					if (((String[]) obj).length > 0) {
						sb.append(temp.substring(0, temp.length() - 1));
					}
				} else if (obj instanceof String) {
					sb.append((String) obj);
				} else {
					sb.append(obj);
				}
				sb.append(",");
			}
		} else {
			sb.append("데이터가 존재하지 않음.");
		}
		return sb.length() > 0 ? sb.toString().substring(0, sb.length() - 1) : "";
	}

	/**
	 * <pre>
	 * SBoxList 를 줄바꿈 하여 String 으로 출력하는 메소드
	 * </pre>
	 * 
	 * @return SBoxList 출력 String
	 * @author SungRangKong
	 * @since 2013.08.14
	 */
	public String println() {

		StringBuffer sb = new StringBuffer();

		if (this != null) {
			Iterator<E> itList = this.iterator();
			while (itList.hasNext()) {
				E obj = itList.next();
				if (obj instanceof SBox) {
					sb.append(obj.toString());
				} else if (obj instanceof SBoxList) {
					sb.append("SBoxList Object");
				} else if (obj instanceof String[]) {
					String temp = "";
					for (int i = 0; i < ((String[]) obj).length; i++) {
						temp += ((String[]) obj)[i];
						temp += ",";
					}
					if (((String[]) obj).length > 0) {
						sb.append(temp.substring(0, temp.length() - 1));
					}
				} else if (obj instanceof String) {
					sb.append((String) obj);
				} else {
					sb.append(obj);
				}
				sb.append(",");
				sb.append("\n");
			}
		} else {
			sb.append("데이터가 존재하지 않음.");
		}
		return sb.length() > 0 ? sb.toString().substring(0, sb.length() - 2) : "";
	}

	/**
	 * <pre>
	 * SBoxList 를 JSON 타입으로 변환하는 메소드
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.14
	 * 
	 * @return JSON 변환 문자열
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public String toJSON() throws IOException {
		SBoxList<Object> cloneObj = this.recursiveEncode((SBoxList<Object>) ((SBoxList<Object>) this).clone(), "euc-kr");
		return this.recursiveChangeJson(cloneObj);
	}

	/**
	 * <pre>
	 * SBoxList 를 JSON 타입으로 변환하는 메소드
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.14
	 * 
	 * @param encode
	 *            = 인코딩
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public String toJSON(String encode) throws IOException {
		SBoxList<Object> cloneObj = this.recursiveEncode((SBoxList<Object>) ((SBoxList<Object>) this).clone(), encode);
		return this.recursiveChangeJson(cloneObj);
	}

	/**
	 * <pre>
	 * SBoxList 내의 함수 인코딩 메소드.
	 * 재귀호출 함수로써 오버로딩하여 사용된다.
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.14
	 * @param list
	 *            Source Object
	 * @param encode
	 *            Encode Type
	 * @return Result Object(SBoxList)
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private SBoxList<Object> recursiveEncode(SBoxList<Object> list, String encode) throws IOException {

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i) instanceof SBox) {
				list.set(i, this.recursiveEncode((SBox) list.get(i), encode));
			} else if (list.get(i) instanceof SBoxList) {
				list.set(i, this.recursiveEncode((SBoxList<Object>) list.get(i), encode));
			} else if (list.get(i) instanceof String) {
				list.set(i, URLEncoder.encode((String) list.get(i), encode));
			} else if (list.get(i) instanceof String[]) {
				int len = ((String[]) list.get(i)).length;
				String[] temp = new String[len];
				System.arraycopy((String[]) list.get(i), 0, temp, 0, len);
				for (int j = 0; j < temp.length; j++) {
					temp[j] = URLEncoder.encode(temp[j], encode);
				}
				list.set(i, temp);

			} else if (list.get(i) instanceof java.sql.Time) {
				list.set(i, URLEncoder.encode(((java.sql.Time) list.get(i)).toString(), encode));
			} else if (list.get(i) instanceof java.sql.Date) {
				list.set(i, URLEncoder.encode(((java.sql.Date) list.get(i)).toString(), encode));
			} else if (list.get(i) instanceof java.sql.Timestamp) {
				String result = ((java.sql.Timestamp) list.get(i)).toString()
						.substring(0, ((java.sql.Timestamp) list.get(i)).toString().indexOf("."));
				list.set(i, URLEncoder.encode(result, encode));
			}
		}
		return list;
	}

	/**
	 * <pre>
	 * SBox 내의 함수 인코딩 메소드.
	 * 재귀호출 함수로써 오버로딩하여 사용된다.
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.14
	 * 
	 * @param SBox
	 *            Source Object
	 * @param encode
	 *            Encode Type
	 * @return Result Object(SBox)
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	private SBox recursiveEncode(SBox sBox, String encode) throws IOException {

		Iterator<String> it = sBox.keySet().iterator();

		while (it.hasNext()) {
			String key = (String) it.next();

			if (sBox.get(key) instanceof SBox) {
				sBox.set(key, recursiveEncode((SBox) sBox.get(key), encode));
			} else if (sBox.get(key) instanceof SBoxList) {
				sBox.set(key, this.recursiveEncode((SBoxList<Object>) sBox.get(key), encode));
			} else if (sBox.get(key) instanceof String) {
				sBox.set(key, URLEncoder.encode(sBox.getString(key), encode));
			} else if (sBox.get(key) instanceof String[]) {
				int len = ((String[]) sBox.get(key)).length;
				String[] temp = new String[len];
				System.arraycopy((String[]) sBox.get(key), 0, temp, 0, len);
				for (int j = 0; j < temp.length; j++) {
					temp[j] = URLEncoder.encode(temp[j], encode);
				}
				sBox.set(key, temp);
			} else if (sBox.get(key) instanceof java.sql.Time) {
				sBox.set(key, URLEncoder.encode(((java.sql.Time) sBox.get(key)).toString(), encode));
			} else if (sBox.get(key) instanceof java.sql.Date) {
				sBox.set(key, URLEncoder.encode(((java.sql.Date) sBox.get(key)).toString(), encode));
			} else if (sBox.get(key) instanceof java.sql.Timestamp) {
				String result = ((java.sql.Timestamp) sBox.get(key)).toString().substring(0,
						((java.sql.Timestamp) sBox.get(key)).toString().indexOf("."));
				sBox.set(key, URLEncoder.encode(result, encode));
			}

		}

		return sBox;
	}

	/**
	 * <pre>
	 * SBox를 JSON 타입으로 재귀호출하며 문자열로 변환한다.
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.14
	 * @param sBox
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String recursiveChangeJson(SBox sBox) {
		StringBuffer sb = new StringBuffer();

		if (sBox != null && sBox.size() != 0) {
			sb.append("{");

			Iterator<String> it = sBox.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				sb.append("\"" + key + "\"");
				sb.append(":");
				if (sBox.get(key) instanceof SBox) {
					sb.append(this.recursiveChangeJson((SBox) sBox.get(key)));
					sb.append(",");

				} else if (sBox.get(key) instanceof SBoxList) {
					sb.append(this.recursiveChangeJson((SBoxList<Object>) sBox.get(key)));
					sb.append(",");
				} else if (sBox.get(key) instanceof String[]) {
					sb.append("[");
					int len = ((String[]) sBox.get(key)).length;
					String[] temp = new String[len];
					System.arraycopy((String[]) sBox.get(key), 0, temp, 0, len);
					for (int j = 0; j < temp.length; j++) {
						sb.append("\"" + temp[j] + "\"");
						sb.append(",");
					}
					sb.replace(sb.length() - 1, sb.length(), "");
					sb.append("],");

				} else {
					sb.append("\"" + sBox.get(key) + "\"");
					sb.append(",");
				}
			}
			sb.replace(sb.length() - 1, sb.length(), "");
			sb.append("}");
		}

		return sb.toString();
	}

	/**
	 * <pre>
	 * SBoxList를 JSON 타입으로 재귀호출하며 문자열로 변환한다.
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.14
	 * @param SBoxList
	 *            Data
	 * @return : SBoxList 내부 데이터를 String,String의 형태로 출력함.
	 */
	@SuppressWarnings("unchecked")
	private String recursiveChangeJson(SBoxList<Object> list) {
		StringBuffer sb = new StringBuffer();

		if (list != null && list.size() != 0) {

			sb.append("[");
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) instanceof SBox) {
					sb.append(this.recursiveChangeJson((SBox) list.get(i)));
					sb.append(",");
				} else if (list.get(i) instanceof SBoxList) {
					sb.append(this.recursiveChangeJson((SBoxList<Object>) list.get(i)));
					sb.append(",");
				} else if (list.get(i) instanceof String[]) {
					sb.append("[");
					int len = ((String[]) list.get(i)).length;
					String[] temp = new String[len];
					System.arraycopy((String[]) list.get(i), 0, temp, 0, len);
					for (int j = 0; j < temp.length; j++) {
						sb.append("\"" + temp[j] + "\"");
						sb.append(",");
					}
					sb.replace(sb.length() - 1, sb.length(), "");
					sb.append("],");

				} else {
					sb.append("\"" + list.get(i) + "\"");
					sb.append(",");
				}
			}
			sb.replace(sb.length() - 1, sb.length(), "");
			sb.append("]");

		}

		return sb.toString();
	}

}