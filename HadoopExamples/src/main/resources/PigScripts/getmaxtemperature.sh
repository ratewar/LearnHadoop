#!/bin/bash
# SCRIPT:  getmaxtemperature.sh
#To run the pig script maxtemperature.pig type ./getmaxtemperature.sh
echo $PIG_HOME
pig -x local maxtemperature.pig
