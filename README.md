# aws-apigateway-lambda-microservices

```sh
sam init --name sam-app --package-type Zip --architecture arm64 --runtime java21
sam build

sam validate
sam local invoke

sam sync --stack-name {{stack-name}} --watch
sam deploy --guided
```

