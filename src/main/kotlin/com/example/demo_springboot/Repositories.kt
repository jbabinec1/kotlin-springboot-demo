package com.example.demo_springboot

import java.util.Optional
import org.springframework.data.jpa.repository.JpaRepository


interface ArticleRepository: JpaRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Article>
    fun findBySlug(slug: String): Optional<Article>

}