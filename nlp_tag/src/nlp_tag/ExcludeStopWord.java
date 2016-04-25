package nlp_tag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 去除英文文本中的停用词，停用词词表是stopwords.txt
 * 
 * @author lihaitao
 * 
 */
public class ExcludeStopWord {

	// 停用词表地址
	public static final String stopWordTable = "src/stopwords2.txt";

	public static String ExcludeStopWords(String wordStr) throws Exception {
		// 读入停用词表文件
		BufferedReader StopWordFileBr = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(
						stopWordTable))));
		// 用来存放停用词的集合
		Set stopWordSet = new HashSet<String>();

		// 初如化停用词集
		String stopWord = null;
		for (; (stopWord = StopWordFileBr.readLine()) != null;) {
			stopWordSet.add(stopWord);
		}
		// 得到要去除停用词的词汇数组
		String[] resultArray = wordStr.split(" ");

		// 过滤停用词
		for (int i = 0; i < resultArray.length; i++) {
			if (stopWordSet.contains(resultArray[i])) {
				resultArray[i] = null;
			}
		}

		// 把过滤后的字符串数组存入到一个字符串中
		StringBuffer finalStr = new StringBuffer();
		// String finalStr;
		for (int i = 0; i < resultArray.length; i++) {
			if (resultArray[i] != null) {
				finalStr = finalStr.append(resultArray[i]).append(" ");
			}
		}

		String finalStrs = finalStr.toString();

		// 返回最终分词后的结果字符串
		return finalStrs;

	}

}
