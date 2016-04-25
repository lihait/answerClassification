package nlp_tag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * ȥ��Ӣ���ı��е�ͣ�ôʣ�ͣ�ôʴʱ���stopwords.txt
 * 
 * @author lihaitao
 * 
 */
public class ExcludeStopWord {

	// ͣ�ôʱ��ַ
	public static final String stopWordTable = "src/stopwords2.txt";

	public static String ExcludeStopWords(String wordStr) throws Exception {
		// ����ͣ�ôʱ��ļ�
		BufferedReader StopWordFileBr = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File(
						stopWordTable))));
		// �������ͣ�ôʵļ���
		Set stopWordSet = new HashSet<String>();

		// ���绯ͣ�ôʼ�
		String stopWord = null;
		for (; (stopWord = StopWordFileBr.readLine()) != null;) {
			stopWordSet.add(stopWord);
		}
		// �õ�Ҫȥ��ͣ�ôʵĴʻ�����
		String[] resultArray = wordStr.split(" ");

		// ����ͣ�ô�
		for (int i = 0; i < resultArray.length; i++) {
			if (stopWordSet.contains(resultArray[i])) {
				resultArray[i] = null;
			}
		}

		// �ѹ��˺���ַ���������뵽һ���ַ�����
		StringBuffer finalStr = new StringBuffer();
		// String finalStr;
		for (int i = 0; i < resultArray.length; i++) {
			if (resultArray[i] != null) {
				finalStr = finalStr.append(resultArray[i]).append(" ");
			}
		}

		String finalStrs = finalStr.toString();

		// �������շִʺ�Ľ���ַ���
		return finalStrs;

	}

}
