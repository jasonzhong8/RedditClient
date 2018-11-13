package com.jasonzhong.redditclient.model

import java.util.HashMap
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("url", "width", "height")
class Resolution {

    @JsonProperty("url")
    @get:JsonProperty("url")
    @set:JsonProperty("url")
    var url: String? = null
    @JsonProperty("width")
    @get:JsonProperty("width")
    @set:JsonProperty("width")
    var width: Int? = null
    @JsonProperty("height")
    @get:JsonProperty("height")
    @set:JsonProperty("height")
    var height: Int? = null
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
