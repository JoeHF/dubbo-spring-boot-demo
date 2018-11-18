package com.joe.jsf;

import lombok.Data;

@Data
public class JDAirTicketRequest {
  private String depCity;
  private String arrCity;
  private String depDate;
  private String arrDate;
}
