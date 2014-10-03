package iit.csp595.service;

import iit.csp595.bean.GenericPageBean;

public interface Service<T> {

  GenericPageBean<T> createBean();
}
