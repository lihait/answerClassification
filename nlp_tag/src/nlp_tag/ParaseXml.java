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
 * �������ļ�����Ԥ���������ֵ����ȡ
 * @author lihaitao
 *
 */
public class ParaseXml {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ����saxReader����
		SAXReader reader = new SAXReader();
		// ͨ��read������ȡһ���ļ� ת����Document����
		Document document = reader.read(new File("src/train.xml"));
		// ��ȡ���ڵ�Ԫ�ض���
		Element node = document.getRootElement();
		// ��ȡ���е�Question�ڵ�
		List<Element> question = node.elements("Question");
		// ������Ŀ¼
		// BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(
		// "C:/models/output/qcategory.txt"));

		BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(
				"C:/train_fertures_out.txt"));

		for (Element ques : question) {
			// ������������ʺ����ݴʵĳ�ֵ
			int Qnj = 0;
			// ��������ж��ʺ͸��ʵĳ�ֵ
			int Qvr = 0;
			// ��������������ʵĳ�ֵ
			int Qc = 1;
			// ������������ʴʵĳ�ֵ
			int Qw = 1;
			// ��ȡ�����ID
			Attribute attr = ques.attribute("QID");
			// ����ID
			String attrID = attr.getValue();
			// ��ȡ���������
			Attribute attr2 = ques.attribute("QCATEGORY");
			// ��������
			String attrQcategory = attr2.getValue();
			// ��ȡ�����û�ID
			Attribute attr3 = ques.attribute("QUSERID");
			// �����û�ID
			String attrQuserID = attr3.getValue();
			// ������ID���뵽�ļ���
			// bufferedWriter.write(attrID + "\r\n");
			// bufferedWriter.flush();

			// bufferedWriter.write(attrQcategory + "\r\n");
			// bufferedWriter.flush();
			// System.out.println(attrID);
			// ��ȡ���������
			Element QBody = ques.element("QBody");
			// ��������
			String QBodyStr = QBody.getText();
			// ȥ�����������е�ͣ�ô�
			String ExcludeQBodyStr = ExcludeStopWord.ExcludeStopWords(QBodyStr);
			// �����ӷִʴ浽������
			String[] Qword = ExcludeQBodyStr.split(" ");
			// ����������ӳ���
			int QuestionLength = ExcludeQBodyStr.length();
			// ��������ӽ��д��Ա�ע
			String QBodyStrResult = TaggerDemo.sentenceTag(ExcludeQBodyStr);
			// ͳ��������������ʡ����ݴʡ����ʺ͸��ʵĸ���
			WordTypeNumber.getFeatureNumber(QBodyStrResult);
			// ���ʺ����ݴʵĸ���
			Qnj = WordTypeNumber.wordType;
			WordTypeNumber.wordType = 0;
			// System.out.println("Qnj:" + Qnj);
			// ���ʺ͸��ʵĸ���
			Qvr = WordTypeNumber.wordType2;
			WordTypeNumber.wordType2 = 0;
			// �����ʵĸ���
			Qc = WordTypeNumber.wordType3;
			WordTypeNumber.wordType3 = 0;
			// ���ʴʵĸ���
			Qw = WordTypeNumber.wordType4;
			WordTypeNumber.wordType4 = 0;
			// ����ע��ľ��Ӷ��뵽�ļ���
			// bufferedWriter.write(QBodyStrResult + "\r\n");
			// bufferedWriter.flush();
			// System.out.println(QBodyStr);
			// ��ȡ��
			List<Element> answers = ques.elements("Comment");

			for (Element answ : answers) {
				// �𰸾��������ݴʺ����ʵĳ�ֵ
				int Anj = 0;
				// �𰸾����ж��ʺ͸��ʵĳ�ֵ
				int Avr = 0;
				// �𰸾����������ʵĳ�ֵ
				int Ac = 0;
				// �𰸾��������ʴʵĳ�ֵ
				int Aw = 0;
				// �𰸾����������ʴʵĳ�ֵ
				int Anv = 0;
				// �𰸾��������ݴʺ�������������ӵı�ֵ��ֵ
				double AQnj = 0;
				// �𰸾����ж��ʺ͸�����������ӵı�ֵ��ֵ
				double AQvr = 0;
				// �𰸾�������������������ӵı�ֵ��ֵ
				double AQc = 0;
				// �𰸾��������ʴ���������ӵı�ֵ��ֵ
				double AQw = 0;
				// ��ȡ�𰸵�ID
				Attribute attrAnswer = answ.attribute("CID");
				// ��ȡIDֵ
				String attrAnswerID = attrAnswer.getValue();
				// ����ID�����ļ���
				// bufferedWriter.write(attrAnswerID + "\r\n");
				// bufferedWriter.flush();
				// ����ID�����ļ���
				bufferedWriter2.write(attrAnswerID + "\r\n");
				bufferedWriter2.flush();

				// ��ȡ���û�ID
				Attribute attrAnswerUser = answ.attribute("CUSERID");
				// ��ȡIDֵ
				String attrAnswerUserID = attrAnswerUser.getValue();
				// �ж��Ƿ���ͬһ���û�
				int seemUser = 0;
				if (attrAnswerUserID.equals(attrQuserID)) {

					seemUser = 1;

				} else {

					seemUser = 0;

				}
				// ���Ƿ���Dialogue����ֵд���ļ���
				bufferedWriter2.write(seemUser + "\r\n");
				bufferedWriter2.flush();
				// System.out.println(attrAnswerID);
				// ��ȡ�����
				Attribute AnswerCgold = answ.attribute("CGOLD");
				// ��ȡ���ֵ
				String cgold = AnswerCgold.getValue();

				// if(cgold.equals("Good")||cgold.equals("Bad")||cgold.equals("Potential")){

				// �������ֵ�����ļ���
				// bufferedWriter.write(cgold + "\r\n");
				// bufferedWriter.flush();
				bufferedWriter2.write(cgold + "\r\n");
				bufferedWriter2.flush();

				// ����������ֵд���ļ���
				// bufferedWriter2.write(attrQcategory + "\r\n");
				// bufferedWriter2.flush();
				// System.out.println(cgold);
				// ��ȡ������
				Element CBody = answ.element("CBody");
				// ������
				String CBodyStr = CBody.getText();
				// System.out.println(CBodyStr);
				// if((CBodyStr.contains(""))){

				// CBodyStr = QBodyStr;

				// }
				// String CBodyStrFinal = null;
				// if(CBodyStr!=null){
				// ȥ���������е�ͣ�ô�
				String ExcludeCBodyStr = ExcludeStopWord
						.ExcludeStopWords(CBodyStr);
				// �ж�ȥ��ͣ�ôʺ��ַ�������С��2ʱ����ȥ��ͣ�ô�
				if (ExcludeCBodyStr.length() <= 2) {

					ExcludeCBodyStr = CBodyStr;

				}
				// ����ƽ���ʳ�
				// �����ӷִʴ浽������
				String[] Aword = ExcludeCBodyStr.split(" ");
				// ���������ӵ�ƥ��ʸ���
				int countQAword = 0;
				for (int i = 0; i < Qword.length; i++) {
					for (int j = 0; j < Aword.length; j++) {
						if (Aword[j].equals(Qword[i])) {

							countQAword++;

						}
					}
				}
				// ͳ�ƶԻ��������е�һЩ������
				int countDialogueWord = 0;
				// Dialogue�о������ֵĴ�
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
				// ��Dialogueͳ�ƴ�����д���ļ���
				bufferedWriter2.write(countDialogueWord + "\r\n");
				bufferedWriter2.flush();
				// ��ȡ�����дʵĸ���
				int AwordNumber = Aword.length;
				// ��ʼ��ĸ��
				int letterNumber = 0;
				// ������ĸ��
				for (int i = 0; i < Aword.length; i++) {

					String getAword = Aword[i];

					letterNumber = letterNumber + getAword.length();

				}
				// ����ƽ���ʳ�
				double letterWord = (double) letterNumber / AwordNumber;
				// ����𰸾��ӵĳ���
				int AnswerLength = ExcludeCBodyStr.length();
				// ���������ӳ��ı�ֵ
				double AQlength = (double) AnswerLength / QuestionLength;
				// �Դ����ݽ��д��Ա�ע
				String CBodyStrResult = TaggerDemo.sentenceTag(ExcludeCBodyStr);
				// ͳ�ƴ𰸾��������ʡ����ݴʡ����ʺ͸��ʵĸ���
				WordTypeNumber.getFeatureNumber(CBodyStrResult);
				// ���ʺ����ݴʵĸ���
				Anj = WordTypeNumber.wordType;
				WordTypeNumber.wordType = 0;
				// System.out.println("Anj:" + Anj);
				// ���ʺ͸��ʵĸ���
				Avr = WordTypeNumber.wordType2;
				WordTypeNumber.wordType2 = 0;
				// �����ʵĸ���
				Ac = WordTypeNumber.wordType3;
				WordTypeNumber.wordType3 = 0;
				// ���ʴʵĸ���
				Aw = WordTypeNumber.wordType4;
				WordTypeNumber.wordType4 = 0;
				// �����ʵĸ���
				Anv = WordTypeNumber.wordType5;
				WordTypeNumber.wordType5 = 0;
				// �𰸾��������ݴʺ�������������ӵı�ֵ
				AQnj = (double) Anj / Qnj;
				// System.out.println("AQnj:" + AQnj);
				// �𰸾����ж��ʺ͸�����������ӵı�ֵ
				AQvr = (double) Avr / Qvr;
				// �𰸾�������������������ӵı�ֵ
				AQc = (double) Ac / Qc;
				// �𰸾��������ʴ���������ӵı�ֵ
				AQw = (double) Aw / Qw;
				// �𰸾��������ʺ����ݴ����ܴ����ı�
				double Anjall = (double) Anj / AwordNumber;
				// �𰸾����ж��ʺ͸������ܴ����ı�
				double Avrall = (double) Avr / AwordNumber;
				// �𰸾�����nj��vw�ı�
				double Anjvw = (double) Anj / Avr;
				// nv��all�ı�
				double Anvall = (double) Anv / AwordNumber;
				// ����ע��Ĵ����ݶ��뵽�ļ���
				// bufferedWriter.write(CBodyStrResult + "\r\n");
				// bufferedWriter.flush();
				// ������ֵ������뵽�ļ���
				
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
