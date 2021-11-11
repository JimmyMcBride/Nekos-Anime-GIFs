package com.example.nekosanimegifs.models

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true) data class AnimeCategories (
    val baka: CategoryInfo,
    val bite: CategoryInfo,
    val blush: CategoryInfo,
    val bored: CategoryInfo,
    val cry: CategoryInfo,
    val cuddle: CategoryInfo,
    val dance: CategoryInfo,
    val facepalm: CategoryInfo,
    val feed: CategoryInfo,
    val happy: CategoryInfo,
    val highfive: CategoryInfo,
    val hug: CategoryInfo,
    val kiss: CategoryInfo,
    val laugh: CategoryInfo,
    val pat: CategoryInfo,
    val poke: CategoryInfo,
    val pout: CategoryInfo,
    val shrug: CategoryInfo,
    val slap: CategoryInfo,
    val sleep: CategoryInfo,
    val smile: CategoryInfo,
    val smug: CategoryInfo,
    val stare: CategoryInfo,
    val think: CategoryInfo,
    val thumbsup: CategoryInfo,
    val tickle: CategoryInfo,
    val wave: CategoryInfo,
    val wink: CategoryInfo,
    ) : Serializable
{
    @JsonClass(generateAdapter = true) data class CategoryInfo(
        val min: String?,
        val max: String?,
        val format: String?,
    ) : Serializable

    fun getCategoriesMap(): MutableMap<String, CategoryInfo> {
        val self = this
        return mutableMapOf<String, CategoryInfo>().apply {
            this["baka"] = self.baka
            this["bite"] = self.bite
            this["blush"] = self.blush
            this["bored"] = self.bored
            this["cry"] = self.cry
            this["cuddle"] = self.cuddle
            this["dance"] = self.dance
            this["facepalm"] = self.facepalm
            this["feed"] = self.feed
            this["happy"] = self.happy
            this["highfive"] = self.highfive
            this["hug"] = self.hug
            this["kiss"] = self.kiss
            this["laugh"] = self.laugh
            this["pat"] = self.pat
            this["poke"] = self.poke
            this["pout"] = self.pout
            this["shrug"] = self.shrug
            this["slap"] = self.slap
            this["sleep"] = self.sleep
            this["smile"] = self.smile
            this["smug"] = self.smug
            this["stare"] = self.stare
            this["think"] = self.think
            this["thumbsup"] = self.thumbsup
            this["tickle"] = self.tickle
            this["wave"] = self.wave
            this["wink"] = self.wink
        }
    }
}
