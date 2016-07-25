package kr.co.leem.jpa.example.repositories;

import kr.co.leem.jpa.example.entities.blog.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Dream on 2016-07-22.
 */
@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Long>, QueryDslPredicateExecutor<BlogComment> {
}
