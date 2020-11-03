package pl.kopka.kursspringboot2.Client.Model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lon",
        "temp",
        "wind_speed",
        "baro_pressure",
        "humidity",
        "wind_direction",
        "observation_time"
})
@ToString
public class WeatherApi {

    @JsonProperty("lat")
    private Integer lat;
    @JsonProperty("lon")
    private Integer lon;
    @JsonProperty("temp")
    private Temp temp;
    @JsonProperty("wind_speed")
    private WindSpeed windSpeed;
    @JsonProperty("baro_pressure")
    private BaroPressure baroPressure;
    @JsonProperty("humidity")
    private Humidity humidity;
    @JsonProperty("wind_direction")
    private WindDirection windDirection;
    @JsonProperty("observation_time")
    private ObservationTime observationTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lat")
    public Integer getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Integer lat) {
        this.lat = lat;
    }

    @JsonProperty("lon")
    public Integer getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Integer lon) {
        this.lon = lon;
    }

    @JsonProperty("temp")
    public Temp getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @JsonProperty("wind_speed")
    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_speed")
    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("baro_pressure")
    public BaroPressure getBaroPressure() {
        return baroPressure;
    }

    @JsonProperty("baro_pressure")
    public void setBaroPressure(BaroPressure baroPressure) {
        this.baroPressure = baroPressure;
    }

    @JsonProperty("humidity")
    public Humidity getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("wind_direction")
    public WindDirection getWindDirection() {
        return windDirection;
    }

    @JsonProperty("wind_direction")
    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    @JsonProperty("observation_time")
    public ObservationTime getObservationTime() {
        return observationTime;
    }

    @JsonProperty("observation_time")
    public void setObservationTime(ObservationTime observationTime) {
        this.observationTime = observationTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
