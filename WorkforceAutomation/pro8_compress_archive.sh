#!/bin/bash

#####################################
#
#	Pseudocode 
# 1. Set a sleep time into a variable.
# 2. Check if the path can be written by current user.
# 3. Check the target file size and if the file exist or not.
# 4. If the file not found, send message to the error logfile, send email and quit.
# 5. If user cannot write in the target path, send message to error log, send email and quit.
# 6. Check the target path available storage, and if the file size bigger than it
#    send message to error log, send email and quit.
# 7. If everything worked well, download the file and send message to message log.
# 8. User need to input the target url, path and new file name with extension when using it.
#
#####################################
#
# Verson: V1.0
# Date: Dec 02 2019
# Author: Curtis
# Mentor: Tanyia Arenburg
# Discription: Use shell script to compress files.
# Usage: ./pro8_compress_archive.sh <filepath> <targetpath> <filename_without_extension>
# Peer reviewed: LeeAnn Smith, Graeme Woood
#
#####################################
##########---Variables---############
filePath=$1
tarPath=$2
tarName=$3.tar.gz
dir=$(pwd)
date=$(date +"%Y%m%d")
time=$(date)
logPath="$dir/log/$date"
errorLog="$dir/log/$date/pro8_error$date.log"
msgLog="$dir/log/$date/pro8_message$date.log"
User=$(whoami)
Owner1=`ls -ld $filePath | awk '{print $3}'`
Owner2=`ls -ld $tarPath | awk '{print $3}'`
#####################################

TR=`ls -ld $filePath|awk '{print $1}'|sed 's/d//g'|grep 'r'|wc -l`

if [[ "$TR" -eq 1 && $User = $Owner1 ]]; then
	if [ ! -d $tarPath ]; then
		mkdir -p $tarPath
		tar -cvzpf $tarPath/$tarName $filePath
	else
		TW=`ls -ld $tarPath|awk '{print $1}'|sed 's/d//g'|grep 'w'|wc -l`
		if [[ "$TW" -eq 0 || $User != $Ower2 ]]; then
			if [ ! -d $logPath ]; then
				mkdir -p $logPath
			else
				touch $errorLog
				echo "$time Warning! Script has not been executed successfully. Target path cannot be written." >> $errorLog
				##echo "$time Warning! Script has not been executed successfully. Target path cannot be written." | mail -s "Warning from pro8.sh script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
				exit
			fi
		else
			if [ ! -d $logPath ]; then
				mkdir -p $logPath
			else
				touch $msgLog
				tar -cvzpf $tarPath/$tarName $filePath
				echo "$time SUCCESS, [$filePath] files zipped as [$tarName] in [$tarPath]!" >> $msgLog
			fi
		fi
	fi
else
	if [ ! -d $logPath ]; then
				mkdir -p $logPath
			else
				touch $errorLog
				echo "$time Warning! Script has not been executed successfully. File path cannot be read." >> $errorLog
				##echo "$time Warning! Script has not been executed successfully. File path cannot be read." | mail -s "Warning from pro8.sh script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
	fi
fi
