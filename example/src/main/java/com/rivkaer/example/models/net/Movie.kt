package com.rivkaer.example.models.net

/**
 * @author: Junjian Jia
 * @Date: 2019/7/12 22:36
 * @Email: cnrivkaer@outlook.com
 * @Description: 电影
 */
data class Movie(
    var id: Int,
    var name: String,
    var picture: String,
    var describe: String,
    var likeUrl: String
)