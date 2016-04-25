import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class fileDeal {
	public static void readTxtFileHead(String filePath) {
		try {
			String encoding = "GBK";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("data/svm_train_new3.txt"));
				String lineTxt = null;
				String[] fileContent = new String[1645];
				int i = 0;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					
					String[] getLine = lineTxt.split(" ");
					
					if(!(getLine[0].equals("4.0"))){
						
						//fileContent[i] = lineTxt;
						
						//i = i + 1;
						
						bufferedWriter.write(lineTxt + "\r\n");
						
						bufferedWriter.flush();
						
					}
					
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}
	 public static void main(String[] args){
			
     	readTxtFileHead("data/svm_train_new2.txt");
	
}
}
