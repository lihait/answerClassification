package nlp_tag;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * 使用斯坦福大学的词性标注工具对英文句子进行词性标注
 * 
 * @author lihaitao
 * 
 */
class TaggerDemo {

	private TaggerDemo() {
	}

	public static String sentenceTag(String strs) throws Exception {
		/**
		 * if (args.length != 1) {
		 * System.err.println("usage: java TaggerDemo modelFile fileToTag");
		 * return; }
		 */
		// 引用分类器
		MaxentTagger tagger = new MaxentTagger(
				"lib/english-left3words-distsim.tagger");
		// List<List<HasWord>> sentences = MaxentTagger.tokenizeText(new
		// BufferedReader(new FileReader(args[0])));
		List<List<HasWord>> sentences = MaxentTagger
				.tokenizeText(new StringReader(strs));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter("C:/models/output/output.txt"));
		String str = null;
		for (List<HasWord> sentence : sentences) {
			ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
			str = str + Sentence.listToString(tSentence, false);
			// while (str != null) {
			// bufferedWriter.write(str + "\r\n");
			// bufferedWriter.flush();
			// }
			// System.out.println(str);
		}
		return str.substring(4,str.length());
	}

}
