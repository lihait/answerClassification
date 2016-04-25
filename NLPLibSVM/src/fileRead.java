

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
/**
 * 将文件处理成SVM需要的数据格式
 * @author lihaitao
 *
 */
public class fileRead {
	public static void readTxtFileHead(String filePath,String filePath2,String filePath3,String filePath4) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			File file11 = new File(filePath);
			File file2 = new File(filePath2);
			File file22 = new File(filePath2);
			File file3 = new File(filePath3);
			File file33 = new File(filePath3);
			File file4 = new File(filePath4);
			File file44 = new File(filePath4);
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				InputStreamReader read11 = new InputStreamReader(
						new FileInputStream(file11), encoding);// 考虑到编码格式s
				InputStreamReader read2 = new InputStreamReader(
						new FileInputStream(file2), encoding);// 考虑到编码格式
				InputStreamReader read22 = new InputStreamReader(
						new FileInputStream(file22), encoding);// 考虑到编码格式
				InputStreamReader read3 = new InputStreamReader(
						new FileInputStream(file3), encoding);// 考虑到编码格式
				InputStreamReader read33 = new InputStreamReader(
						new FileInputStream(file33), encoding);// 考虑到编码格式
				InputStreamReader read4 = new InputStreamReader(
						new FileInputStream(file4), encoding);// 考虑到编码格式
				InputStreamReader read44 = new InputStreamReader(
						new FileInputStream(file44), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				BufferedReader bufferedReader11 = new BufferedReader(read11);
				BufferedReader bufferedReader2 = new BufferedReader(read2);
				BufferedReader bufferedReader22 = new BufferedReader(read22);
				BufferedReader bufferedReader3 = new BufferedReader(read3);
				BufferedReader bufferedReader33 = new BufferedReader(read33);
				BufferedReader bufferedReader4 = new BufferedReader(read4);
				BufferedReader bufferedReader44 = new BufferedReader(read44);
				//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/svm_train.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/svm_test.txt"));
				int length1 = 0;
				String lineTxt = null;
                while((bufferedReader11.readLine()) != null){
					
                	length1++;
                	
				}
                //System.out.println(length1);
				String[] lineTxts = new String[length1];
				for(int i=0;i<lineTxts.length;i++){
					
					lineTxts[i] = bufferedReader.readLine();
					
				}
				String lineTxt2 = null;
				int length2 = 0;
						while((bufferedReader22.readLine()) != null){
							
		                	length2++;
		                	
						}
				String[] lineTxts2 = new String[length2];
				for(int i=0;i<lineTxts2.length;i++){
					
					lineTxts2[i] = bufferedReader2.readLine();
					
				}
				String lineTxt3 = null;
				int length3 = 0;
				while((bufferedReader33.readLine()) != null){
					
                	length3++;
                	
				}
				String[] lineTxts3 = new String[length3];
				for(int i=0;i<lineTxts3.length;i++){
					
					lineTxts3[i] = bufferedReader3.readLine();
					
				}
				String lineTxt4 = null;
				int length4 = 0;
				while((bufferedReader44.readLine()) != null){
					
                	length4++;
                	
				}
				String[] lineTxts4 = new String[length4];
				for(int i=0;i<lineTxts4.length;i++){
					
					lineTxts4[i] = bufferedReader4.readLine();
					
				}
				for(int j=0;j<lineTxts.length;j++){
					
					if(lineTxts[j].equals("Good")){
						
						lineTxts[j] = "1.0";
						
					}else if(lineTxts[j].equals("Bad")){
						
						lineTxts[j] = "2.0";
						
					}else if(lineTxts[j].equals("Potential")){
						
						lineTxts[j] = "3.0";
						
					}else if(lineTxts[j].equals("Dialogue")){
						
						lineTxts[j] = "4.0";
						
					}else if(lineTxts[j].equals("Other")){
						
						lineTxts[j] = "5.0";
						
					}else if(lineTxts[j].equals("NaN")){
						
						lineTxts[j] = "0";
						
					}else if(lineTxts[j].equals("Infinity")){
						
						lineTxts[j] = "0";
						
					}else if(lineTxts[j].equals("Not English")){
						
						lineTxts[j] = "6.0";
						
					}
					
				}
				
                for(int j=0;j<lineTxts2.length;j++){
					
					if(lineTxts2[j].equals("Good")){
						
						lineTxts2[j] = "1.0";
						
					}else if(lineTxts2[j].equals("Bad")){
						
						lineTxts2[j] = "2.0";
						
					}else if(lineTxts2[j].equals("Potential")){
						
						lineTxts2[j] = "3.0";
						
					}else if(lineTxts2[j].equals("Dialogue")){
						
						lineTxts2[j] = "4.0";
						
					}else if(lineTxts2[j].equals("Other")){
						
						lineTxts2[j] = "5.0";
						
					}else if(lineTxts2[j].equals("NaN")){
						
						lineTxts2[j] = "0";
						
					}else if(lineTxts2[j].equals("Infinity")){
						
						lineTxts2[j] = "0";
						
					}else if(lineTxts2[j].equals("Not English")){
						
						lineTxts2[j] = "6.0";
						
					}
					
				}
				
for(int j=0;j<lineTxts3.length;j++){
					
					if(lineTxts3[j].equals("Good")){
						
						lineTxts3[j] = "1.0";
						
					}else if(lineTxts3[j].equals("Bad")){
						
						lineTxts3[j] = "2.0";
						
					}else if(lineTxts3[j].equals("Potential")){
						
						lineTxts3[j] = "3.0";
						
					}else if(lineTxts3[j].equals("Dialogue")){
						
						lineTxts3[j] = "4.0";
						
					}else if(lineTxts3[j].equals("Other")){
						
						lineTxts3[j] = "5.0";
						
					}else if(lineTxts3[j].equals("NaN")){
						
						lineTxts3[j] = "0";
						
					}else if(lineTxts3[j].equals("Infinity")){
						
						lineTxts3[j] = "0";
						
					}else if(lineTxts3[j].equals("Not English")){
						
						lineTxts3[j] = "6.0";
						
					}
					
				}
				int count = 0;
				
				int count2 = 0;
				
				int count3 = 0;
				
				int count4 = 0;
				
				while((count < lineTxts.length)&&(count2 < lineTxts2.length)&&(count3 < lineTxts3.length)&&(count4 < lineTxts4.length)){
					
					//if(!((lineTxts[count+1]).equals("6.0"))){
						//bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " + "3" + ":"+ lineTxts[count+7] + " " +"4" + ":"+ lineTxts[count+8] + " " +"5" + ":"+ lineTxts[count+9] + " " +"6" + ":"+ lineTxts[count+11] +"\r\n");
	                    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " +"4" + ":"+ lineTxts2[count2+5] + " " +"5" + ":"+ lineTxts2[count2+6] + " " +"6" + ":"+ lineTxts2[count2+7] + " " +"7" + ":"+ lineTxts2[count2+8] + " " +"8" + ":"+ lineTxts2[count2+9] +" "+ "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +"\r\n");//0.6534
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] +  " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+ " "+ "16" + ":"+ lineTxts4[count4+2]+ " "+ "17" + ":"+ lineTxts4[count4+3] + "\r\n");//0.5993
					    bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] +  " " +"3" + ":"+ lineTxts2[count2+9] + " " + "4" + ":"+ lineTxts3[count3+1] +" "+ "5" + ":"+ lineTxts3[count3+3]+" "+ "6" + ":"+ lineTxts3[count3+4]+" "+ "7" + ":"+ lineTxts3[count3+5]+" "+ "8" + ":"+ lineTxts3[count3+6] +" "+ "9" + ":"+ lineTxts4[count4+1]+ " "+ "10" + ":"+ lineTxts4[count4+2]+ " "+ "11" + ":"+ lineTxts4[count4+3] + "\r\n");//0.6012				
				    
					 //   bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] +  " " +"3" + ":"+ aa + " " + "4" + ":"+ bb  + "\r\n");//0.5319
					    
					    //bufferedWriter.write(lineTxts[count+3] + " " + lineTxts[count+4] +  " " + lineTxts2[count2+9] + " " +  lineTxts3[count3+1] +" "+  lineTxts3[count3+3]+" "+ lineTxts3[count3+4]+" "+ lineTxts3[count3+5]+" "+lineTxts3[count3+6] +" " + lineTxts4[count4+1]+ " "+  lineTxts4[count4+2]+ " "+ lineTxts4[count4+3] + " " + lineTxts[count+1] + "\r\n");//0.6012
					    //bufferedWriter.write(lineTxts[count+1] +  " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+ " "+ "16" + ":"+ lineTxts4[count4+2]+ " "+ "17" + ":"+ lineTxts4[count4+3] + "\r\n");//0.6012
					    //处理结果
					    //bufferedWriter.write(lineTxts2[count2+1] + " " + "1" + ":" + lineTxts[count+1] + " " + "2" + ":"+ lineTxts[count+2] +  " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+ " "+ "16" + ":"+ lineTxts4[count4+2]+ " "+ "17" + ":"+ lineTxts4[count4+3] + "\r\n");//0.6012
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] +  " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] + " " + "12" + ":"+ lineTxts3[count3+4] +" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+ " "+ "16" + ":"+ lineTxts4[count4+2]+ " "+ "17" + ":"+ lineTxts4[count4+3] + "\r\n");//0.5975
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+ " "+ "16" + ":"+ lineTxts4[count4+2]+ " "+ "17" + ":"+ lineTxts4[count4+3] + "\r\n");//0.5987
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] +  " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] + " "+ "16" + ":"+ lineTxts4[count4+2]+ " "+ "17" + ":"+ lineTxts4[count4+3] + "\r\n");//0.5477
					    //bufferedWriter.write(lineTxts[count+1] + " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+"\r\n");//0.5313
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " +"4" + ":"+ lineTxts2[count2+5] + " " +"5" + ":"+ lineTxts2[count2+6] + " " +"6" + ":"+ lineTxts2[count2+7] + " " +"7" + ":"+ lineTxts2[count2+8] + " " +"8" + ":"+ lineTxts2[count2+9] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +" "+ "15" + ":"+ lineTxts4[count4+1]+"\r\n");//0.5161
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] +" "+ "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +"\r\n");//0.5319
					    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " +"8" + ":"+ lineTxts2[count2+1] + " " + "11" + ":"+ lineTxts3[count3+3]+" "+ "12" + ":"+ lineTxts3[count3+4]+" "+ "13" + ":"+ lineTxts3[count3+5]+" "+ "14" + ":"+ lineTxts3[count3+6] +"\r\n");//0.5325
	                    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " + "9" + ":"+ lineTxts3[count3+1] +" "+ "10" + ":"+ lineTxts3[count3+2] +"\r\n");//0.6549
	                    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " +"3" + ":"+ lineTxts[count+11] +"\r\n");
	                    //bufferedWriter.write(lineTxts[count+1] + " " + "4" + ":"+ lineTxts2[count2+5] + " " +"5" + ":"+ lineTxts2[count2+6] + " " +"6" + ":"+ lineTxts2[count2+7] + " " +"7" + ":"+ lineTxts2[count2+8] + " " +"8" + ":"+ lineTxts2[count2+9] +"\r\n");
	                    //bufferedWriter.write(lineTxts[count+1] + " " + "1" + ":" + lineTxts[count+3] + " " + "2" + ":"+ lineTxts[count+4] + " " +"8" + ":"+ lineTxts2[count2+9] +" "+ "9" + ":"+ lineTxts3[count3+1] + "\r\n");//0.6564
						bufferedWriter.flush();
						count = count + 12;
						count2 = count2 + 10;
						count3 = count3 + 7;
						count4 = count4 + 4;
						
				//	}
				}				
				    read.close();
				    
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}
	
        public static void main(String[] args){
	
        	//readTxtFileHead("data/train_new2_data_out.txt","data/features_out_train_out1216.txt","data/train_out_new_wordcompare.txt","data/train_final_3.txt");
        	readTxtFileHead("data/test_new2_data_out.txt","data/features_out_dev_out1216.txt","data/test_out_new_wordcompare.txt","data/dev_final_3.txt");
	
}

}
