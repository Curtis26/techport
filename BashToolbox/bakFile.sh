#!/bin/bash
#Function: Move file which size >100K in path1 to path2
read -p "Input the full source path: " Path1
read -p "Input the full target path: " Path2
for FILE in `ls $Path1` 
do  
    if [ -f $FILE ] ; then  
        if [ `ls -l  $FILE | awk `{print $5}` -gt 102400 ] ; then  
            mv $FILE $Path2 
        fi  
    fi  
done  