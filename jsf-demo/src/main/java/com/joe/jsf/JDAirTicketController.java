package com.joe.jsf;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.joe.jsf.response.JDAirFlightResponse;
import com.joe.jsf.response.JDAirTicketResponse;
import com.joe.jsf.response.ResponseWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "JDAirTicketController")
@ELBeanName(value = "JDAirTicketController")
@Join(path = "/air-ticket", to = "/air-ticket.jsf")
@Slf4j
public class JDAirTicketController {
  private static final String baseUrl = "https://jipiao.jd.com/search/queryFlight.action";
  private JDAirTicketRequest jdAirTicketRequest = new JDAirTicketRequest();
  private List<JDAirFlightResponse> jdAirFlightResponses = new ArrayList<JDAirFlightResponse>();

  private static Map<String, String> requestParams;

  static {
    requestParams = new HashMap<String, String>();
    requestParams.put("queryModule", "1");
    requestParams.put("lineType", "OW");
    requestParams.put("queryType", "listquery");
  }

  public JDAirTicketRequest getJdAirTicketRequest() {
    return jdAirTicketRequest;
  }

  public List<JDAirFlightResponse> getJdAirFlightResponses() {
    return jdAirFlightResponses;
  }

  public void setJdAirFlightResponses(List<JDAirFlightResponse> responses) {
    if (responses == null) {
      return;
    }

    responses.forEach(response -> response.generateDerivedData());
    this.jdAirFlightResponses = responses;
  }

  public void query() {
    requestParams.put("depCity", jdAirTicketRequest.getDepCity());
    requestParams.put("depDate", jdAirTicketRequest.getDepDate());
    requestParams.put("arrCity", jdAirTicketRequest.getArrCity());
    requestParams.put("arrDate", jdAirTicketRequest.getDepDate());
    String url = buildRequestUrl(requestParams);
    String resp = HttpRequest.get(url).body();
    Gson gson = new Gson();
    ResponseWrapper<JDAirTicketResponse> responseWrapper =
        gson.fromJson(resp, new TypeToken<ResponseWrapper<JDAirTicketResponse>>() {}.getType());
    this.setJdAirFlightResponses(responseWrapper.getData().getFlights());
  }

  private String buildRequestUrl(Map<String, String> requestParams) {
    String params =
        requestParams
            .entrySet()
            .stream()
            .map(entry -> entry.getKey() + "=" + entry.getValue())
            .collect(Collectors.joining("&"));
    return baseUrl + "?" + params;
  }
}
