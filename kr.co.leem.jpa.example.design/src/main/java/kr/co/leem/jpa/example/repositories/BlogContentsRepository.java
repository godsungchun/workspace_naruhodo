package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.blog.BlogContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-07-22.
 */
@Repository
public interface BlogContentsRepository extends JpaRepository<BlogContents, Long> {
}
