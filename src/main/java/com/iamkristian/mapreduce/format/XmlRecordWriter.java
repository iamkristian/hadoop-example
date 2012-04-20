package com.iamkristian.mapreduce.format;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * ...
 *
 * @author iamkristian
 */
public class XmlRecordWriter<K, V> extends RecordWriter<K, V> {

    private static final String utf8 = "UTF-8";
    private static final String header = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<Report>\n" +
            "\t<Data>\n";
    public static final String footer = "\t</Data>\n" +
            "</Report>";
    public static final String streamSet = "\t\t<Stream>\n"+
            "\t\t\t<FileName>#fileName#</FileName>\n" +
            "\t\t\t<FilePath>#filePath#</FilePath>\n" +
            "\t\t\t<Clicks>#clicks#</Clicks>\n" +
            "\t\t</Stream>\n";

    private DataOutputStream out;

    public XmlRecordWriter(DataOutputStream out) throws IOException {
        this.out = out;
        out.writeBytes(header);
    }

    @Override
    public void write(K key, V value) throws IOException, InterruptedException {
        boolean nullKey = key == null || key instanceof NullWritable;
        boolean nullValue = value == null || value instanceof NullWritable;

        if (nullKey && nullValue) {
            return;
        }
        writeSet(key, value);
    }

    public void writeSet(K key, V value) throws IOException {
        String[] keyData = key.toString().split(" ");
        String fileName = keyData[0];
        String filePath = keyData[1];
        String valueData = value.toString();
        String buf = streamSet;
        buf = buf.replace("#fileName#", fileName);
        buf = buf.replace("#filePath#", filePath);
        buf = buf.replace("#clicks#", valueData);
        out.writeBytes(buf);
    }

    @Override
    public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
        try {
            out.writeBytes(footer);
        } finally {
            out.close();
        }
    }
}
