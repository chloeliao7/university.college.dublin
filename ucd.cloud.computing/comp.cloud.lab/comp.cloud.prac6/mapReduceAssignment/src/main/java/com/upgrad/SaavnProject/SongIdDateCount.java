package com.upgrad.SaavnProject;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Writable;

public class SongIdDateCount implements Writable {
	private SongIDDateWritable s;
	private IntWritable count;

	public SongIdDateCount(SongIDDateWritable s, IntWritable count) {
		super();
		this.s = s;
		this.count = count;
	}

	public SongIDDateWritable getS() { return s; }
	public void setS(SongIDDateWritable s) { this.s = s; }
	public IntWritable getCount() { return count; }
	public void setCount(IntWritable count) { this.count = count; }

	public void readFields(DataInput arg0) throws IOException {
		s.readFields(arg0);
		count.readFields(arg0);
	}
	public void write(DataOutput arg0) throws IOException {
		s.write(arg0);
		count.write(arg0);
	}

	@Override
	public String toString() {
		return s.getDate() + "," + s.getSongId() + "," + count.toString();
	}
}
