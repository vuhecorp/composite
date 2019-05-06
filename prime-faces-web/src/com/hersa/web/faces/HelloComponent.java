package com.hersa.web.faces;

import java.io.IOException;
import java.util.Date;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(createTag = true, tagName = "helloComponent", namespace = "http://example.com/tags")
public class HelloComponent extends UIInput implements NamingContainer {
  @Override
  public String getFamily() {
      return "Greeting";
  }

  @Override
  public void encodeBegin(FacesContext context) throws IOException {
      String message = (String) getAttributes().get("message");
      Date time = (Date) getAttributes().get("time");
      ResponseWriter writer = context.getResponseWriter();
      writer.startElement("p:inputText", this);
      writer.write("Message: " + message);
      writer.endElement("p:inputText");

      writer.startElement("p", this);
      writer.write("date: " + time);
      writer.endElement("p");
  }
}
