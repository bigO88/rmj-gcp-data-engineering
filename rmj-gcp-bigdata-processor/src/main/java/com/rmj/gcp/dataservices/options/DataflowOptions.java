package com.rmj.gcp.dataservices.options;

import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface DataflowOptions extends   PipelineOptions {


    @Description("Input file path")
     String getInputFilePath();
    void setInputFilePath(String inputFilePath);

    @Description("Output file path")
    String getOutPutFilePath();
    void setOutPutFilePath(String outPutFilePath);

}
