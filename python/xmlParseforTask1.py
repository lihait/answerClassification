try:
        import xml.etree.cElementTree as ET
except ImportError:
        import xml.etree.ElementTree as ET
import sys
import math
import types
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
from nltk.corpus import wordnet
#去除停用词
#test 句子； sq  停用词表
def stepwords(test,sq):
        english_stopwords = stopwords.words('english')        
        #print(sq)
        #english_stopwords.extend(sq)
        #扩展停用词库
        english_stopwords.append('?')
        english_stopwords.append('.')
        english_stopwords.extend([',',"\"","\'s","\'ve",'!',':',';','(',')','&',
                                  '...','ok','hi','>','/>','<','--','..','-',"\'\'",'``'])
        text_tokenized = [word for word in word_tokenize(test)]
        #获得去除停用词后的主要词
        filter_words = [word for word in text_tokenized if word.lower() not in english_stopwords]
        print(filter_words)
        return filter_words;
#句子相似度
#d、f 表示两个句子
def similarity(d,f):
        dseq = d
        fseq = f
        #ddd 、fff 表示相似度向量
        ddd = []
        fff = [1]*len(fseq)
        for word1 in dseq:
                sim = 0
                for word2 in fseq:
                        wordset1 = wordnet.synsets(word1.lower())
                        wordset2 = wordnet.synsets(word2.lower())
                        #查找两个词的名词性最短距离
                        if(len(wordset1)>0 and len(wordset2)>0):
                                path = wordset1[0].shortest_path_distance(wordset2[0])
                                #使用指数函数表示距离越近，相似度越大
                                if(type(path) == int and math.exp(-path)>sim):
                                        sim = math.exp(-path)
                fff.append(sim);
        for word1 in fseq:
                sim = 0
                for word2 in dseq:                    
                        wordset1 = wordnet.synsets(word1.lower())
                        wordset2 = wordnet.synsets(word2.lower())
                        #查找两个词的名词性最短距离
                        if(len(wordset1)>0 and len(wordset2)>0):
                                path = wordset1[0].shortest_path_distance(wordset2[0])
                                #使用指数函数表示距离越近，相似度越大
                                if(type(path) == int and math.exp(-path)>0.1 and math.exp(-path)>sim):
                                        sim = math.exp(-path)
                ddd.append(sim)
        ddd.extend([1]*len(dseq))
        cos=0.0
        maxd=0.0
        maxf = 0.0
        #余弦值获得句子的相似度
        for i in range(len(ddd)):
                maxd = maxd+float(ddd[i])*float(ddd[i])
                maxf = maxf+float(fff[i])*float(fff[i])
                cos = cos +ddd[i]*fff[i]
        a = math.sqrt(maxd)*math.sqrt(maxf)
        if(a==0):
                b = 0
        else:
                b = cos/a
        print(b)
        return b;
#读取停用词表
fst = open("data/stopwords.txt")
sq = []
for line in fst.readlines():
    sp = line.split()
    sq.extend(sp)
fst.close()
#解析xml文件
try:
        tree = ET.parse("data/xml/test.xml")
        root = tree.getroot()
except Exception as e:
        print("Errot:parse file train.xml failed!")
        sys.exit(1)
#预处理结果输出文件地址
fp = open("data/task2/YN_test_out.txt",'w+')
print("*"*50)
for Question in root.findall('Question'):
        QSubject = Question.find('QSubject')        
        #此部分用于提取YES_NO类型问题与答案,其他时，请注释
        if(Question.get("QTYPE") != "YES_NO"):
                continue        
        QBody = Question.find('QBody')
        QSlen = len(QSubject.text)
        QBlen = len(QBody.text)
        QSubEl = stepwords(QSubject.text,sq)
        #去除停用词为空，则说明句子本身长度小，直接使用
        if(len(QSubEl)==0):
                QSubEl = QSubject.text.split()
        QBoEl = stepwords(QBody.text,sq)
        Comments = Question.findall('Comment')
        users={Question.get("QUSERID"):1}
        #获得用户账号在该问题组中出现次数
        count = 0
        for com in Comments:
                CUser = com.get("CUSERID")
                count= count +1
                if(CUser in users):
                        users[CUser] = users[CUser]+1
                else:
                        users[CUser] = 1
        for comment in Comments:
                CSubject = comment.find('CSubject')                
                #用于输出YES_NO格式，其他类型，注释
                if(comment.get("CGOLD_YN")!="Not Applicable"):
                        CBody = comment.find('CBody')
                        CBlen = len(CBody.text)
                        CBoEl = stepwords(CBody.text,sq)
                        #问题答案不为空或者其他语言
                        #test 文件中不包含 CGOLD_YN属性
                        if(len(CBody.text.split())>0):
                                CBoEl = CBody.text.split()
                                CFlag = 0
                                if(len(CBoEl)==0):
                                        CBolen = CBody.text.split()
                                fp.write(comment.get('CID')+'\t'+comment.get('CGOLD')+                                 
                                 '\t'+Question.get('QCATEGORY')+'\t'+Question.get('QGOLD_YN')+
                                 '\t'+str(users[comment.get("CUSERID")])+'\t'+str(QSlen/CBlen)+
                                 '\t'+str(QBlen/CBlen)+'\t'+str(len(QSubEl)/len(CBoEl))+
                                 '\t'+str(len(QBoEl)/len(CBoEl))+
                                 '\t'+str(similarity(QSubEl,CBoEl))+'\n')
                        else:
                                fp.write(comment.get('CID')+'\t'+comment.get('CGOLD')+                                 
                                 '\t'+Question.get('QCATEGORY')+'\t'+Question.get('QGOLD')+
                                 '\t'+str(users[comment.get("CUSERID")])+'\t'+str(0)+
                                 '\t'+str(0)+'\t'+str(0)+
                                 '\t'+str(0)+
                                 '\t'+str(0)+'\n')
                '''
                CBody = comment.find('CBody')
                CBlen = len(CBody.text)
                CBoEl = stepwords(CBody.text,sq)
                #问题答案不为空或者其他语言
                if(len(CBody.text.split())>0):
                        CBoEl = CBody.text.split()
                        CFlag = 0
                        if(len(CBoEl)==0):
                                CBolen = CBody.text.split()
                        if(CBody.text.find('&gt')!=-1):
                                CFlag = 1
                        fp.write(comment.get('CID')+'\t'+comment.get('CGOLD')+                                 
                                '\t'+Question.get('QCATEGORY')+'\t'+Question.get('QTYPE')+
                                '\t'+str(users[comment.get("CUSERID")])+'\t'+str(QSlen/CBlen)+
                                '\t'+str(QBlen/CBlen)+'\t'+str(len(QSubEl)/len(CBoEl))+
                                '\t'+str(len(QBoEl)/len(CBoEl))+
                                '\t'+str(similarity(QSubEl,CBoEl))+'\n')
                else:
                        fp.write(comment.get('CID')+'\t'+comment.get('CGOLD')+                                 
                                '\t'+Question.get('QCATEGORY')+'\t'+Question.get('QTYPE')+
                                '\t'+str(users[comment.get("CUSERID")])+'\t'+str(0)+
                                '\t'+str(0)+'\t'+str(0)+
                                '\t'+str(0)+
                                '\t'+str(0)+'\n')
                '''
fp.flush()
fp.close()

