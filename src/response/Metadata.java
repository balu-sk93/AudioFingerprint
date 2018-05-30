
package response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "music",
    "timestamp_utc"
})
public class Metadata {

    @JsonProperty("music")
    private List<Music> music = new ArrayList<Music>();
    @JsonProperty("timestamp_utc")
    private String timestampUtc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The music
     */
    @JsonProperty("music")
    public List<Music> getMusic() {
        return music;
    }

    /**
     * 
     * @param music
     *     The music
     */
    @JsonProperty("music")
    public void setMusic(List<Music> music) {
        this.music = music;
    }

    /**
     * 
     * @return
     *     The timestampUtc
     */
    @JsonProperty("timestamp_utc")
    public String getTimestampUtc() {
        return timestampUtc;
    }

    /**
     * 
     * @param timestampUtc
     *     The timestamp_utc
     */
    @JsonProperty("timestamp_utc")
    public void setTimestampUtc(String timestampUtc) {
        this.timestampUtc = timestampUtc;
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
