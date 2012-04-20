package com.iamkristian.mapreduce.format;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * ...
 *
 * @author iamkristian
 */
public class XmlOutputFormat<K, V> extends FileOutputFormat {

    @Override
    public RecordWriter getRecordWriter(TaskAttemptContext job) throws IOException, InterruptedException {
        Configuration conf = job.getConfiguration();
        Path file = getDefaultWorkFile(job, ".xml");
        FileSystem fs = file.getFileSystem(conf);
        org.apache.hadoop.fs.FSDataOutputStream fileOut = fs.create(file, false);
        return new XmlRecordWriter(fileOut);
    }
}
