package thriftserialization;

import com.twitter.elephantbird.mapreduce.output.LzoThriftBlockOutputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


/**
 * Created by rajat on 30/8/14.
 */

public class ThriftJob extends Configured implements Tool {

    public int run(String[] args) throws Exception {

        Path inputPath = new Path(args[0]);
        Path outputPath = new Path(args[1]);

        Configuration conf = getConf();
        Job weblogJob = new Job(conf);
        weblogJob.setJobName("ThriftJob");
        weblogJob.setJarByClass(getClass());
        weblogJob.setNumReduceTasks(0);
        weblogJob.setMapperClass(ThriftMapper.class);
        weblogJob.setMapOutputKeyClass(LongWritable.class);
        weblogJob.setMapOutputValueClass(Text.class);
        weblogJob.setOutputKeyClass(LongWritable.class);
        weblogJob.setOutputValueClass(Text.class);
        weblogJob.setInputFormatClass(TextInputFormat.class);
        weblogJob.setOutputFormatClass(LzoThriftBlockOutputFormat.class);

        FileInputFormat.setInputPaths(weblogJob, inputPath);
        LzoThriftBlockOutputFormat.setClassConf(WeblogRecord.class, weblogJob.getConfiguration());
        LzoThriftBlockOutputFormat.setOutputPath(weblogJob, outputPath);

        if(weblogJob.waitForCompletion(true)) {
            return 0;
        }
        return 1;
    }

    public static void main( String[] args ) throws Exception {
        int returnCode = ToolRunner.run(new ThriftJob(), args);
        System.exit(returnCode);
    }
}