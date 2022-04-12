package com.example.starswarsapp.model

data class PeopleList (val results: List<People>)

data class People(val name: String,
                  val height: String,
                  val mass: String,
                  val hair_color: String,
                  val skin_color: String,
                  val eye_color: String,
                  val birth_year: String,
                  val gender: String)
