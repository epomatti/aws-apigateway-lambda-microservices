package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;

/**
 * Handler for requests to Lambda function.
 */
public class App implements RequestHandler<SQSEvent, Void> {

  @Override
  public Void handleRequest(SQSEvent event, Context context) {
    for (SQSMessage msg : event.getRecords()) {
      System.out.println(new String(msg.getBody()));
    }
    return null;
  }
}
