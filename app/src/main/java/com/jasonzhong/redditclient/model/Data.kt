package com.jasonzhong.redditclient.model

import java.util.HashMap
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("modhash", "dist", "children", "after", "before")
class Data {

    @JsonProperty("modhash")
    @get:JsonProperty("modhash")
    @set:JsonProperty("modhash")
    var modhash: String? = null
    @JsonProperty("dist")
    @get:JsonProperty("dist")
    @set:JsonProperty("dist")
    var dist: Int? = null
    @JsonProperty("children")
    @get:JsonProperty("children")
    @set:JsonProperty("children")
    var children: List<Child>? = null
    @JsonProperty("after")
    @get:JsonProperty("after")
    @set:JsonProperty("after")
    var after: String? = null
    @JsonProperty("before")
    @get:JsonProperty("before")
    @set:JsonProperty("before")
    var before: String? = null
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