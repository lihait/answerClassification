package nlp_tag;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

//import javax.swing.text.Element;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
/**
 * 对数据文件进行预处理和特征值的提取
 * @author lihaitao
 *
 */
public class ParaseXml {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// 创建saxReader对象
		SAXReader reader = new SAXReader();
		// 通过read方法读取一个文件 转换成Document对象
		Document document = reader.read(new File("src/train.xml"));
		// 获取根节点元素对象
		Element node = document.getRootElement();
		// 获取所有的Question节点
		List<Element> question = node.elements("Question");
		// 结果输出目录
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
		// "C:/models/output/qcategory.txt"));

		BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(
				"C:/train_fertures_out.txt"));

		for (Element ques : question) {
			// 问题句子中名词和形容词的初值
			int Qnj = 0;
			// 问题句子中动词和副词的初值
			int Qvr = 0;
			// 问题句子中数量词的初值
			int Qc = 1;
			// 问题句子中疑问词的初值
			int Qw = 1;
			// 获取问题的ID
			Attribute attr = ques.attribute("QID");
			// 问题ID
			String attrID = attr.getValue();
			// 获取问题的类型
			Attribute attr2 = ques.attribute("QCATEGORY");
			// 问题类型
			String attrQcategory = attr2.getValue();
			// 获取问题用户ID
			Attribute attr3 = ques.attribute("QUSERID");
			// 问题用户ID
			String attrQuserID = attr3.getValue();
			// 将问题ID读入到文件中
			// bufferedWriter.write(attrID + "\r\n");
			// bufferedWriter.flush();

			// bufferedWriter.write(attrQcategory + "\r\n");
			// bufferedWriter.flush();
			// System.out.println(attrID);
			// 获取问题的内容
			Element QBody = ques.element("QBody");
			// 问题内容
			String QBodyStr = QBody.getText();
			// 去除问题内容中的停用词
			String ExcludeQBodyStr = ExcludeStopWord.ExcludeStopWords(QBodyStr);
			// 将句子分词存到数组中
			String[] Qword = ExcludeQBodyStr.split(" ");
			// 计算问题句子长度
			int QuestionLength = ExcludeQBodyStr.length();
			// 对问题句子进行词性标注
			String QBodyStrResult = TaggerDemo.sentenceTag(ExcludeQBodyStr);
			// 统计问题句子中名词、形容词、动词和副词的个数
			WordTypeNumber.getFeatureNumber(QBodyStrResult);
			// 名词和形容词的个数
			Qnj = WordTypeNumber.wordType;
			WordTypeNumber.wordType = 0;
			// System.out.println("Qnj:" + Qnj);
			// 动词和副词的个数
			Qvr = WordTypeNumber.wordType2;
			WordTypeNumber.wordType2 = 0;
			// 数量词的个数
			Qc = WordTypeNumber.wordType3;
			WordTypeNumber.wordType3 = 0;
			// 疑问词的个数
			Qw = WordTypeNumber.wordType4;
			WordTypeNumber.wordType4 = 0;
			// 将标注后的句子读入到文件中
			// bufferedWriter.write(QBodyStrResult + "\r\n");
			// bufferedWriter.flush();
			// System.out.println(QBodyStr);
			// 获取答案
			List<Element> answers = ques.elements("Comment");

			for (Element answ : answers) {
				// 答案句子中形容词和名词的初值
				int Anj = 0;
				// 答案句子中动词和副词的初值
				int Avr = 0;
				// 答案句子中数量词的初值
				int Ac = 0;
				// 答案句子中疑问词的初值
				int Aw = 0;
				// 答案句子中名动词词的初值
				int Anv = 0;
				// 答案句子中形容词和名词与问题句子的比值初值
				double AQnj = 0;
				// 答案句子中动词和副词与问题句子的比值初值
				double AQvr = 0;
				// 答案句子中数量词与问题句子的比值初值
				double AQc = 0;
				// 答案句子中疑问词与问题句子的比值初值
				double AQw = 0;
				// 获取答案的ID
				Attribute attrAnswer = answ.attribute("CID");
				// 获取ID值
				String attrAnswerID = attrAnswer.getValue();
				// 将答案ID读入文件中
				// bufferedWriter.write(attrAnswerID + "\r\n");
				// bufferedWriter.flush();
				// 将答案ID读入文件中
				bufferedWriter2.write(attrAnswerID + "\r\n");
				bufferedWriter2.flush();

				// 获取答案用户ID
				Attribute attrAnswerUser = answ.attribute("CUSERID");
				// 获取ID值
				String attrAnswerUserID = attrAnswerUser.getValue();
				// 判断是否是同一个用户
				int seemUser = 0;
				if (attrAnswerUserID.equals(attrQuserID)) {

					seemUser = 1;

				} else {

					seemUser = 0;

				}
				// 将是否是Dialogue特征值写入文件中
				bufferedWriter2.write(seemUser + "\r\n");
				bufferedWriter2.flush();
				// System.out.println(attrAnswerID);
				// 获取答案类别
				Attribute AnswerCgold = answ.attribute("CGOLD");
				// 获取类别值
				String cgold = AnswerCgold.getValue();

				// if(cgold.equals("Good")||cgold.equals("Bad")||cgold.equals("Potential")){

				// 将答案类别值读入文件中
				// bufferedWriter.write(cgold + "\r\n");
				// bufferedWriter.flush();
				bufferedWriter2.write(cgold + "\r\n");
				bufferedWriter2.flush();

				// 将问题类型值写入文件中
				// bufferedWriter2.write(attrQcategory + "\r\n");
				// bufferedWriter2.flush();
				// System.out.println(cgold);
				// 获取答案内容
				Element CBody = answ.element("CBody");
				// 答案内容
				String CBodyStr = CBody.getText();
				// System.out.println(CBodyStr);
				// if((CBodyStr.contains(""))){

				// CBodyStr = QBodyStr;

				// }
				// String CBodyStrFinal = null;
				// if(CBodyStr!=null){
				// 去除答案内容中的停用词
				String ExcludeCBodyStr = ExcludeStopWord
						.ExcludeStopWords(CBodyStr);
				// 判断去除停用词后字符串长度小于2时，则不去除停用词
				if (ExcludeCBodyStr.length() <= 2) {

					ExcludeCBodyStr = CBodyStr;

				}
				// 计算平均词长
				// 将句子分词存到数组中
				String[] Aword = ExcludeCBodyStr.split(" ");
				// 计算答案与句子的匹配词个数
				int countQAword = 0;
				for (int i = 0; i < Qword.length; i++) {
					for (int j = 0; j < Aword.length; j++) {
						if (Aword[j].equals(Qword[i])) {

							countQAword++;

						}
					}
				}
				// 统计对话答案类型中的一些特征词
				int countDialogueWord = 0;
				// Dialogue中经常出现的词
				String[] featureWords = new String[] { "?", "???", "!", "!!!",
						"I", "i", "thank", "thanks", "thanks,", "question",
						"...", "please" };
				for (int i = 0; i < Aword.length; i++) {
					for (int j = 0; j < featureWords.length; j++) {
						if (Aword[i].equals(featureWords[j])) {

							countDialogueWord++;

						}
					}
				}
				// 将Dialogue统计词特征写入文件中
				bufferedWriter2.write(countDialogueWord + "\r\n");
				bufferedWriter2.flush();
				// 获取句子中词的个数
				int AwordNumber = Aword.length;
				// 初始字母数
				int letterNumber = 0;
				// 计算字母数
				for (int i = 0; i < Aword.length; i++) {

					String getAword = Aword[i];

					letterNumber = letterNumber + getAword.length();

				}
				// 计算平均词长
				double letterWord = (double) letterNumber / AwordNumber;
				// 计算答案句子的长度
				int AnswerLength = ExcludeCBodyStr.length();
				// 计算答案与句子长的比值
				double AQlength = (double) AnswerLength / QuestionLength;
				// 对答案内容进行词性标注
				String CBodyStrResult = TaggerDemo.sentenceTag(ExcludeCBodyStr);
				// 统计答案句子中名词、形容词、动词和副词的个数
				WordTypeNumber.getFeatureNumber(CBodyStrResult);
				// 名词和形容词的个数
				Anj = WordTypeNumber.wordType;
				WordTypeNumber.wordType = 0;
				// System.out.println("Anj:" + Anj);
				// 动词和副词的个数
				Avr = WordTypeNumber.wordType2;
				WordTypeNumber.wordType2 = 0;
				// 数量词的个数
				Ac = WordTypeNumber.wordType3;
				WordTypeNumber.wordType3 = 0;
				// 疑问词的个数
				Aw = WordTypeNumber.wordType4;
				WordTypeNumber.wordType4 = 0;
				// 名动词的个数
				Anv = WordTypeNumber.wordType5;
				WordTypeNumber.wordType5 = 0;
				// 答案句子中形容词和名词与问题句子的比值
				AQnj = (double) Anj / Qnj;
				// System.out.println("AQnj:" + AQnj);
				// 答案句子中动词和副词与问题句子的比值
				AQvr = (double) Avr / Qvr;
				// 答案句子中数量词与问题句子的比值
				AQc = (double) Ac / Qc;
				// 答案句子中疑问词与问题句子的比值
				AQw = (double) Aw / Qw;
				// 答案句子中名词和形容词与总词数的比
				double Anjall = (double) Anj / AwordNumber;
				// 答案句子中动词和副词与总词数的比
				double Avrall = (double) Avr / AwordNumber;
				// 答案句子中nj和vw的比
				double Anjvw = (double) Anj / Avr;
				// nv和all的比
				double Anvall = (double) Anv / AwordNumber;
				// 将标注后的答案内容读入到文件中
				// bufferedWriter.write(CBodyStrResult + "\r\n");
				// bufferedWriter.flush();
				// 将特征值结果读入到文件中
				
				bufferedWriter2.write(AQnj + "\r\n");
				bufferedWriter2.flush();

				bufferedWriter2.write(AQvr + "\r\n");
				bufferedWriter2.flush();

				// test_out_new_wordcompare.txt
				bufferedWriter2.write(letterWord + "\r\n");
				bufferedWriter2.flush();

				bufferedWriter2.write(AQlength + "\r\n");
				bufferedWriter2.flush();

				bufferedWriter2.write(Anjall + "\r\n");
				bufferedWriter2.flush();

				bufferedWriter2.write(Avrall + "\r\n");
				bufferedWriter2.flush();

				bufferedWriter2.write(Anjvw + "\r\n");
				bufferedWriter2.flush();

				bufferedWriter2.write(Anvall + "\r\n");
				bufferedWriter2.flush();
				// test_out_new_wordcompare.txt
				
				bufferedWriter2.write(countQAword + "\r\n");
				bufferedWriter2.flush();

			}
		}

	}

}
