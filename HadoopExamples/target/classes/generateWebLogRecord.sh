#!/bin/bash
# SCRIPT:  generateWeblogRecord.sh
#Generate the Java Class for the weblogrecord.thrift
#Once for Reference file is already created and available in the thriftserialization folder
#To run the script you need to install thrift and then ./generateWebLogRecord.sh will generate the respective java class
thrift --gen java weblogrecord.thrift