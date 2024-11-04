package com.example.demo_springboot

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
 class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var title: String,
    var content: String,
    var createdAt: LocalDate = LocalDate.now(),

    val slug: String = title.toSlug()


)