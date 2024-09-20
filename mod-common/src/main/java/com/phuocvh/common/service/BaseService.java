package com.phuocvh.common.service;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Optional;

public abstract class BaseService {
  protected <T> T getFirst(List<T> list) {
    return CollectionUtils.isEmpty(list) ? null : list.get(0);
  }

  protected <T> T getLast(List<T> list) {
    return CollectionUtils.isEmpty(list) ? null : list.get(list.size() - 1);
  }

  protected  <T> Optional<T> getFirstOptional(List<T> list) {
    return Optional.ofNullable(CollectionUtils.isEmpty(list) ? null : list.get(0));
  }
}
