#!/bin/sh
#Function: Backup /etc to /root/bak
#echo "0 0 1 * * /path/scriptfilename" > /root/etcbakcron
#crontab /root/etcbakcron
DIRNAME=`ls /root | grep bak`   
if [ -z "$DIRNAME" ] ; then
mkdir /root/bak
cd /root/bak
fi
BACKETC=$(date +%Y%m%d)_etc.tar.gz
tar zcvf  $BACKETC  /etc
echo "etc File backup finished!"