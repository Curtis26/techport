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
# Usage: ./cronprocess.sh <scriptname>
# Peer reviewed: LeeAnn Smith, Graeme Woood
#
#####################################
##########---Variables---############
sname=$1
argument1=$2
#####################################

logPath="/home/oracle/scpts/assg_scpts/log/`date +\%Y\%m\%d`cronlog"
logFilename="`date +\%Y\%m\%d`$sname.cron.log"

if [ ! -d $logPath ]; then
		mkdir -p $logPath
		bash "/home/oracle/scpts/assg_scpts/$sname" $argument1
	else
		bash "/home/oracle/scpts/assg_scpts/$sname" $argument1
fi

