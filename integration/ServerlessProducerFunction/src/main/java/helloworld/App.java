package helloworld;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SqsException;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  public APIGatewayProxyResponseEvent handleRequest(final APIGatewayProxyRequestEvent input, final Context context) {
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "application/json");
    headers.put("X-Custom-Header", "application/json");

    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
        .withHeaders(headers);
    try {
      String queueName = "documents-queue";
      String message = "Hello";
      SqsClient sqsClient = SqsClient.builder()
          .region(Region.US_EAST_2)
          .build();
      sendMessage(sqsClient, queueName, message);
      sqsClient.close();

      return response
          .withStatusCode(200)
          .withBody("OK");
    } catch (Exception e) {
      return response
          .withBody("{}")
          .withStatusCode(500);
    }
  }

  public static void sendMessage(SqsClient sqsClient, String queueName, String message) {
    try {
      CreateQueueRequest request = CreateQueueRequest.builder()
          .queueName(queueName)
          .build();
      sqsClient.createQueue(request);

      GetQueueUrlRequest getQueueRequest = GetQueueUrlRequest.builder()
          .queueName(queueName)
          .build();

      String queueUrl = sqsClient.getQueueUrl(getQueueRequest).queueUrl();
      SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
          .queueUrl(queueUrl)
          .messageBody(message)
          .delaySeconds(5)
          .build();

      sqsClient.sendMessage(sendMsgRequest);

    } catch (SqsException e) {
      System.err.println(e.awsErrorDetails().errorMessage());
      System.exit(1);
    }
  }
}
