package ru.semyak.springLesson.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Страница доступна всем, даже без прохождения авторизации";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String pageForUser() {
        return "Эта страница доступна тем, кто имеет USER в базе данных";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admins() {
        return "Эта страница доступна авторизованным админам";
    }

    @GetMapping("/all")
    public String pageForAll() {
        return "Страница для всех, но после авторизации";
    }
}
