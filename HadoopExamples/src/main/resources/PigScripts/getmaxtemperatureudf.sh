#!/bin/bash
# SCRIPT:  getmaxtemperatureudf.sh
#To run the pig script maxtempfilterudf.pig type ./getmaxtemperatureudf.sh
echo $PIG_HOME
pig -x local maxtempfilterudf.pig