package com.example.demo_springboot

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/api/v1/articles")
class ArticleController( val repository: ArticleRepository) {

    //val articles = mutableListOf(Article("My Title", "Some content here"))


    @GetMapping
    fun articles() = repository.findAllByOrderByCreatedAtDesc()  //This is the same as the below commented out function, but made simpler with Kotlin syntax

    /*@GetMapping
    fun articles(): MutableList<Article> {
        return articles
    }*/


    @GetMapping("/{title}")
    fun articles(@PathVariable title: String) =
        repository.findBySlug(title).orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND)}


    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
       article.id = null
        repository.save(article)
        return article
    }


    @PutMapping("/{title}")
    fun updateArticle(@RequestBody article: Article, @PathVariable title: String): Article {
        val existingArticle = repository.findBySlug(title).orElseThrow{throw ResponseStatusException (HttpStatus.NOT_FOUND)}
        existingArticle.content = article.content
        repository.save(article)
        return article
    }


    @DeleteMapping("/{title}")
    fun deleteArticle(@PathVariable title: String){
        val existingArticle = repository.findBySlug(title).orElseThrow{throw ResponseStatusException (HttpStatus.NOT_FOUND)}

        repository.delete(existingArticle)
    }





}