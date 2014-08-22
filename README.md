LearnHadoop
===========

Tutorial repository for Hadoop and Hadoop Ecosystem Projects

HadoopExamples directory will contain the complete code for the Hadoop Code Examples

To build the examples on your local machine, please ensure maven is installed and once you copy the folder at your local machine then run following commands

mvn compile followed by mvn package which will create HadoopExamples-1.0-SNAPSHOT.jar in target folder

How to run wordcount example

1) Please ensure that Hadoop is installed , if not follow these steps

   http://www.rajatratewal.com/2014/07/25/hadoop-tutorial-series-1-installing-hadoop-windows-ubuntu/ 

2) To run the program on shell

$ hadoop jar HadoopExamples-1.0-SNAPSHOT.jar wordcount.WordCountJob /user/rajat/inputwords/conf /user/rajat/out1
