package com.redhat.restcruddatagrid.infinispan.model;
 
import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable {
  
  private long id;
  private String info;
    
  public User(long id) {
      this.id= id;
      this.info = "Here is a info of User with id = " + id;
  }
    
  public long getId() {
      return id;
  }
  public void setId(long id) {
      this.id = id;
  }
  public String getInfo() {
      return info;
  }
  public void setInfo(String info) {
      this.info = info;
  }
    
  @Override
  public String toString() {
      return this.info;
  }
}