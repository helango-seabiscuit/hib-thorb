package com.hemalatha.db.performance.Jpadatarepositories;

import com.hemalatha.db.performance.config.DataDomainConfig;
import com.hemalatha.db.performance.config.SpringDataJPAConfig;
import com.hemalatha.db.performance.model.Post;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = { SpringDataJPAConfig.class })
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Before
    public void setUp() throws Exception {
        Post p = new Post();
        p.setId(1);
        p.setTitle("Hello test");
        postRepository.save(p);
    }


    @After
    public void tearDown() throws Exception {
        postRepository.delete(1);
    }

    @Test
    public void findById() throws Exception {
        Post p = postRepository.findOne(1);
        assertNotNull(p);
        System.out.println(p);
    }



}