package ru.maki;

import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Main {

    private static final String NASA_KEY = "AfkGHYpMNYvsT1HfQNstIgHZoZt0sOWNWUp7aHUD";
    private static final String NASA_URL = "https://api.nasa.gov/planetary/apod?api_key=";
    private static String message;
    private static String url;

    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClientBuilder.create()
                .setUserAgent("makiClient")
                .setDefaultRequestConfig(
                        RequestConfig.custom()
                                .setConnectTimeout(5_000)
                                .setSocketTimeout(30_000)
                                .setRedirectsEnabled(false)
                                .build()
                )
                .build();

        HttpGet request = new HttpGet(NASA_URL + NASA_KEY);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        CloseableHttpResponse response = client.execute(request);
        message = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);

        System.out.println(message);

        Gson gson = new Gson();

        Map<String, String> map = gson.fromJson(message, Map.class);
        url = map.get("url");
        System.out.println(url);

        File file = new File(url);
        System.out.println(file.getName());

        HttpGet nasaArtefact = new HttpGet(url);
        nasaArtefact.setHeader(HttpHeaders.ACCEPT, ContentType.IMAGE_JPEG.getMimeType());

        CloseableHttpResponse nasaArtefactResponse = client.execute(nasaArtefact);
        try (FileOutputStream f = new FileOutputStream(file.getName())) {
            nasaArtefactResponse.getEntity().writeTo(f);
        }

    }
}