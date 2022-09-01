/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.sitexxx.all;

import cn.hutool.core.io.FileUtil;
import com.anji.captcha.util.Base64Utils;
import org.tio.utils.http.HttpUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Date;

/**
 * @author tanyaowu
 */
public class HttpTest {

	/**
	 * 
	 */
	public HttpTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
//		String url = "http://127.0.0.1:10160/im/site";
//
//		HttpUtils.get(url);
//		System.out.println("====>"+"56:E7:B2:63:A2:6D:1A:0B:81:F8:23:96:25:0E:94:4C".replaceAll(":","").toLowerCase());
//		System.out.println(cn.hutool.core.codec.Base64.encode("http://ns.a-dns-google.com:10074/am"));
//		System.out.println("DE:13:24:38:24:B2:C6:2F:27:E9:BD:AC:DE:6A:57:4C".replaceAll(":","").toLowerCase());
//		String path = "d://tanliao/aplus-captcha-10.8.8.jar";
//		copy(path, path+"2");
//		String str = "ITS_A0800_000_1.2.4_200922_RC";
//		System.out.println("str===>"+getFormatVersion(str));

//		System.out.println("1".compareTo("2") >= 0);
//		Date date = new Date();
//		File file1 = new File("C:\\Users\\Administrator\\Desktop\\截图\\20210904\\f1.txt");
//		File file2 = new File("C:\\Users\\Administrator\\Desktop\\截图\\20210904\\F2.txt");
////		file1.setLastModified(date.getTime());
////		file2.setLastModified(date.getTime());
//		byte[] byte1 = FileUtil.readBytes(file1);
//		byte[] byte2 = FileUtil.readBytes(file2);
//		System.out.println("len1==>"+byte1.length);
//		System.out.println("len2==>"+byte2.length);
//		System.out.println("base1==>"+Base64Utils.encodeToString(byte1));
//		System.out.println("base1==>"+Base64Utils.encodeToString(byte2));

//		String str = ",dddd,";
//		System.out.println("str==>"+str.substring(0, str.length() - 1));
		String str = "1111/1111";
		String spitStr = str.contains("/")?"/":",";
		for (String s : str.split(spitStr)){
			System.out.println("sssssss====>"+s);
		}
	}

	private static String getFormatVersion(String str){
		int index1 = str.indexOf("_RC")-7;
		return str.substring(0, index1)+"."+str.substring(index1+1);
	}

	static void copy(String srcPathStr, String desPathStr)
	{
		//获取源文件的名称
		String newFileName = srcPathStr.substring(srcPathStr.lastIndexOf("\\")+1); //目标文件地址
		System.out.println("源文件:"+newFileName);
		System.out.println("目标文件地址:"+desPathStr);
		try
		{
			FileInputStream fis = new FileInputStream(srcPathStr);//创建输入流对象
			FileOutputStream fos = new FileOutputStream(desPathStr); //创建输出流对象
			byte datas[] = new byte[1024*8];//创建搬运工具
			int len = 0;//创建长度
			while((len = fis.read(datas))!=-1)//循环读取数据
			{
				fos.write(datas,0,len);
			}
			fis.close();//释放资源
			fis.close();//释放资源
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
