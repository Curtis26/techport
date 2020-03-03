"""
Assignment 4  Program 2 The Itsy Bitsy Aardwark

Design and develop a program that presents the user with a “Mad Libs” type game, 
where a random choice of words are read from a file, then interjected into a story read from another file.

Name..: Yu Wang, Student
ID....: W0421944
"""
"""
Pseudocode
#######Read the story file first.
#######Then read the csv file to get the choices.
#######I use a function result(choicecontent) to get user's choices and keep them in a list.
#######At last, I replace the blanks with the choices.
"""
__AUTHOR__ = "Yu Wang <w0421944@.nscc.ca>"


def result(choicecontent):								#the function pick the choices from the csv file and keep them in result list
	csvlines = choicecontent.split("\n")
	result = []
	choicealph = ["","a","b","c","d","e"]
	for csvsingleline in csvlines:
		indexnum = 0
		userchoice = ""
		linechoices = csvsingleline.split(",")
		for choice in linechoices:
			if indexnum == 0:
				print(choicealph[indexnum] + "\nPlease choose" + choice + ":")
			else:
				print(choicealph[indexnum] +") " + choice)
			indexnum = indexnum + 1
		while userchoice == "":
			userchoice = input("Enter choice (a-e):").lower()
			if userchoice in ["a","b","c","d","e"]:
				indexforuser = choicealph.index(userchoice)
				choiceinlist = linechoices[indexforuser]
				result.extend([choiceinlist])
			else:
				print("It's not a valid answer. Try it again.")
				userchoice = ""
	return(result)

def main():
	txtfile_obj = open("the_story_file.txt")			#read the story file
	storycontent = txtfile_obj.read()
	txtfile_obj.close()

	txtlines = storycontent.split("\n")
	
	csvfile_obj = open("the_choices_file.csv")			#read the choices file
	choicecontent = csvfile_obj.read()
	csvfile_obj.close()

	print("The Itsy Bitsy Aardwark")

	resultlist = result(choicecontent)					#call the funtion to get the result list

	count = 0 
	for cell in resultlist:								#use a for loop to replace blanks with the choices
		cell = cell.upper()
		count += 1
		storycontent = storycontent.replace("_"+str(count)+"_",cell)

	print("\n" + storycontent)							#print the final story content

if __name__ == "__main__":
	main()