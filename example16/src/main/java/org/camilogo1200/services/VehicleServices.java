package org.camilogo1200.services;

import org.camilogo1200.qualifiers.RemoteLogService;

public class VehicleServices {

  private LogService logService;

  public VehicleServices(@RemoteLogService LogService logService) {
    this.logService = logService;
  }

}
