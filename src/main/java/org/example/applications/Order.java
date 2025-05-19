package org.example.applications;

public record Order(Integer userId,
                    String productName,
                    Integer price) {
}
