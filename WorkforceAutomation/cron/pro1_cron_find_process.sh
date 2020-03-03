#!/bin/bash

#####################################
#
#	Pseudocode 
# 1. Set a sleep time into a variable
# 2. Check the process background process is running.
# 3. Get the count of the result
# 4. If the count it's 0, send message to the error logfile and send email.
# 5. If the count it's not 0, send message to logfile and keep it running.
# 6. Use proper validations to make sure script can work properly.
# 7. User need to input the process name when using it.
#
#####################################
#
# Verson: V1.0
# Date: Nov 15 2019
# Author: Curtis
# Mentor: Tanyia Arenburg
# Discription: Use shell script to monitor the background process
# Usage: ./pro1_find_process.sh <pname> &
# Peer reviewed: LeeAnn Smith, Graeme Woood
#
#####################################
##########---Variables---############
pname=$1
date=$(date +"%Y%m%d")
dir=$(pwd)
time=$(date)
logPath="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog/"
errorLog="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog/pro1_error$date.log"
msgLog="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog/pro1_message$date.log"
ocrThread=`ps -ef|grep -i $pname |grep -v 'grep'|grep -v 'bash'`
count=`ps -ef|grep -i $pname |grep -v 'grep'|grep -v 'bash'|wc -l`
#####################################

if [ $count -eq 0 ]; then
	if [ ! -d $logPath ]; then
		mkdir -p $logPath
	else
		touch $errorLog
		echo "$time Warning! Key process [$pname] does not exist!" >> $errorLog
		##echo "$time Warning! Key process [$pname] does not exist!" | mail -s "Warning from automate monitoring process [$pname] script" -t curtis766@outlook.com -a From:w0421944@nscc.ca
	fi
	else
	if [ ! -d $logPath ]; then
		mkdir -p $logPath
	else
		touch $msgLog
		echo "$time [$ocrThread] : $count Process found. Running..." >> $msgLog
	fi
fi
