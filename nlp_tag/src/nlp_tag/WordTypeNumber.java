package nlp_tag;

import java.util.HashSet;
import java.util.Set;
/**
 * ͳ�ƾ��������ݴʡ����ʡ����ʡ����ʵĸ���
 * @author Administrator
 *
 */
public class WordTypeNumber {

	//���������ʺ����ݴʵĳ�ʼֵ
	public static int wordType = 0;
	//�����ж��ʺ͸��ʵĳ�ʼֵ
	public static int wordType2 = 0;
	//�����������ʵĳ�ʼֵ
	public static int wordType3 = 0;
	//���������ʴʳ�ʼֵ
	public static int wordType4 = 0;
	//�����������ʳ�ʼֵ
	public static int wordType5 = 0;
	
	public static void getFeatureNumber(String str) throws Exception {
		// TODO Auto-generated method stub
        //String str = "Where/WRB I/PRP buy/VBP good/JJ oil/NN massage/NN ?/.";
        
        //String strs = TaggerDemo.sentenceTag(str);
        
        //String strs = ExcludeStopWord.ExcludeStopWords(str);
        //�����Ӱ����ʺʹ��Դ洢��������
        String[] strs = str.split(" ");
        //��ž��ӵĴ��Լ���
        //Set allWordType = new HashSet<String>();
        
        int length = 0;
        //�洢���Լ�
        String[] strResult = new String[strs.length];
        
        for(int i=0;i<strs.length;i++){

        	 //��ȡ���ʺʹ������
        	 String finalStr = strs[i];       	
        	 //��ȡ���ʺʹ��Եķֽ��±�
        	 int index = finalStr.indexOf("/");
        	 //��ȡ���ʵĴ��Բ��浽������
        	 String strFinalResult = finalStr.substring(index+1);
        	 
        	 strResult[i] = strFinalResult;
        	 
        	 length = strResult.length;
        	 //��������ӵ�������
        	 //allWordType.add(strResult[i]);
        	
        	 //System.out.println(strResult[i]);
        	 
        }    

        //���Լ��ϳ�ʼ��
        String[] wordTypes = new String[]{"NN","NNS","NNP","NNPS","JJ","JJR","JJS"};
        
        String[] wordTypes2 = new String[]{"VB","VBD","VBG","VBN","VBP","VBZ","RB","RBR","RBS"};
        
        String[] wordTypes3 = new String[]{"CC","CD"};
        
        String[] wordTypes4 = new String[]{"WDT","WP","WP$","WRB"};
        
        String[] wordTypes5 = new String[]{"NN","NNS","NNP","NNPS","VB","VBD","VBG","VBN","VBP","VBZ"};
        
        for(int j=0;j<length;j++){
        	//ͳ�ƾ��������ʺ����ݴʵĸ���
        	for(int k=0;k<wordTypes.length;k++){
        		
        		if(strResult[j].equals(wordTypes[k])){
        			
        			wordType++;
        			
        		}
        		
        	}
        	//ͳ�ƾ����ж��ʺ͸��ʵĸ���
            for(int k=0;k<wordTypes2.length;k++){
        		
        		if(strResult[j].equals(wordTypes2[k])){
        			
        			wordType2++;
        			
        		}
        		
        	}
            
            //ͳ�ƾ����������ʵĸ���
           for(int k=0;k<wordTypes3.length;k++){
        		
        		if(strResult[j].equals(wordTypes3[k])){
        			
        			wordType3++;
        			
        		}
        		
        	}
           //ͳ�ƾ��������ʴʵĸ���
           for(int k=0;k<wordTypes4.length;k++){
       		
       		if(strResult[j].equals(wordTypes4[k])){
       			
       			    wordType4++;
       			
       		}
       		
       	  }
         //ͳ�ƾ����������ʵĸ���
           for(int k=0;k<wordTypes5.length;k++){
       		
       		if(strResult[j].equals(wordTypes5[k])){
       			
       			    wordType5++;
       			
       		}
       		
       	  }
        }
	}
}
