package com.phuocvh.common.exceptions;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiSubError {
  private String message;

  private Map<String, Object> properties;

  @JsonAnyGetter
  public Map<String, Object> getProperties() {
    return properties;
  }

  static class ApiSubErrorBuilder {
    private String message;
    private Map<String, Object> properties;

    public ApiSubErrorBuilder message(String message) {
      this.message = message;
      return this;
    }

    public ApiSubErrorBuilder put(String key, Object value) {
      if (properties.containsKey(key)) {
        properties.put(key, value);
      } else {
        properties.putIfAbsent(key, value);
      }
      return this;
    }

    public ApiSubErrorBuilder properties(Map<String, Object> properties) {
      this.properties = properties;
      return this;
    }

    public ApiSubError build() {
      ApiSubError apiSubError = new ApiSubError();
      apiSubError.setMessage(message);
      apiSubError.setProperties(properties);
      return apiSubError;
    }
  }
}
