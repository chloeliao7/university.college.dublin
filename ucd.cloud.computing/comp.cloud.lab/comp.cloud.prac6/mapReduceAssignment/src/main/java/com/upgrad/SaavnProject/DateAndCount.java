package com.upgrad.SaavnProject;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;


public class DateAndCount implements Writable {
	String date;
	int count;

	public DateAndCount() {super();}

	public DateAndCount(String date, int count) {
	    this.date = date;
	    this.count = count;
	}

	public String getDate() {return date;}
	public void setDate(String number) {this.date = number;}
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}

	public void readFields(DataInput dataInput) throws IOException {
	    date = WritableUtils.readString(dataInput);
	    count = WritableUtils.readVInt(dataInput);      
	}

	
	public void write(DataOutput dataOutput) throws IOException {
	    WritableUtils.writeString(dataOutput, date);
	    WritableUtils.writeVInt(dataOutput, count);

	}

}
