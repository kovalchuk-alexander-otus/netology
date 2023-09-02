package ru.maki;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String URL_CATS_PROPS = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
    private static String message;
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setUserAgent("myClient")
                .setDefaultRequestConfig(
                        RequestConfig.custom()
                                .setConnectTimeout(5_000)
                                .setSocketTimeout(30_000)
                                .setRedirectsEnabled(false)
                                .build()
                ).build();

        HttpGet httpRequest = new HttpGet(URL_CATS_PROPS);
        httpRequest.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = httpClient.execute(httpRequest);

//        message = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
//        System.out.printf("FULL message: %n %s%n%n", message);

        List<CatProps> catPropsList = mapper.readValue(response.getEntity().getContent(), new TypeReference<List<CatProps>>() {});
        catPropsList.stream().filter(value -> value.getUpvotes() > 0).forEach(System.out::println);

    }
}