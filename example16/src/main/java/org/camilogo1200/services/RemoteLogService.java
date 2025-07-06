package org.camilogo1200.services;

import java.text.MessageFormat;

import org.springframework.stereotype.Component;

@Component
public class RemoteLogService implements LogService {
  @Override
  public void log(String data) {
    String message = MessageFormat.format("Log data from RemoteLogService - data: [{0}]", data);
    System.out.println(message);
  }
}
