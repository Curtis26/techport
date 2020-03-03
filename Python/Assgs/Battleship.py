"""
Assignment 4  Program 3 Battleship

Design and develop a program that replicates the functionality of the provided sample application, a simple version of the game Battleship.

Name..: Yu Wang, Student
ID....: W0421944
"""
"""
Pseudocode
#######I use a function to get the user's target grid and make sure it's valid to input. It is target().
#######I use a function to get the user's action and hit the ship. It is hittheship(mapgrid,targetlist).
#######Then I open the map.txt to get the shipmap.
#######I make a grid to record whether the user hit the ship or not.
"""
__AUTHOR__ = "Yu Wang <w0421944@.nscc.ca>"


def target():    #the function to get input.
	colalp = ["A","B","C","D","E","F","G","H","I","J"]     	#the letter of the col
	numbers = ["1","2","3","4","5","6","7","8","9","10"]	#the number
	answer = "false"										
	while(answer != "true"):		#a while loop to input again if the user give an invalid one
		guess_target= input("Choose your target (Ex. A1): ").upper()		#make it lettercase unsensitive
		targetgrid = []
		for i in guess_target:
			targetgrid.extend([i])
		count = len(targetgrid)	
		if count == 2:					#for the 1-9 row
			number = targetgrid[1]
			if targetgrid[0] in colalp and number in numbers:
				quit
			else:
				print("Please type the valid target！")
				continue
		elif count == 3:				#for the 10 row
			number = targetgrid[1] + targetgrid[2]
			if targetgrid[0] in colalp and number in numbers:
				quit
			else:
				print("Please type the valid target！")
				continue
		else:							#others
			print("Please type the valid target！")
			continue
		return([targetgrid[0],number])

def hittheship(mapgrid,targetlist):		#the function to get the hit
	trytimes = 30				
	targetnum = 17
	shipcount = 17
	hittimes = 0
	result = ""
	while (result == ""):
		trytimes += -1

		col = ["  ","A","B","C","D","E","F","G","H","I","J"]

		targetgrid = []
		targetgrid = target()		#call the function to get the user target grid

		targetlist_col = col.index(targetgrid[0])
		targetlist_row = int(targetgrid[1])

		if mapgrid[targetlist_row-1][targetlist_col-1] == "X":							#avoid repeating the hit grid.
			print("Miss!\nYou have " + str(trytimes) +" missiles remaining")
			mapgrid[targetlist_row-1][targetlist_col-1] = "X"
		elif targetlist[targetlist_row-1][targetlist_col-1] == "1":						#hit situation
			print("HIT!!!!!\nYou have " + str(trytimes) +" missiles remaining")	
			mapgrid[targetlist_row-1][targetlist_col-1] = "X"
			hittimes += 1
			targetnum += -1
		else:
			print("Miss!\nYou have " + str(trytimes) +" missiles remaining")			#miss situation
			mapgrid[targetlist_row-1][targetlist_col-1] = "0"
		
		print(" ".join(col))				#print the result to the user
		a = 0
		for row in mapgrid:					#output the map with the last hit result
			a += 1	
			if a < 10:
				print(str(a)+ "  " + " ".join(row))
			else:
				print(str(a)+ " " + " ".join(row))

		if targetnum == 0:					#output the game result
			print("YOU SANK MY ENTIRE FLEET!\nYou had {0} of {1} hits, which sank all the ships.\nYou won, congratulations!".format(hittimes,shipcount))
			result = "success"
		elif trytimes >= targetnum:
			continue
		else:
			print("GAME OVER.\nYou had {0} of {1} hits, but didn't sink all the ships. Better luck next time.".format(hittimes,shipcount))
			result = "failure"

def main():
	objFile = open("map.txt")   		#open the file
	mapcontent = objFile.read()
	mapcontent = mapcontent.replace(" ","")
	objFile.close()

	targetlist = mapcontent.split("\n")	#split the map

	mapgrid = []						#make the user mapgrid
	for i in range(0,10):
		mapgrid.append([" "] * 10)

	hittheship(mapgrid,targetlist)		#play the game

if __name__ == "__main__":
	main()