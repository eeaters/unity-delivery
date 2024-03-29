package io.eeaters.delivery.dada;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.util.JsonUtils;
import io.eeaters.delivery.dada.request.DaDaStatusCallBackReq;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

public abstract class DaDaSignGenerate {


    public static Map<String,Object> generateParams(Account account, String body) {
        Map<String, Object> data = new HashMap<>();
        data.put("source_id", account.getSourceId());
        data.put("app_key", account.getAppKey());
        data.put("timestamp", 1708999151);
        data.put("format", "json");
        data.put("v", "1.0");
        data.put("body", body);
        data.put("signature", signature(data, account.getAppSecret()));
        return data;
    }

    public static boolean verify(DaDaStatusCallBackReq callBackReq) {
        Object sign = callBackReq.getSignature();

        List<String> signField = new ArrayList<>();
        signField.add(callBackReq.getClientId());
        signField.add(callBackReq.getOrderId());
        signField.add(String.valueOf(callBackReq.getUpdateTime()));

        String signStr = signField.stream()
                .sorted()
                .collect(Collectors.joining());

        return Objects.equals(DigestUtils.md5Hex(signStr), sign);
    }

    private static String signature(Map<String, Object> data, String appSecret) {
        // 请求参数按照【属性名】字典升序排序后，按照属性名+属性值拼接
        String signStr = data.keySet().stream()
                .sorted()
                .map(it -> String.format("%s%s", it, data.get(it)))
                .collect(Collectors.joining(""));

        // 拼接后的结果首尾加上appSecret
        String finalSignStr = appSecret + signStr + appSecret;
        // MD5加密并转为大写
        return DigestUtils.md5Hex(finalSignStr).toUpperCase();
    }


}
