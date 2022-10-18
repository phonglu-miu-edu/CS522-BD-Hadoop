package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    public void reduce(Text word, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        Integer sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        context.write(word, new IntWritable(sum));
    }
}
