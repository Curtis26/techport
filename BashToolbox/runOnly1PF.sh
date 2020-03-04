#!/bin/bash
#Part of script
#Function: run only one at the same time..
function run_only_one(){
        PID=$$
        snum=`ps -ef|grep $0|grep -v grep|grep -v " $PPID "|grep -v " $PID "|wc -l`
        if [ $snum -lt 1 ]; then
            echo "start process....."
        else
            echo "runing....."
            exit
        fi  
}
run_only_one