package com.jasonzhong.redditclient.model

import java.util.HashMap
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("gid_1", "gid_2", "gid_3")
class Gildings {

    @JsonProperty("gid_1")
    @get:JsonProperty("gid_1")
    @set:JsonProperty("gid_1")
    var gid1: Int? = null
    @JsonProperty("gid_2")
    @get:JsonProperty("gid_2")
    @set:JsonProperty("gid_2")
    var gid2: Int? = null
    @JsonProperty("gid_3")
    @get:JsonProperty("gid_3")
    @set:JsonProperty("gid_3")
    var gid3: Int? = null
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
