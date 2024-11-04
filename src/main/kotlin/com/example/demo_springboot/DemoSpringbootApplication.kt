package com.example.demo_springboot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoSpringbootApplication

fun main(args: Array<String>) {
	runApplication<DemoSpringbootApplication>(*args)
}
