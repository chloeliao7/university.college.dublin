// total numbers of entries
package mapreduce;
import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

// mapper
public class CountingConnections {
	// QUESTION 1 :
	// in the Counting Connection MAP we need a LongWritable, Text as inputs
	//      ----> because we we need a (LongWritable)number to count the connection and a (TEXT)string to declare the the Connection
	// in the Counting Connection MAP we need a IntWritable, IntWritable as outputs
	//      ----> because we because we want to send both of the values of the map to the mapreduce (form the map)

	public static class Map extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
		public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// Key = file offsets (char offset) , Value = one of records, context = map reduce job context >> GIVE OUTPUT
			// Longwritable = Long, Text = String, Context = all details about job (object: Meta info), IntWritable = INT

			context.write(new IntWritable(1), new IntWritable(1)); // context.write = output of the map
		}
	}

	// QUESTION 2 :
	// in the Counting Connection REDUCE we need a IntWritable, IntWritable as input
	//      ----> because we we need a pair where one is the key and one is the iteration = Iterable<IntWritable>
	// in the Counting Connection REDUCE we need a IntWritable, IntWritable as outputs
	//      ----> because we need to output the sum after iterating through the values

	// reduce
	public static class Reduce extends Reducer<IntWritable, IntWritable, IntWritable, NullWritable> {
		public void reduce(IntWritable key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable x : values) { sum += x.get(); }
			context.write(new IntWritable(sum), NullWritable.get()); // we simply need the intWrittable as output
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "FileLineCounter");
		job.setJarByClass(CountingConnections.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(NullWritable.class);

		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		Path outputPath = new Path(args[1]);

		// Configuring the input/output path from the filesystem into the job
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, outputPath);

		// deleting the output path automatically from hdfs so that we don't have to delete it explicitly
		outputPath.getFileSystem(conf).delete(outputPath);

		// exiting the job only if the flag value becomes false
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}

// Notes: dont use map red import org.apache.hadoop.mapred.Mapper;