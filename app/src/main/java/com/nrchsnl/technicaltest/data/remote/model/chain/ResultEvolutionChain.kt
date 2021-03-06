package com.nrchsnl.technicaltest.data.remote.model.chain

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class ResultEvolutionChain (

    @SerializedName("baby_trigger_item")
    @Expose
    var babyTriggerItem: Any? = null,

    @SerializedName("chain")
    @Expose
    var chain: Chain? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null
    )