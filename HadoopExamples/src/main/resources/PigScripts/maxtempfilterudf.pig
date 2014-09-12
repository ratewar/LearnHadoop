/*Change the Jar Path as per your system or set PIG_CLASSPATH*/
REGISTER /home/rajat/githubrepos/LearnHadoop/HadoopExamples/target/HadoopExamples-1.0-SNAPSHOT-jar-with-dependencies.jar
DEFINE isGood pigudf.CheckQuality();
records = LOAD './SampleFiles/sample.txt' AS (year:chararray,temperature:int,quality:int);
filtered_records = FILTER records BY temperature !=9999 AND isGood(quality);
grouped_records = GROUP filtered_records BY year;
max_temp = FOREACH grouped_records GENERATE group,MAX(filtered_records.temperature);
DUMP max_temp;
