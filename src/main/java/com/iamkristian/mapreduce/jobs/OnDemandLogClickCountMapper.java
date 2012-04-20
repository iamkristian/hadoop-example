package com.iamkristian.mapreduce.jobs;

import com.iamkristian.mapreduce.entities.OnDemandLogStatement;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/**
 * Maps ondemand logfiles
 *
 * @author iamkristian
 */
public class OnDemandLogClickCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


    private final static IntWritable one = new IntWritable(1);

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String entry = value.toString();
        if (!entry.startsWith("#")) {
            OnDemandLogStatement stmt = new OnDemandLogStatement(value.toString());
            if (stmt != null && stmt.cs_uri_stem != null && stmt.cs_url != null) {
                String url;
                String storage = stmt.cs_uri_stem;
                if (stmt.cs_url.lastIndexOf('?') != -1)
                    url = stmt.cs_url.substring(0, stmt.cs_url.lastIndexOf('?'));
                else
                    url = stmt.cs_url;
                context.write(new Text(storage + " " + url), one);
            }
        }
    }
}
