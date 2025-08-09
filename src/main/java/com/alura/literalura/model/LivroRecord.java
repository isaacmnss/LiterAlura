package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroRecord(
        @JsonAlias("title")
        String titulo,
        @JsonAlias("languages")
        String idoma,
        @JsonAlias("download_count")
        Integer numeroDownloads) {
}
