package wordcount;

/**
 * Created by rajat on 22/8/14. This is the Mapper Class
 */


import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper <LongWritable, Text, Text, IntWritable>
{
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
    {
        String [] tokens = value.toString().split(",");
        for (String tok : tokens)
        {
            context.write(new Text(tok), new IntWritable(1));
        }
    }
}
