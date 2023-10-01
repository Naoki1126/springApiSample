package com.example.restservice;

import java.time.LocalDateTime;

public record Greeting(long id, String content, LocalDateTime time) {

}
