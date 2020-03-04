#!/bin/bash
#Function: Uppercase the filename in path
for i in `find ./<path>`;do mv $i `echo $i |tr [a-z] [A-Z]`;done