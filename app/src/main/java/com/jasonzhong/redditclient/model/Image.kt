package com.jasonzhong.redditclient.model

import java.util.HashMap
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("source", "resolutions", "variants", "id")
class Image {

    @JsonProperty("source")
    @get:JsonProperty("source")
    @set:JsonProperty("source")
    var source: Source? = null
    @JsonProperty("resolutions")
    @get:JsonProperty("resolutions")
    @set:JsonProperty("resolutions")
    var resolutions: List<Resolution>? = null
    @JsonProperty("variants")
    @get:JsonProperty("variants")
    @set:JsonProperty("variants")
    var variants: Variants? = null
    @JsonProperty("id")
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    var id: String? = null
    @JsonIgnore
    private val additionalProperties = HashMap<String, Any>()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties[name] = value
    }

}
