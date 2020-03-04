#!/bin/bash  
    ftp -n << END_FTP
    open 192.168.1.22  
    user test testing
    binary
    prompt  off
    mput files
    close  
    bye  
    END_FTP
