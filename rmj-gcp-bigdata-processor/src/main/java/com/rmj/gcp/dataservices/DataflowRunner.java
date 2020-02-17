package com.rmj.gcp.dataservices;


import com.rmj.gcp.dataservices.options.DataflowOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;


public class DataflowRunner {

    public static void main(String args[]) {

        PipelineOptionsFactory.register(DataflowOptions.class);

        DataflowOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(DataflowOptions.class);

        createPipeline(options);

    }

    private static void createPipeline(DataflowOptions options) {

        String inPath = options.getInputFilePath();
        String outPath = options.getOutPutFilePath();

        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> input = pipeline.apply(TextIO.read().from(inPath));

       input.apply(TextIO.write().to(outPath));

       pipeline.run().waitUntilFinish();


    }


}
