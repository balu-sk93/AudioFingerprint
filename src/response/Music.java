
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
    "external_ids",
    "play_offset_ms",
    "release_date",
    "label",
    "external_metadata",
    "title",
    "duration_ms",
    "album",
    "acrid",
    "result_from",
    "artists"
})
public class Music {

    @JsonProperty("external_ids")
    private ExternalIds externalIds;
    @JsonProperty("play_offset_ms")
    private Integer playOffsetMs;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("label")
    private String label;
    @JsonProperty("external_metadata")
    private ExternalMetadata externalMetadata;
    @JsonProperty("title")
    private String title;
    @JsonProperty("duration_ms")
    private String durationMs;
    @JsonProperty("album")
    private Album album;
    @JsonProperty("acrid")
    private String acrid;
    @JsonProperty("result_from")
    private Integer resultFrom;
    @JsonProperty("artists")
    private List<Artist> artists = new ArrayList<Artist>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The externalIds
     */
    @JsonProperty("external_ids")
    public ExternalIds getExternalIds() {
        return externalIds;
    }

    /**
     * 
     * @param externalIds
     *     The external_ids
     */
    @JsonProperty("external_ids")
    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    /**
     * 
     * @return
     *     The playOffsetMs
     */
    @JsonProperty("play_offset_ms")
    public Integer getPlayOffsetMs() {
        return playOffsetMs;
    }

    /**
     * 
     * @param playOffsetMs
     *     The play_offset_ms
     */
    @JsonProperty("play_offset_ms")
    public void setPlayOffsetMs(Integer playOffsetMs) {
        this.playOffsetMs = playOffsetMs;
    }

    /**
     * 
     * @return
     *     The releaseDate
     */
    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * 
     * @param releaseDate
     *     The release_date
     */
    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 
     * @return
     *     The label
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * 
     * @param label
     *     The label
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 
     * @return
     *     The externalMetadata
     */
    @JsonProperty("external_metadata")
    public ExternalMetadata getExternalMetadata() {
        return externalMetadata;
    }

    /**
     * 
     * @param externalMetadata
     *     The external_metadata
     */
    @JsonProperty("external_metadata")
    public void setExternalMetadata(ExternalMetadata externalMetadata) {
        this.externalMetadata = externalMetadata;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The durationMs
     */
    @JsonProperty("duration_ms")
    public String getDurationMs() {
        return durationMs;
    }

    /**
     * 
     * @param durationMs
     *     The duration_ms
     */
    @JsonProperty("duration_ms")
    public void setDurationMs(String durationMs) {
        this.durationMs = durationMs;
    }

    /**
     * 
     * @return
     *     The album
     */
    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    /**
     * 
     * @param album
     *     The album
     */
    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    /**
     * 
     * @return
     *     The acrid
     */
    @JsonProperty("acrid")
    public String getAcrid() {
        return acrid;
    }

    /**
     * 
     * @param acrid
     *     The acrid
     */
    @JsonProperty("acrid")
    public void setAcrid(String acrid) {
        this.acrid = acrid;
    }

    /**
     * 
     * @return
     *     The resultFrom
     */
    @JsonProperty("result_from")
    public Integer getResultFrom() {
        return resultFrom;
    }

    /**
     * 
     * @param resultFrom
     *     The result_from
     */
    @JsonProperty("result_from")
    public void setResultFrom(Integer resultFrom) {
        this.resultFrom = resultFrom;
    }

    /**
     * 
     * @return
     *     The artists
     */
    @JsonProperty("artists")
    public List<Artist> getArtists() {
        return artists;
    }

    /**
     * 
     * @param artists
     *     The artists
     */
    @JsonProperty("artists")
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
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
