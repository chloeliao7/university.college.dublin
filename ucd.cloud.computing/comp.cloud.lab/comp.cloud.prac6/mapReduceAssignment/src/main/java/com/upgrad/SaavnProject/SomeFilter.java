package com.upgrad.SaavnProject;

import com.upgrad.SaavnProject.SaavnFilter.DayPartitioner;
import com.upgrad.SaavnProject.SaavnFilter.MapperClass;
import com.upgrad.SaavnProject.SaavnFilter.ReducerClass;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class SomeFilter {
	public static class SaavnMapper extends Mapper<LongWritable, Text, Text, Text> {
		public void map(LongWritable key, Text record, Context con) throws InterruptedException {
			String[] info = record.toString().split(",");
			String songid = info[0];
			String date = info[4];

			System.out.println(record);

			try {
				con.write(new Text(date + songid), new Text("1"));

			} catch (IOException ioe) { System.out.println(ioe.getMessage()); }
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration(true);
		Job job;

		// conf = new Configuration();

		job = Job.getInstance(conf, "adhaar1_a");
		job.setJarByClass(SaavnFilter.class);

		job.setMapperClass(MapperClass.class);
		job.setReducerClass(ReducerClass.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DateAndCount.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));

		FileOutputFormat.setOutputPath(job, new Path(args[1] + System.currentTimeMillis()));

		job.setNumReduceTasks(31);

		/*
		 * Specify the partitioner class.
		 */
		job.setPartitionerClass(DayPartitioner.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
