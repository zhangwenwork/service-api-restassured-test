package com.blog.adapters.persistence;

import java.io.Serializable;

public interface PersistenceObject<T> extends Serializable {
    T toDomainModel();
}
