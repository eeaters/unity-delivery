package io.eeaters.delivery.core.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface HttpClient {

    String post(String url, Object payload);

    String post(String url, Map<String, String> headers, Object payload);


    @Slf4j
    class Default implements HttpClient{

        private final ObjectMapper objectMapper = new ObjectMapper();

        private final OkHttpClient okHttpClient;

        private static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");


        public Default() {
            this.okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();
        }

        @Override
        public String post(String url, Object payload) {
            return post(url, new HashMap<>(), payload);
        }

        @Override
        public String post(String url, Map<String, String> headers, Object payload) {
            if (!headers.containsKey("Content-Type")) {
                headers.put("Content-Type", "application/json");
            }

            try {
                String requestBody ;
                if (payload instanceof String) {
                    requestBody = (String) payload;
                }else{
                    requestBody = objectMapper.writeValueAsString(payload);
                }

                RequestBody body = RequestBody.create(requestBody, JSON_TYPE);

                Request request = new Request.Builder()
                        .url(url)
                        .headers(Headers.of(headers))
                        .post(body)
                        .build();

                Response response = okHttpClient.newCall(request).execute();
                assert response.body() != null;
                String result = response.body().string();
                if (log.isDebugEnabled()) {
                    log.info("HttpClient#post, url:{}, params: {}, response: {}",
                            url,
                            StringEscapeUtils.unescapeJava(requestBody),
                            StringEscapeUtils.unescapeJava(result));
                }
                return result;
            } catch (IOException e) {
                log.error("HttpClient#post error, url: {} , params: {}, error: {}",
                        url, payload, ExceptionUtils.getMessage(e));

                throw new RuntimeException(e);
            }
        }
    }

}
