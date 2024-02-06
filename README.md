# aws-apigateway-lambda-microservices

```sh
sam init --name integration --package-type Zip --architecture arm64 --runtime java21
sam build

sam validate
sam local invoke

sam sync --stack-name {{stack-name}} --watch
sam deploy --guided
```

Add custom SAM tags to your IDE.


https://medium.com/carsales-dev/api-gateway-with-aws-sam-template-c05afdd9cafe
https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code/sqs