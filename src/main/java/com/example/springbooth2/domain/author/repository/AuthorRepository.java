package com.example.springbooth2.domain.author.repository;

import com.example.springbooth2.domain.author.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, String> {
}
