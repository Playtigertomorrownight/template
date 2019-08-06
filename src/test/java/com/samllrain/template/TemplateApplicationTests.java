package com.samllrain.template;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.smallrain.template.TemplateApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TemplateApplication.class)
public class TemplateApplicationTests {
/*
  @Autowired
  private UserMapper userMapper;
  
  @Test
  public void addUser() {
    log.info("--- add user --");
    User user = createUser();
    Assert.assertEquals(1, userMapper.insert(user));
  }

  
  @Test
  public void testSelect() {
      log.info(("----- selectAll method test ------"));
      List<User> userList = userMapper.selectList(null);
      Assert.assertEquals(6, userList.size());
      userList.forEach(System.out::println);
  }
  
  private  User createUser() {
    User user = new User();
    user.setId(BaseUtils.createUuid());
    user.setAge(new Random().nextInt(70));
    user.setName(BaseUtils.getRandomString(10,"",""));
    user.setEmail(BaseUtils.getRandomString(8,"","@qq.com"));
    return  user;
  }*/
  
}
