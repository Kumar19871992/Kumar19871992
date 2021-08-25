import spacy 
import re
import en_core_web_sm 
nlp = en_core_web_sm.load()
from flask import Flask, jsonify
from flask import request

app = Flask(__name__)

def getName(numrolls):
	try:
		doc = nlp(request.form['nameAddress']) 
		nameslist = []
		namesdict = {}		
		for ent in doc.ents: 
		#print(ent.text, ent.start_char, ent.end_char, ent.label_)
		#print(ent.text,  ent.label_)
			if (ent.label_ == 'ORG' or ent.label_ == 'PERSON') :
				namesdict[ent.label_] = ent.text
				break
		if len(list(namesdict.keys())) > 0:        
			nameslist.append(list(namesdict.values())[0])
			nameslist.append(list(namesdict.keys())[0])	
		else:
			nameslist.append("")
			nameslist.append("")
		return nameslist
	except:
		return ""
		
def getPostalCode(inputaddr):
    try:
        thelist = []
        thelist2 = []     
        thelist = re.findall('([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\s?[0-9][A-Za-z]{2})|(\d{5,})|(\d{3,}-\d{3,})', inputaddr)
		#print(thelist)
		
        thelist2 = thelist[0]
		
		#a_list = ["a_string", "the_longest_string", "string"]
        longest_string = max(thelist2, key=len)
		#print(longest_string)
			
        return longest_string
    except:
        return ""
def getAccountNumber(inputaddr):
	stdAccLabels = ["U/H","Unitholder","A/C","Account","Client","CL","UHID","Acc"]
	accRawData = []
	accFilterdData = []
	accno = ""
	for i in stdAccLabels:
    #print(i)
		ignorecase = re.compile(i, re.IGNORECASE)
		accRawData = re.split(ignorecase, inputaddr) 
		if len(accRawData) > 1:
			accFilterdData = accRawData[-1]
			break
		else:
			accFilterdData = ""
		
	print(accFilterdData )
	accno = re.findall('[0-9]+', accFilterdData)
		
	#return ' '.join([str(elem) for elem in accno])
	return accno

def getAgentNumber(inputaddr):
	stdAgentLabels = ["Agent","Agent Code","Agent Ref","Agent Number","Code","Ref","Number"]
	agentRawData = []
	agentFilterdData = []
	for i in stdAgentLabels:
		#print(i)
		ignorecase = re.compile(i, re.IGNORECASE)
		agentRawData = re.split(ignorecase, inputaddr)
		if len(agentRawData) > 1:
			agentFilterdData = agentRawData[-1]
			break
		else:
			agentFilterdData = ""
    
	
	agentno = re.findall('[0-9][A-Za-z]?', agentFilterdData)
	print(agentFilterdData )
	s = ''.join([str(elem) for elem in agentno]) 
	print(s)
	return s

def getAmount(amount_sentence):
	listAmount = []
	amount =[]
	amount_sentence = amount_sentence.replace(',', '')
	formated = re.sub('[a-zA-Z]{1}1', '', amount_sentence)
	formated = re.sub('[a-zA-Z]{1}2', '', formated)
		
	print(formated)
	amountRawData = []
	amount = re.findall('\d*\.?\d+', formated)
	print(len(amount))
	if len(amount) == 1:
		listAmount.append(amount)
		
			
	else:    
		for i in range(len(amount)):
			listAmount.append(amount[i])
    
	#ignorecase = re.compile("\LI*", re.IGNORECASE)
	lifoflag =  re.search('([Ll]{1}[Ii]{1}[Ff]{1})|([Ll]{1}[Aa]{1}[Ss]{1})', formated)
	fifoflag =  re.search('([Ff]{1}[Ii]{1}[Ff]{1})|([Ff]{1}[Ii]{1}[Rr]{1})', formated)	
	if lifoflag:
		listAmount.append("LIFO") 
	#ignorecase2 = re.compile("\FI*", re.IGNORECASE)
	
	 
	elif fifoflag:
		listAmount.append("FIFO") 
	else :
		listAmount.append("DEFAULT")   
 
	return listAmount


def listToString(s):  
    
    # initialize an empty string 
    str1 = " " 
    
    # return string   
    return (str1.join(s)) 

def getAmountData(listData):
	list = ["","","",""]
	print(listData)
	if len(listData) ==2:
		list[0] = listData[0]
		list[3] = listData[1]
	
	if len(listData) ==4:
		list[0] = listData[0]
		list[1] = listData[1]
		list[2] = listData[2]
		list[3] = listData[3]
	print(list)	
	return list	
 	
@app.route('/getNamePostCodeAcnNumb' , methods=['GET', 'POST'])
def getNamePostCodeAcnNumb():
	list = []
	list = getName(request.form['nameAddress'])
	
	return jsonify({'Name': list[0], 'Type': list[1],  'PostalCode': getPostalCode(request.form['nameAddress']), 'AccountNumber': getAccountNumber(request.form['nameAddress'])})
 
@app.route('/getAgentDetails' , methods=['GET', 'POST'])
def getAgentDetails():
	list = []
	list = getName(request.form['nameAddress'])
	
	return jsonify({'Name': list[0], 'Type': list[1],  'PostalCode': getPostalCode(request.form['nameAddress']), 'AgentNumber': getAgentNumber(request.form['nameAddress'])})
	
@app.route('/getUnits' , methods=['GET', 'POST'])
def getUnits():
	lData = []
	listData2 = getAmount(request.form['figure'])
	lData = getAmountData(listData2)
	
	return jsonify({'Amount': lData[0],  'G1': lData[1], 'G2': lData[2], 'TypeofProcessing': lData[3]})
	 
if __name__ == '__main__':
    app.run(host='localhost', port=8000, debug=True)