package io.eeaters.delivery.mockito;

import io.eeaters.delivery.core.Account;
import io.eeaters.delivery.core.enums.EnvEnum;

public interface AccountMock {

    static Account mockSF() {
        Account accountInfo = new Account();
        accountInfo.setAppId("1668137074");
        accountInfo.setAppKey("65dff9bb11508ee6327cde82087c11e4");

        accountInfo.setProductType(10);

        return accountInfo;
    }

    static Account mockDaDa() {
        Account account = new Account();
        account.setAppKey("dada00249ef2c1770ea");
        account.setAppSecret("1f995201f90a14feac6a99322a11006d");
        account.setSourceId("833831868");
        account.setCallback("www.baidu.com");
        account.setEnv(EnvEnum.QA);
        return account;
    }
}
