#!/bin/bash
# Date:2019-10-18
# Function: Get user info from username
read -p "Input the username: " A
echo "------------------------------"
n=`cat /etc/passwd | awk -F: '$1~/^'$A'$/{print}' | wc -l`
if [ $n -eq 0 ];then
echo "The user does not exist."
echo "------------------------------"
else
  echo "Username: $A"
  echo "UID: `cat /etc/passwd | awk -F: '$1~/^'$A'$/{print}'|awk -F: '{print $3}'`"
  echo "Group: `id $A | awk {'print $3'}`"
  echo "GID: `cat /etc/passwd | awk -F: '$1~/^'$A'$/{print}'|awk -F: '{print $4}'`"
  echo "Home: `cat /etc/passwd | awk -F: '$1~/^'$A'$/{print}'|awk -F: '{print $6}'`"
  Login=`cat /etc/passwd | awk -F: '$1~/^'$A'$/{print}'|awk -F: '{print $7}'`
  if [ $Login == "/bin/bash" ];then
  echo "This user has login privilege."
  echo "------------------------------"
  elif [ $Login == "/sbin/nologin" ];then
  echo "This user does not have login privilege."
  echo "------------------------------"
  fi
fi