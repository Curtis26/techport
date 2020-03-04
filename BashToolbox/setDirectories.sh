#!/bin/sh
#Function: use with addUsers.sh ##change target path##
i=1
while [ i -le 50 ]
do
if [ -d /<target_path> ];then   
mkdir -p -m 754 /userdata/user$i
echo "user$i"
let "i = i + 1"
else
mkdir /userdata 
mkdir -p -m 754 /userdata/user$i
echo "user$i"
let "i = i + 1"   
fi
done