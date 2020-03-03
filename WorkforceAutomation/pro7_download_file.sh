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
# Verson: V1.1
# Date: Dec 02 2019
# Author: Curtis
# Mentor: Tanyia Arenburg
# Discription: Use shell script to download a file from remote server.
# Usage: ./pro7_download_file.sh <URL> <PATH> <new_File_name_with_extension>
# Peer reviewed: LeeAnn Smith, Graeme Woood
#
#####################################
##########---Variables---############
URL=$1
path=$2
nFilename=$3
sec=2
dir=$(pwd)
date=$(date +"%Y%m%d")
time=$(date)
logPath="$dir/log/$date"
errorLog="$dir/log/$date/pro7_error$date.log"
msgLog="$dir/log/$date/pro7_message$date.log"
User=$(whoami)
Owner=`ls -ld $path | awk '{print $3}'`
#####################################

sleep $sec
##Get the file size and file exist text.
wget --spider --output-file=wgetlog.log $URL
size=$(grep "Length" wgetlog.log | egrep -o "[0-9]+ "| sed "s/[ \t]*$//g")
echo "Running..."
sleep $sec
vali_s=$(grep "Remote file exists." wgetlog.log)

if [[ $size -eq "" || $vali_s != "Remote file exists." ]];then
	if [ ! -d $logPath ]; then
		mkdir -p $logPath
	else
		touch $errorLog
		echo "$time File check failed!" >> $errorLog
		##echo "$time Warning! Script has not been executed successfully. Target file cannot be found!" | mail -s "Warning from pro7.sh script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
		exit
	fi
else
	TW=`ls -ld $path|awk '{print $1}'|sed 's/d//g'|grep 'w'|wc -l`
	if [[ "$TW" -eq 0 || $User != $Owner ]]; then
		if [ ! -d $logPath ]; then
			mkdir -p $logPath
		else
			touch $errorLog
			echo "$time Warning! Script has not been executed successfully. Target path cannot be written." >> $errorLog
			##echo "$time Warning! Script has not been executed successfully. Target path cannot be written." | mail -s "Warning from pro7.sh script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
			exit
		fi
	else
		vali_t=$(df -k $path | awk '/[0-9]%/{print $(NF-2)}')
		if [ "$size" -gt "$vali_t" ]; then
			if [ ! -d $logPath ]; then
				mkdir -p $logPath
			else
				touch $errorLog
				echo "$time Warning! Script has not been executed successfully. Target path does not have enough space for target file." >> $errorLog
			##echo "$time Warning! Script has not been executed successfully. Target path does not have enough space for target file." | mail -s "Warning from pro7.sh script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
				exit
			fi
		else
			if [ ! -d $logPath ]; then
				mkdir -p $logPath
			else
				touch $msgLog
				wget -O $nFilename -P $path $URL >> $msgLog
				echo "$time [$URL] has been download to [$path] as [$nFilename]." >> $msgLog
			fi
		fi
	fi
fi
