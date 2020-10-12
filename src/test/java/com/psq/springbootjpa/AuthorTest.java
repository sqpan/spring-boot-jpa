package com.psq.springbootjpa;

import com.alibaba.fastjson.JSON;
import com.psq.springbootjpa.domain.Author;
import com.psq.springbootjpa.domain.AuthorRepository;
import com.psq.springbootjpa.domain.Wallet;
import com.psq.springbootjpa.domain.WalletRepository;
import com.psq.springbootjpa.service.AuthorService;
import net.minidev.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private AuthorService authorService;

    @Test
    public void saveAuthorTest() {
        Author author = new Author();
        author.setNickName("Yegar");
        author.setPhone("13801231234");
        author.setSignDate(new Date());
        author.setWallet(new Wallet(new BigDecimal(188.23)));
        authorRepository.save(author);
    }

    @Test
    public void updateAuthor() {
        Author author = authorService.findAuthor(11L);
        author.setPhone("158012312345");
        Wallet wallet = author.getWallet();
        wallet.setBalance(new BigDecimal(888.88));
        author.setWallet(wallet);
        authorService.updateAuthor(author);
    }

    @Test
    public void findAuthorTest() {
        Author author = authorService.findAuthor(11L);
        System.out.println(JSON.toJSONString(author,true));
    }

    @Test
    public void deleteAuthorTest() {
        authorService.deleteAuthor(11L);
    }

    @Test
    public void findWalletAuthorTest() {
        Wallet wallet = walletRepository.findById(14L).orElse(null);
        System.out.println(JSON.toJSONString(wallet,true));
    }

    @Test
    public void findAuthorPageTest() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1, 5, sort);
        Page<Author> page = authorRepository.findAll(pageable);
        System.out.println(JSON.toJSONString(page, true));
    }

    @Test
    public void transactionTest() {
        authorService.updateAuthor();

    }
}
