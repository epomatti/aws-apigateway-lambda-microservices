# aws-apigateway-lambda-microservices

```sh
sam init --name integration --package-type Zip --architecture arm64 --runtime java21
sam build

sam validate
sam local invoke

sam sync --stack-name {{stack-name}} --watch
sam deploy --guided
```


https://medium.com/carsales-dev/api-gateway-with-aws-sam-template-c05afdd9cafe
