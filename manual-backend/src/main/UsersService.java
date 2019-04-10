package com.build.tools.training.web;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.apache.commons.io.input.BOMInputStream;

public class UsersService {

    public List<User> parseUsers() throws IOException {
        List<User> users = new ArrayList<>();

        try (InputStream is = UsersService.class.getClassLoader().getResourceAsStream("users.csv");
             Reader reader = new InputStreamReader(new BOMInputStream(is), UTF_8);
             CSVParser parser = getParser(reader)) {

            for (CSVRecord record : parser) {
                User user = User.builder()
                        .name(record.get("Name"))
                        .address(record.get("Address"))
                        .age(Integer.parseInt(record.get("Age")))
                        .build();

                users.add(user);
            }
        }

        return users;
    }

    private CSVParser getParser(Reader reader) throws IOException {
        return CSVFormat.DEFAULT
                .withHeader("Name", "Address", "Age")
                .withSkipHeaderRecord()
                .withDelimiter(';')
                .withQuote('"')
                .withQuoteMode(QuoteMode.ALL)
                .parse(reader);
    }
}
