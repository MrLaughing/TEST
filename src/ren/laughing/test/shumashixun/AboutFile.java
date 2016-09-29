package ren.laughing.test.shumashixun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 统计某文件夹下包含的jsp,xml,java文件总行数
 * 
 * @author Laughing_Lz
 * @time 2016年9月29日
 */
public class AboutFile {
	public static int count4Java = 0;
	public static int count4Xml = 0;
	public static int count4Jsp = 0;

	/**
	 * 遍历获得某文件夹下所有文件
	 * 
	 * @param str
	 * @param fileList
	 * @return
	 */
	public List<String> GetFiles(String str, List<String> fileList) {
		File file = new File(str);
		File[] files = file.listFiles();// 列出所有子文件和路径
		// String[] files = file.list();//列出所有子文件和路径名
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {// 是目录，递归
				// str = str + "\\" + files[i].getName();//拼接子文件夹路径
				fileList = GetFiles(files[i].getAbsolutePath(), fileList);// 传入子文件夹绝对路径名，继续遍历
			} else {
				fileList.add(files[i].getAbsolutePath());// 是文件，将绝对路径名放入list
			}
		}
		return fileList;
	}

	/**
	 * 统计各类文件的总行数
	 * 
	 * @param fileList
	 */
	public void getCounts(List<String> fileList) {
		for (String file : fileList) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(file)));
				String oneLine = br.readLine();
				while (oneLine != null) {
					if (file.endsWith(".java")) {
						count4Java++;
					} else if (file.endsWith(".xml")) {
						count4Xml++;
					} else if (file.endsWith(".jsp")) {
						count4Jsp++;
					}
					oneLine = br.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		System.out.println("java文件总行数：" + count4Java + "\n" + "jsp文件总行数：" + count4Jsp + "\n" + "xml文件总行数：" + count4Xml);
	}

	public static void main(String[] args) {
		List<String> fileList = new ArrayList<String>();
		String str = "G:\\test";
		AboutFile af = new AboutFile();
		af.GetFiles(str, fileList);
		af.getCounts(fileList);
	}
}
