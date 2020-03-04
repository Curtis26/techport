#!/bin/bash  
#Function: Monitor available disk space and if go up with 90% used send email
IP=`ifconfig eth0 | grep "inet addr" | cut -f 2 -d ":" | cut -f 1 -d " "`      
SPACE=`df -hP | awk '{print int($5)}'`  
if [ $SPACE -ge 90 ]  
then  
  echo "ATTN: $IP server space used > 90%." | mail -s "$IP Space Warning" curtis766@outlook.com 
fi  
