#!/bin/bash  
for i in `seq 1 50`
do
    useradd -G student student$i;   
    echo student$i | passwd student$i --stdin; 
done