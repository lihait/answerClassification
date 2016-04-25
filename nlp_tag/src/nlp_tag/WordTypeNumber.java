package nlp_tag;

import java.util.HashSet;
import java.util.Set;
/**
 * 统计句子中形容词、名词、动词、副词的个数
 * @author Administrator
 *
 */
public class WordTypeNumber {

	//句子中名词和形容词的初始值
	public static int wordType = 0;
	//句子中动词和副词的初始值
	public static int wordType2 = 0;
	//句子中数量词的初始值
	public static int wordType3 = 0;
	//句子中疑问词初始值
	public static int wordType4 = 0;
	//句子中名动词初始值
	public static int wordType5 = 0;
	
	public static void getFeatureNumber(String str) throws Exception {
		// TODO Auto-generated method stub
        //String str = "Where/WRB I/PRP buy/VBP good/JJ oil/NN massage/NN ?/.";
        
        //String strs = TaggerDemo.sentenceTag(str);
        
        //String strs = ExcludeStopWord.ExcludeStopWords(str);
        //将句子按单词和词性存储到数组中
        String[] strs = str.split(" ");
        //存放句子的词性集合
        //Set allWordType = new HashSet<String>();
        
        int length = 0;
        //存储词性集
        String[] strResult = new String[strs.length];
        
        for(int i=0;i<strs.length;i++){

        	 //获取单词和词性组合
        	 String finalStr = strs[i];       	
        	 //获取单词和词性的分界下标
        	 int index = finalStr.indexOf("/");
        	 //截取单词的词性并存到数组中
        	 String strFinalResult = finalStr.substring(index+1);
        	 
        	 strResult[i] = strFinalResult;
        	 
        	 length = strResult.length;
        	 //将词性添加到集合中
        	 //allWordType.add(strResult[i]);
        	
        	 //System.out.println(strResult[i]);
        	 
        }    

        //词性集合初始化
        String[] wordTypes = new String[]{"NN","NNS","NNP","NNPS","JJ","JJR","JJS"};
        
        String[] wordTypes2 = new String[]{"VB","VBD","VBG","VBN","VBP","VBZ","RB","RBR","RBS"};
        
        String[] wordTypes3 = new String[]{"CC","CD"};
        
        String[] wordTypes4 = new String[]{"WDT","WP","WP$","WRB"};
        
        String[] wordTypes5 = new String[]{"NN","NNS","NNP","NNPS","VB","VBD","VBG","VBN","VBP","VBZ"};
        
        for(int j=0;j<length;j++){
        	//统计句子中名词和形容词的个数
        	for(int k=0;k<wordTypes.length;k++){
        		
        		if(strResult[j].equals(wordTypes[k])){
        			
        			wordType++;
        			
        		}
        		
        	}
        	//统计句子中动词和副词的个数
            for(int k=0;k<wordTypes2.length;k++){
        		
        		if(strResult[j].equals(wordTypes2[k])){
        			
        			wordType2++;
        			
        		}
        		
        	}
            
            //统计句子中数量词的个数
           for(int k=0;k<wordTypes3.length;k++){
        		
        		if(strResult[j].equals(wordTypes3[k])){
        			
        			wordType3++;
        			
        		}
        		
        	}
           //统计句子中疑问词的个数
           for(int k=0;k<wordTypes4.length;k++){
       		
       		if(strResult[j].equals(wordTypes4[k])){
       			
       			    wordType4++;
       			
       		}
       		
       	  }
         //统计句子中名动词的个数
           for(int k=0;k<wordTypes5.length;k++){
       		
       		if(strResult[j].equals(wordTypes5[k])){
       			
       			    wordType5++;
       			
       		}
       		
       	  }
        }
	}
}
