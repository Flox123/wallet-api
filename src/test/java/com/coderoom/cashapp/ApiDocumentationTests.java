package com.coderoom.cashapp;

import com.coderoom.cashapp.statement.category.StatementCategoryResponse;
import com.coderoom.cashapp.wallet.WalletForm;
import com.coderoom.cashapp.wallet.WalletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liquibase.repackaged.org.apache.commons.collections4.MultiValuedMap;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.MultiValueMapAdapter;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("int-test")
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiDocumentationTests {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;


    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }


    @Test
    public void test1_createWallet() throws Exception {
        WalletForm walletForm = new WalletForm();
        walletForm.setName("Main Wallet");

        WalletResponse walletResponse = WalletResponse.builder().name("Main Wallet").id(1L).build();
        String wallet = new ObjectMapper().writeValueAsString(walletForm);
        String walletResponsejson = new ObjectMapper().writeValueAsString(walletResponse);

        mockMvc.perform(put("/api/v1/wallet").content(wallet).contentType("application/json")).andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().json(walletResponsejson))
                .andDo(document("index"));
    }


    @Test
    public void test2_findWalletById() throws Exception {
        WalletResponse walletResponse = WalletResponse.builder().name("Main Wallet").id(1L).build();

        String walletResponsejson = new ObjectMapper().writeValueAsString(walletResponse);

        mockMvc.perform(get("/api/v1/wallet/1")
                .contentType("application/json")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(walletResponse)))
                .andDo(document("{methodName}"));
    }


    @Test
    public void test3_findAllWallet() throws Exception {
        WalletResponse walletResponse = WalletResponse.builder().name("Main Wallet").id(1L).build();
        mockMvc.perform(get("/api/v1/wallet")
                .contentType("application/json")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(Arrays.asList(walletResponse))))
                .andDo(document("{methodName}"));
    }

    @Test
    public void test4_createStatement_category() throws Exception {

        StatementCategoryResponse statementCategoryResponse = StatementCategoryResponse.builder()
                .id(100L).name("FOOD").build();

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("wallet" , "1");
        params.add("category", "FOOD");

        mockMvc.perform(post("/api/v1/statement/category").contentType("application/json").params(params)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(statementCategoryResponse)))
                .andDo(document("{methodName}"));
    }

    @Test
    public void test5_find_statemenet_category() throws Exception {
        StatementCategoryResponse statementCategoryResponse = StatementCategoryResponse.builder()
                .id(100L).name("FOOD").build();

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("wallet" , "1");

        mockMvc.perform(get("/api/v1/statement/category").contentType("application/json").params(params)).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(Arrays.asList(statementCategoryResponse))))
                .andDo(document("{methodName}"));
    }


}
