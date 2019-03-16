// finding the distinct of each ip addresses

package mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;

// QUESTION 1 :
// in the IPnum MAP we need a LongWritable, Text as INPUT
//      ----> Key Value Pair
// in the IPnum MAP we need a new Text(tokenizer.nextToken()), new IntWritable(1) as OUTPUT
//      ----> Text = IP and the INHERITABLE Is an instance of the Particular IP ADDRESS

public class IPnum {
  public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> { // first two are inputs, second are outputs
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
      // Key = file offsets (char offset) , Value = one of records, context = map reduce job context >> GIVE OUTPUT
      StringTokenizer tokenizer = new StringTokenizer(value.toString()); // used to break a string = uses space as default
      if (tokenizer.hasMoreTokens()) {
        context.write(
            new Text(tokenizer.nextToken()), // IP
            new IntWritable(1));  // Constant 1 => One instance of this particular IP address
      }
    }
  }

  // QUESTION 2 :
  // in the IPnum REDUCE we need a Text, IntWritable as INPUT
  //      ----> because we we need a key value pair with an iterable value and string as the key
  // in the IPnum REDUCE we need a Text, IntWritable as OUTPUT
  //      ----> because this time we need to have out key value pair as our output = IntWritable((sum))); the sum of the numbers

  // reduce
  public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> { // not null because we finally have our key value pair
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
      int sum = 0;
      for (IntWritable x : values) {
        sum += x.get();
      }
      context.write(key, new IntWritable((sum)));
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "IPnum");
    job.setJarByClass(IPnum.class);
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);

    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(IntWritable.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);

    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    Path outputPath = new Path(args[1]);

    //Configuring the input/output path from the filesystem into the job
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, outputPath);

    //deleting the output path automatically from hdfs so that we don't have to delete it explicitly
    outputPath.getFileSystem(conf).delete(outputPath);

    //exiting the job only if the flag value becomes false
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}
