#!/bin/bash

#####################################
#
#	Pseudocode 
# 1. Set a sleep time into a variable.
# 2. Check if the path can be read by current user.
# 3. Get the count of priviledge result.
# 4. If the count it's 0, send message to the error logfile and send email.
# 5. If the count it's not 0, send message to logfile and keep it running.
# 6. Use proper validations to make sure script can work properly.
# 7. User need to input the path when using it.
#
#####################################
#
# Verson: V1.0
# Date: Nov 15 2019
# Author: Curtis
# Mentor: Tanyia Arenburg
# Discription: Use shell script to find the largest file in target directory.
# Usage: ./pro4_cron_find_largest_file.sh <path>
# Peer reviewed: LeeAnn Smith, Graeme Woood
#
#####################################
##########---Variables---############
path=$1;
date=$(date +"%Y%m%d")
dir=$(pwd)
time=$(date)
User=$(whoami)
logPath="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog/"
errorLog="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog/pro4_error$date.log"
msgLog="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog/pro4_message$date.log"
Owner=`ls -ld $path | awk '{print $3}'`
TR=`ls -ld $path|awk '{print $1}'|sed 's/d//g'|grep 'r'|wc -l`
#####################################

if [[ $User != $Owner || "$TR" -eq 0 ]]; then
	if [ ! -d $logPath ]; then
		mkdir -p $logPath
	else
		touch $errorLog
		echo "$time Warning! Script has not been executed successfully. Target path cannot be read." >> $errorLog
		##echo "$time Warning! Script has not been executed successfully." | mail -s "Warning from pro4.sh script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
	fi
	else
	##check the space
	if [ ! -d $logPath ]; then
		mkdir -p $logPath
	else
		touch $msgLog
		result=$(find $path -type f -exec stat -c "%s %n" {} \; | sort -nr | head -1)
		echo "$time [$result] : Largest file found. Running..." >> $msgLog
	fi
fi
