# aws-apigateway-lambda-microservices

```sh
sam init --name integration --package-type Zip --architecture arm64 --runtime java21
sam build

sam validate
sam local invoke

sam sync --stack-name {{stack-name}} --watch
sam deploy --guided
```

```sh
sam local generate-event sqs receive-message --body '{"hello": "world"}'
```

```sh
sam local invoke ServerlessConsumerFunction --event events/sqs.json
```


Add custom SAM tags to your IDE.


https://medium.com/carsales-dev/api-gateway-with-aws-sam-template-c05afdd9cafe
https://github.com/awsdocs/aws-doc-sdk-examples/tree/main/javav2/example_code/sqs
https://docs.aws.amazon.com/lambda/latest/dg/with-sqs-example.html
https://stackoverflow.com/questions/70776865/run-sqs-on-aws-sam-locally-is-it-possible
https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/sam-resource-httpapi.html
