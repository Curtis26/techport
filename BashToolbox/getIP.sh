#/bin/bash  
IP=ifconfig eth0|grep 'inet addr'|sed 's/^.*addr://g'|awk  '{print $1}'  
NETMASK=ifconfig eth0 |grep "inet addr"|sed 's/^.*Mask://g'  
echo "$IP/$NETMASK"  
exit  