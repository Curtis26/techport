#!/bin/bash
#Function: Lowercase the filename in path
for i in `find ./<path>`;do mv $i `echo $i |tr [A-Z] [a-z]`;done