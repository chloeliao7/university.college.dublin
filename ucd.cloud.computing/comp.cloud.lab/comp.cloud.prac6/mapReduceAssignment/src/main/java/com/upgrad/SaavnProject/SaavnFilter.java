package com.upgrad.SaavnProject;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class SaavnFilter {
	public static class MapperClass extends Mapper<LongWritable, Text, SongIDDateWritable, IntWritable> {
		public static List<String> days = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
																										"22", "23", "24", "25", "26", "27", "28", "29", "30", "31");

		public void map(LongWritable key, Text record, Context con) throws InterruptedException {
			String[] info = record.toString().split(",");
			String songid = info[0];
			String date = info[4];

			try {
				con.write(new SongIDDateWritable(new Text(date), new Text(songid)), new IntWritable(1));
			} catch (IOException ioe) { System.out.println(ioe.getMessage()); }
		}
	}

	public static class DayPartitioner extends Partitioner<SongIDDateWritable, IntWritable> {
		@Override
		public int getPartition(SongIDDateWritable arg0, IntWritable arg1, int arg2) {
			// TODO Auto-generated method stub
			String day = arg0.getDate().toString().split("-")[2];
			return Integer.parseInt(day) % arg2;
		}
	}

	public static class ReducerClass extends Reducer<SongIDDateWritable, IntWritable, SongIdDateCount, Text> {
		public void reduce(SongIDDateWritable key, Iterable<IntWritable> valueList, Context con) throws IOException, InterruptedException {
			int song_count = 0;
			for (IntWritable count : valueList) { song_count += count.get(); }

			con.write(new SongIdDateCount(key, new IntWritable(song_count)), new Text(""));
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration(true);
		Job job;

		// conf = new Configuration();

		job = Job.getInstance(conf, "adhaar1_a");
		job.setJarByClass(SaavnFilter.class);

		job.setMapperClass(MapperClass.class);
		job.setReducerClass(ReducerClass.class);

		job.setMapOutputKeyClass(SongIDDateWritable.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(SongIdDateCount.class);
		job.setOutputValueClass(Text.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));

		FileOutputFormat.setOutputPath(job, new Path(args[1] + System.currentTimeMillis()));

		job.setNumReduceTasks(3);

		/*
		 * Specify the partitioner class.
		 */
		job.setPartitionerClass(DayPartitioner.class);

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
