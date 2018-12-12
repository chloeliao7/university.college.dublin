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


public class Distinct {

  // QUESTION 1 :
  // in the Distinct MAP we need a LongWritable, Text as INPUT
  //      ----> because we we need so we can pass a key (offset of the file) and a value (one of records)
  // in the Distinct MAP we need a new Text(tokenizer.nextToken()), new IntWritable(1) as OUTPUT
  //      ----> because we because we need to map the token. which is done in the line that were on, and a IntWritable as the value

  public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> { // first two are inputs, second are outputs
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
      // Key = file offsets (char offset) , Value = one of records, context = map reduce job context >> GIVE OUTPUT
      StringTokenizer tokenizer = new StringTokenizer(value.toString()); // used to break a string = uses space as default
      if (tokenizer.hasMoreTokens()) {
        context.write(new Text(tokenizer.nextToken()), new IntWritable(1)); // context.write = output of the map
      }
    }
  }


  // QUESTION 2 :
  // in the Distinct REDUCE we need a Text, IntWritable as INPUT
  //      ----> because we we need two value pairs where one is the key and one is the iteration = Iterable<IntWritable> from the mapper
  // in the Distinct REDUCE we need a Text, NullWritable as OUTPUT
  //      ----> because we need to get out the key of the distincted IP so just Text(string)

  // reduce
  public static class Reduce extends Reducer<Text, IntWritable, Text, NullWritable> { // because its one column and no need to iterate
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
      context.write(key, NullWritable.get());
    }
  }




  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "Distinct IPs");
    job.setJarByClass(Distinct.class);
    job.setMapperClass(Map.class);
    job.setReducerClass(Reduce.class);

    job.setMapOutputKeyClass(Text.class);
     job.setMapOutputValueClass(IntWritable.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(NullWritable.class);

    job.setInputFormatClass(TextInputFormat.class);
    job.setOutputFormatClass(TextOutputFormat.class);
    Path outputPath = new Path(args[1]);
    Path tempPath = new Path("output/temp");

    //Configuring the input/output path from the filesystem into the job
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, tempPath);

    //deleting the output path automatically from hdfs so that we don't have to delete it explicitly
    outputPath.getFileSystem(conf).delete(outputPath);
    tempPath.getFileSystem(conf).delete(tempPath);


    boolean distinctStatus= job.waitForCompletion(true);
    if(distinctStatus){
      Job distinctLineCounter = Job.getInstance(conf, "Count distinct");

      // reff the Counting class Map and reduce.
      distinctLineCounter.setJarByClass(CountingConnections.class);
      distinctLineCounter.setMapperClass(CountingConnections.Map.class);
      distinctLineCounter.setReducerClass(CountingConnections.Reduce.class);

      // reff the Counting class ins and outs
      distinctLineCounter.setMapOutputKeyClass(IntWritable.class);
      distinctLineCounter.setMapOutputValueClass(IntWritable.class);

      distinctLineCounter.setOutputKeyClass(IntWritable.class);
      distinctLineCounter.setOutputValueClass(NullWritable.class);

      distinctLineCounter.setInputFormatClass(TextInputFormat.class);
      distinctLineCounter.setOutputFormatClass(TextOutputFormat.class);

      FileInputFormat.addInputPath(distinctLineCounter, tempPath);
      FileOutputFormat.setOutputPath(distinctLineCounter, outputPath);

      System.exit(distinctLineCounter.waitForCompletion(true) ? 0 : 1);
    }
  }
}
