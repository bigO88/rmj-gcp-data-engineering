#! /bin/bash


usage(){

echo "sh $0 <input-file-path> <output-file-path> <runner>"
exit 1;

}


if [ $# -eq 3 ]
then

main_class=com.rmj.gcp.dataservices.DataflowRunner
inputFile=$1
outfile=$2
runner=$3

mvn compile exec:java -Dexec.mainClass=$main_class -Dexec.args="--runner=DirectRunner --inputFilePath=$inputFile --outPutFilePath=$outfile" -Pdirect-runner
rc=$?

if [ $rc -eq 0 ]
then
 echo "Dataflow ran successfull"
else
 echo "Dataflow failed with $rc.Please check stack-driver logs."
fi
else
 usage
fi
