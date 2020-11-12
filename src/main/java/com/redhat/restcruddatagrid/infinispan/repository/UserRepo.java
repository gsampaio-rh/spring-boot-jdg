package com.redhat.restcruddatagrid.infinispan.repository;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
import com.redhat.restcruddatagrid.infinispan.model.User;
 
@Service
@CacheConfig(cacheNames="user")
public class UserRepo {
  Logger log = LoggerFactory.getLogger(this.getClass());
  
  @Cacheable(key="#id")
  public User findByCode(long id) {
      log.info("---> Loading user with id '" + id + "'");
      return new User(id);
  }
    
  @CachePut(key="#id")
  public User putUserToCache(long id){
      String info = String.format("---> PUT user with id = %d to Cache", id);
      log.info(info);
      return new User(id);
  }   
    
  @CacheEvict(allEntries = true)
  public void evictAllEntries(){
      log.info("---> Evict All Entries.");
  }
    
  @CacheEvict(key="#id")
  public void evictEntry(long id){
      log.info("---> Evict User with id = " + id);
  }
}