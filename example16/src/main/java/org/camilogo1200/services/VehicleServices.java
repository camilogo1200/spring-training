package org.camilogo1200.services;

import org.camilogo1200.beans.Vehicle;
import org.camilogo1200.qualifiers.RemoteLogService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleServices implements AutoCloseable {

  private final ObjectProvider<LogService> logService;

  public VehicleServices(@RemoteLogService ObjectProvider<LogService> logService) {
    this.logService = logService;
  }

  @PostConstruct
  public void init() {
    logService.ifAvailable(lService -> System.out.println("Vehicle Services - Init"));
  }

  public Vehicle createNewVehicle() {
    logService.stream().forEach(lsp -> lsp.log("Vehicle Services - Create New Vehicle"));
    return new Vehicle();
  }

  @Override
  public void close() throws Exception {
    System.out.println("Vehicle Services closed - cleaning up resources");
  }
}
