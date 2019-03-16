package com.upgrad.SaavnProject;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class SongIDDateWritable implements WritableComparable {
  
	private Text date;
	private Text songId;
	public SongIDDateWritable() {
		date = new Text("");
		songId = new Text("");
	}
	public SongIDDateWritable(Text date, Text songId) {
		this.date = date;
		this.songId = songId;
  }
  
	public Text getDate() { return date; }
	public void setDate(Text date) { this.date = date; }
	public Text getSongId() { return songId; }
  public void setSongId(Text songId) { this.songId = songId; }
  
	public void readFields(DataInput arg0) throws IOException {
    
		// TODO Auto-generated method stub
		date.readFields(arg0);
		songId.readFields(arg0);
  }
  
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		date.write(arg0);
		songId.write(arg0);
  }
  
	@Override
	public String toString() {
		return this.getDate().toString() + "," + this.getSongId().toString();
  }
  
	public int compareTo(Object o) {
		SongIDDateWritable other = (SongIDDateWritable)o;
		return this.toString().compareTo(other.toString());
	}
}
