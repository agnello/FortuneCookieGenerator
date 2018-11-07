package com.monsanto.interview.FortuneCookieGenerator;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuoteRepository {

    private static List<String> quotes = new ArrayList<String>() {{
        add("A friend asks only for your time not your money.");
        add("If winter comes, can spring be far behind?");
        add("A smile is your passport into the hearts of others.");
        add("Enjoy the good luck a companion brings you.");
        add("The greatest risk is not taking one.");
        add("Land is always on the mind of a flying bird.");
        add("You must try, or hate yourself for not trying.");
        add("You can make your own happiness.");
        add("You can learn much from people who are different from you.");
        add("To achieve wisdom, you must first desire it.");
    }};

    public String getRandomQuote() {
        return quotes.get((int)(Math.random()*quotes.size()));
    }

}
