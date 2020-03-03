"""
Assignment 4  Program 1 The A-Team

Write a program to read the text from a provided text file into a list, display the text on-screen, 
make some alterations to the text and outputs the changed text to the screen, then save the altered text as a new file.

Name..: Yu Wang, Student
ID....: W0421944
"""
"""
Pseudocode
#######I use a random to get random number which stand for the row which will be deleted.
#######I use a function to make sure the case is right. It is newline(lines,number,newlines,randomnum).
#######At last, I use a for loop to write the new file.
"""

__AUTHOR__ = "Yu Wang <w0421944@.nscc.ca>"

def origintxt():
    print("------------------------------------")
    print("Original Text")
    print("------------------------------------")

def alteredtxt():
    print("------------------------------------")
    print("Altered Text")
    print("------------------------------------")

def newline(lines,number,newlines,randomnum):               #the function that format the alterd text
    for line in lines:
        if len(line) > 20:
            line = line.lower()
        else:
            line = line.upper()
        number += 1
        newline = (str(number) + ": " + line)
        newlines.extend([newline])

    newlines[randomnum-1] = " "

    for resultline in newlines:
        print(resultline)
    return(newlines)

def main():
    file_obj = open("assg4prog1original.txt")               #open the file
    content = file_obj.read()
    file_obj.close()
    
    origintxt()
    print(content + "\n")
    
    alteredtxt()

    import random                                           #import random to dicide which is the random line to delete
    lines = content.split("\n")
    count = len(lines)
    randomnum = random.randint(1,count)
    number = 0
    newlines = []

    newlines = newline(lines,number,newlines,randomnum)     #call the function to make the case format and delete the chosen row.

    file_obj = open("assg4prog1altered.txt","w")            #write the new file
    for line in newlines:
        file_obj.write(line)
        file_obj.write("\n")
    file_obj.close()


if __name__ == "__main__":
	main()