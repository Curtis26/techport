#!/bin/bash
# Date:2019-12-18
# Function: Get detail from PID
read -p "Input PID: " P
n='ps -aux| awk '$2~/^'$P'$/{print $11}'|wc -l'
if [ $n -eq 0 ];then
 echo "The PID does not exist."
 exit
fi
echo "--------------------------------"
echo "PID: $P"
echo "Process locate: `ps -aux| awk '$2~/^'$P'$/{print $11}'`"
echo "Owned user: `ps -aux| awk '$2~/^'$P'$/{print $1}'`"
echo "CPU used: `ps -aux| awk '$2~/^'$P'$/{print $3}'`%"
echo "Memory used: `ps -aux| awk '$2~/^'$P'$/{print $4}'`%"
echo "Run time: `ps -aux| awk '$2~/^'$P'$/{print $9}'`"
echo "Duration: `ps -aux| awk '$2~/^'$P'$/{print $10}'`"
echo "Status: `ps -aux| awk '$2~/^'$P'$/{print $8}'`"
echo "VIRT: `ps -aux| awk '$2~/^'$P'$/{print $5}'`"
echo "Shared memory: `ps -aux| awk '$2~/^'$P'$/{print $6}'`"
echo "--------------------------------"