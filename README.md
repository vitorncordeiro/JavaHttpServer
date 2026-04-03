# Jitor - Java WebServer

## Overview

This project is a lightweight HTTP server built from scratch in Java. It was designed as a learning and portfolio project to understands how modern web frameworks and servlet containers operate internally.

The server provides routing, JSON handling, static file serving, and handler for all HTTP methods , strongly inspired by tools like Apache Tomcat.

---

## Features

* HTTP/1.1 request parsing (methods, headers, body)
* Routing system with support for path parameters
* Middleware pipeline (request/response interception)
* JSON request and response handling
* Static file serving (HTML, CSS, images)
* Thread pool for concurrent request handling
* Basic error handling and logging

---

## Architecture

The project is structured into modular components:

* **HTTP Layer**

  * `HttpRequest` – represents incoming requests
  * `HttpResponse` – builder for responses

* **Server Core**

  * `HttpServer` – manages sockets and request lifecycle
  * Thread pool for concurrency

* **Routing**

  * Maps paths and HTTP methods to handlers

* **Middleware**

  * Chainable request/response processing
  * Enables logging, authentication, etc.

* **Static File Server**

  * Serves files from a public directory
  * MIME type detection

---

## Performance

This project uses a fixed thread pool to handle concurrent requests. While not intended to replace production-grade servers, it demonstrates core performance concepts such as:

* Request concurrency
* Thread management
* Basic scalability

---

## Purpose

This project was built to deepen understanding of:

* Networking and sockets in Java
* HTTP protocol internals
* Concurrency and threading
* Web framework design(such SpringBoot)

---
