#!/bin/sh
#Function: Kill process and all its child processes
pstree -p PID | grep -oP '(?<=\()[0-9]+(?=\))'|xargs kill -9