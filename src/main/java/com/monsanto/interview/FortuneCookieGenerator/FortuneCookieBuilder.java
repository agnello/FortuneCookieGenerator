package com.monsanto.interview.FortuneCookieGenerator;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/*
 * 
 * 
 * There was an issue happening because all requests were returning a cookie with the same information, 
 * the root cause was:
 * - This bean was originally created with @Scope("prototype")
 * - The same bean was being used for all requests as we are in a web application context 
 * - The first request was populating client, company and quote variables 
 * - From the second call onwards the variable values were not being changed, so the request was 
 *   returning a cookie with the same value of the first request submitted. The reasons were:
 * A) The same instance of the FutuneCookieBuilder bean was being used for all requests
 * B) There is restriction on setter methods(with*) to set values only when the current value is equal to "N/A"
 * C) The variables client, company and quote were being populated with values from the first request submitted
 * D) Conclusion? The variable values could not be changed after the first request
 * 
 * This bean has been changed to RequestScope instead of prototype in order to generate a new bean 
 * for every request submitted. This way we can make sure a new cookie will be generated when request .
 * 
 */
@Component
@RequestScope
public class FortuneCookieBuilder {

    private static final String NOT_DEFINED = "N/A";

    private String client = NOT_DEFINED;
    private String company = NOT_DEFINED;
    private String quote = NOT_DEFINED;

    FortuneCookieBuilder withClient(String client) {
        if (this.client.equals(NOT_DEFINED))
            this.client = client;
        return this;
    }

    FortuneCookieBuilder withCompany(String company) {
        if (this.company.equals(NOT_DEFINED))
            this.company = company;
        return this;
    }

    FortuneCookieBuilder withQuote(String quote) {
        if (this.quote.equals(NOT_DEFINED))
            this.quote = quote;
        return this;
    }

    FortuneCookie build() {
        return new FortuneCookie("Hi "+client+"! Thanks for buying at "+company+" : And remember: "+quote);
    }

}
