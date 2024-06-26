package tech.book.application.exceptions.handler;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class CircuitBreakerFallback implements FallbackHandler<String> {

  @Override
  public String handle(ExecutionContext context) {
    String message = context.getMethod().getDeclaringClass().getName() + " Circuit Break is closed";
    if (context.getFailure().getLocalizedMessage() != null) {
      message = context.getFailure().getLocalizedMessage();
    }

    return message;
  }
}
