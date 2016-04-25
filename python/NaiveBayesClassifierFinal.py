#coding=utf-8  
import nltk
import math
# 读入特征文件
def readFile(filename):
    #读取特征文件
    fp = open(filename,"r")
    #'f2':0.1864406779661017,'f3':0.6271186440677966,
    #({'f0': 'Beauty and Style','f1': 'GENERAL','f2':0.1864406779661017,'f3':0.6271186440677966,'f4':0.15384615384615385,'f5':0.3076923076923077,'f6':2.7478126808466766e-5}, 'Bad')
    featureset = []
    for line in fp.readlines():
        sq = line.split('\t')
        sq[-1] = sq[-1][0:-1]
        #sq[9] = float(sq[9])
        '''
        ###########sq[5]------f2
        if(sq[5]<0.05):
            sq[5] = 'a'
        elif(sq[5]<=0.1):
            sq[5] = 'b'
        elif(sq[5]<=0.18):
            sq[5]='c'
        elif(sq[5]<=0.3):
            sq[5] = 'd'
        elif(sq[5]<=0.5):        
            sq[5] = 'e'
        elif(sq[5]<=0.7):
            sq[5] = 'f'
        elif(sq[5]<=1):
            sq[5]='g'
        elif(sq[5]<=3):
            sq[5] = 'h'
        else:
            sq[5] = 'i'
        ###########sq[6]------f3
        if(sq[6]<0.05):
            sq[6] = 'a'
        elif(sq[6]<=0.1):
            sq[6] = 'b'
        elif(sq[6]<=0.2):
            sq[6] = 'c'
        elif(sq[6]<=0.4):
            sq[6] = 'd'
        elif(sq[6]<=0.6):
            sq[6] = 'e'
        elif(sq[6]<=1):
            sq[6] = 'f'
        elif(sq[6]<=3):
            sq[6] = 'g'
        elif(sq[6]<=5):
            sq[6] = 'h'
        else:
            sq[6] = 'i'
        ###########sq[7]------f4
        if(sq[7]<0.05):
            sq[7] = 'a'
        elif(sq[7]<=0.1):
            sq[7] = 'b'
        elif(sq[7]<=0.18):
            sq[7]='c'
        elif(sq[7]<=0.3):
            sq[7] = 'd'
        elif(sq[7]<=0.5):        
            sq[7] = 'e'
        elif(sq[7]<=0.7):
            sq[7] = 'f'
        elif(sq[7]<=1):
            sq[7]='g'
        elif(sq[7]<=3):
            sq[7] = 'h'
        else:
            sq[7] = 'i'
        ###########sq[8]------f5
        if(sq[8]<0.05):
            sq[8] = 'a'
        elif(sq[8]<=0.1):
            sq[8] = 'b'
        elif(sq[8]<=0.2):
            sq[8] = 'c'
        elif(sq[8]<=0.4):
            sq[8] = 'd'
        elif(sq[8]<=0.6):
            sq[8] = 'e'
        elif(sq[8]<=1):
            sq[8] = 'f'
        elif(sq[8]<=3):
            sq[8] = 'g'
        elif(sq[8]<=5):
            sq[8] = 'h'
        else:
            sq[8] = 'i'
        '''
        '''
        ###########sq[9]------f6
        if(sq[9]<1e-6):
            sq[9] = 'a'
        elif(sq[9]<=5e-6):
            sq[9] = 'b'
        elif(sq[9]<=1e-5):
            sq[9]='c'
        elif(sq[9]<=2e-5):
            sq[9] = 'd'
        elif(sq[9]<=4e-5):
            sq[9] = 'e'
        elif(sq[9]<=7e-5):
            sq[9] = 'f'
        elif(sq[9]<=1e-4):
            sq[9] = 'g'
        elif(sq[9]<=3e-4):
            sq[9] = 'h'
        elif(sq[9]<=7e-4):
            sq[9] = 'i'
        elif(sq[9]<=1e-3):
            sq[9] = 'j'
        elif(sq[9]<=2e-3):
            sq[9] = 'k'
        elif(sq[9]<=4e-3):
            sq[9] = 'l'
        elif(sq[9]<=7e-3):
            sq[9] = 'm'
        elif(sq[9]<=0.01):
            sq[9]='n'
        elif(sq[9]<=0.02):
            sq[9] = 'o'
        elif(sq[9]<=0.03):
            sq[9] = 'p'
        elif(sq[9]<=0.04):
            sq[9]='q'
        elif(sq[9]<=0.05):
            sq[9]='r'
        elif(sq[9]<=0.06):
            sq[9] = 's'
        elif(sq[9]<=0.07):
            sq[9] = 't'
        elif(sq[9]<=0.08):
            sq[9]='u'
        elif(sq[9]<=0.1):
            sq[9] ='v'
        elif(sq[9]<=0.2):
            sq[9] = 'w'
        elif(sq[9]<=0.3):
            sq[9]='x'
        elif(sq[9]<=0.4):
            sq[9] = 'y'
        elif(sq[9]<=0.5):
            sq[9] = 'z'
        elif(sq[9]<=0.6):
            sq[9] = '1'
        elif(sq[9]<=0.7):
            sq[9] = '2'
        else:
            sq[9] = '3'
        '''
        #YES_NO
        '''
        Ctarget = 0
        if(sq[0]=='Yes'):
            Ctarget = 1
        elif(sq[0]=='Unsure'):
            Ctarget = 0        
        else:
            Ctarget =-1
        sq[0] = Ctarget
        '''
        Qtarget = 0
        if(sq[1]=='Yes'):
            Qtarget = 1
        elif(sq[1]=='No'):
            Qtarget = 0        
        else:
            Qtarget =-1
        sq[1] = Qtarget
        '''
        sq[1] = float(sq[1])
        sq[2] = float(sq[2])
        sq[3] = float(sq[3])
        sq[4] = float(sq[4])
        sq[5] = float(sq[5])
        sq[6] = float(sq[6])
        sq[7] = float(sq[7][0:-1])
        '''
        sq[3] = float(sq[3])
        sq[4] = float(sq[4])
        #task 1:'f2':sq[2],'f3':sq[3],'f4':sq[4],'f5':sq[5],'f6':sq[6],'f7':sq[7],'f8':sq[8],'f9':sq[9]
        #task 2:'f0':sq[3]-sq[4],"f1":sq[7]***'f0':sq[4],"f1":sq[7]***sq[2],sq[7]
        #'f0':sq[2],'f1':sq[3],'f2':sq[4],'f3':sq[7]
        #sq[7],sq[3] 0.5294117647058824 
        #sq[2],sq[7] 0.5882352941176471
        #sq[2],sq[3] 0.47058823529411764
        #sq[4],sq[7] 0.5294117647058824
        #sq[2],sq[3],sq[4],sq[7] 0.5588235294117647
        #sq[2],sq[3],sq[4] 0.5294117647058824
        #sq[3]sq[4]sq[7] 0.5294117647058824
        #'f0':sq[2],'f3':sq[7],
        featureset = featureset+ [({'f4':sq[-1]},sq[1])]
    fp.close()
    return featureset

#filename = input("trian filename\n")
#testname = input("test filename:\n")
filename = "task2/YN_train_out_4.txt"
testname = "task2/YN_dev_out_5.txt"
train_set = readFile("data/"+filename)
#print(train_set[2])
test_set = readFile("data/"+testname)
classifier = nltk.NaiveBayesClassifier.train(train_set)
# 通过测试集来估计分类器的准确性  
print(nltk.classify.accuracy(classifier, test_set))  
# 输入f1/f2测试分类结果  
#print(classifier.classify({'f1': '3.0','f2':'0.1'}))  
# 找出最能够区分分类的特征值  
classifier.show_most_informative_features(10)
